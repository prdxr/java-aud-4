package org.example;

import org.example.bank.Client;
import org.example.bank.Window;
import org.example.chat.ServerListener;

import java.io.IOException;

// !!! THIS MAIN IS FOR EXAMPLES ONLY !!!
// for tasks use [corresponding_package].Main

public class Main {
    public static void main(String[] args) throws IOException {
        ServerListener serverListener = new ServerListener();
        serverListener.start();

        Window window = new Window();

        while(true){
            Client client = new Client(window);
            Thread thread = new Thread(client);
            thread.start();
        }
    }

}