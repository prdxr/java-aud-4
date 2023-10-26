package org.example.task2_clinic;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

public class Clinic {
    private final Queue<Patient> queue = new LinkedList<>();
    private boolean mrtAvailable = true;
    private Patient currentPatient;

    public synchronized void setCurrentPatient(Patient patient) {
        this.currentPatient = patient;
    }

    public synchronized Patient getCurrentPatient() {
        return currentPatient;
    }

    public synchronized void addPatinet(Patient patient){
        queue.add(patient);
        notify();
    }

    public synchronized Patient getNextPatient() throws  InterruptedException {
        while (queue.isEmpty() || !mrtAvailable){
            wait();
        }
        return queue.poll();
    }
    public synchronized void setMrtAvailable(boolean available) {
        mrtAvailable = available;
        notify();
    }
    public boolean getMrtAvailable() {
        return mrtAvailable;
    }

    public static LocalTime getTime(){
        return LocalTime.now();
    }
}
