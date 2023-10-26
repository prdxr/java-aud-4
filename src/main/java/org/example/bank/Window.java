package org.example.bank;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Window {
    Semaphore semaphore = new Semaphore(2);
    public synchronized void service(Client client){
        try{
            semaphore.acquire();
            Thread.sleep(new Random().nextInt(1000));
            semaphore.release();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
