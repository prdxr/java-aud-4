package org.example.task2_clinic;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        Thread therapistThread = new Thread(new Therapist(clinic));
        MrtCabinet mrt = new MrtCabinet(clinic);
        Thread mrtThread = new Thread(mrt);

        LocalDateTime currentDateTime = LocalDateTime.now();

        therapistThread.start();
        mrtThread.start();

        for (int i = 1; i <= 10; i++){
            Patient patient = new Patient("#" + i);
            clinic.addPatinet(patient);
        }
    }
}
