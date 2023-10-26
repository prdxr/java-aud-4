package org.example;

import org.example.bank.Client;
import org.example.bank.Window;
import org.example.chat.ServerListener;

import java.io.IOException;

public class Main {
//    public static void main(String[] args) throws IOException {
//        ServerListener serverListener = new ServerListener();
//        serverListener.start();
//    }

    public static void main(String[] args) {
        Window window = new Window();

        while(true){
            Client client = new Client(window);
            Thread thread = new Thread(client);
            thread.start();
        }
    }
}