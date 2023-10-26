package org.example.chat;

import java.io.IOException;
import java.util.ArrayList;

public class ChatLog {
    private final ArrayList<String> chatHistory;
    private int pointer = 0;

    public void put(String message, ClientHandler clientSender) throws IOException{
        chatHistory.add(message);
        System.out.println(message);
        update(clientSender);
        pointer++;
    }

    private void update(ClientHandler clientSender) throws IOException{
        for (ClientHandler client : ServerListener.getClients()){
            if (client != clientSender){
                client.sendMessageToCLient(chatHistory.get(pointer));
            }
        }
    }

    public ChatLog(){
        chatHistory = new ArrayList<>();
    }
}
