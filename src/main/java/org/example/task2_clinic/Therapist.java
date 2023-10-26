package org.example.task2_clinic;

import java.security.Policy;
import java.sql.Time;
import java.util.Date;

public class Therapist implements Runnable{
    private final Clinic clinic;
    private String current;

    public Therapist(Clinic clinic){
        this.clinic = clinic;
    }

    @Override
    public void run(){
        while (true){
            try{
                Patient patient = clinic.getNextPatient();
                current = patient.getName();
                System.out.println(Clinic.getTime() + " Therapist busy now. Patient " + current + ".");
                Thread.sleep(3000);
                System.out.println(Clinic.getTime() + " Therapist done with Patient " + current + ".");
                synchronized (clinic){
                    while (!clinic.getMrtAvailable()){
                        System.out.println(Clinic.getTime() + " MRT unavailable rn");
                        clinic.wait();
                    }
                }
                clinic.setCurrentPatient(patient);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
