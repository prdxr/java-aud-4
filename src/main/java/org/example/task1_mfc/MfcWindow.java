package org.example.task1_mfc;

import java.util.Random;

public class MfcWindow {
    private String type;
    private boolean isBusy = false;
    public synchronized boolean checkIfBisy(){
        return isBusy;
    }
    public synchronized void setBusy(boolean condition){
        isBusy = condition;
    }
    public void serveCitizen(Citizen citizen){
        setBusy(true);
        System.out.println("Citizen "+citizen.getType()+" is being served at window " + type + ".");
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Citizen "+citizen.getType()+" served at window " + type + ".");
        setBusy(false);
    }

    public MfcWindow(String type){
        this.type = type;
    }
}
