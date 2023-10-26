package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;
    private final ChatLog chatLog;

    @Override
    public void run(){
        try{
            in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()
                    )
            );
            out = new BufferedWriter(
                            new OutputStreamWriter(
                                    clientSocket.getOutputStream()
                            )
            );

            String nickname = in.readLine();
            chatLog.put(nickname + " connected to chat",this);

            while (!Thread.currentThread().isInterrupted()){
                String message = in.readLine();

                if (Objects.isNull(message)){
                    break;
                }
                chatLog.put(nickname + ": " + message, this);
                System.out.println(nickname + ": " + message);
            }
            chatLog.put(nickname + " disconnected from chat",this);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        ServerListener.removeClient(this);
    }

    public void sendMessageToCLient(String msg) throws IOException{
        if (!clientSocket.isOutputShutdown()){
            out.write(msg);
            out.newLine();
            out.flush();
        }
    }

    public ClientHandler(Socket clientSocket, ChatLog chatLog){
        this.clientSocket = clientSocket;
        this.chatLog = chatLog;
    }
}
