package org.example.bank;

public class Client implements Runnable {
    Window window;

    public Client(Window window){
        this.window = window;
    }

    @Override
    public void run(){
        window.service(this);
        System.out.println("Client served.");
    }
}
