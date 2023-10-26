package org.example.task1_mfc;

public class Citizen implements Runnable{
    private String type;
    private MfcWindow window;

    public Citizen(String type, MfcWindow window){
        this.type = type;
        this.window = window;
    }

    public String getType(){
        return type;
    }

    @Override
    public void run(){
        if(!window.checkIfBisy()){
            window.serveCitizen(this);
        }
        else{
            System.out.println("Citizen " + this.getType() + " ragequit skillissue :clown:");

        }
    }
}
