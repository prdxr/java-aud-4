package org.example.task1_mfc;

public class Citizen implements Runnable{
    private String type;
    private MfcWindow window;
    private CitizenCounter counter;

    public Citizen(String type, MfcWindow window, CitizenCounter counter){
        this.type = type;
        this.window = window;
        this.counter = counter;
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
            System.out.println("!!! Citizen " + this.getType() + " ragequit skillissue :clown: !!!");
            counter.addCitizen(this.getType(),true);
        }
    }
}
