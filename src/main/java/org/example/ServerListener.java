package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerListener {

    private ServerSocket serverSocket;
    private static ArrayList<ClientHandler> clients;

    public void start() throws IOException {
        serverSocket = new ServerSocket(27015);
        ChatLog log = new ChatLog();

        while (true) {
            Socket incommingConnection = serverSocket.accept();
            ClientHandler client = new ClientHandler(incommingConnection, log);
            clients.add(client);
            Thread clientThread = new Thread(client);
            clientThread.start();
        }
    }

    public ServerListener(){
        clients = new ArrayList<>();
    }

    public static List<ClientHandler> getClients(){
        return clients;
    }

    public static void removeClient(ClientHandler clientHandler){
        System.out.println("Client "+clientHandler+" is deleted");
        clients.remove(clientHandler);
    }
}
