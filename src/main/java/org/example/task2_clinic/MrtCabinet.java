package org.example.task2_clinic;

public class MrtCabinet implements Runnable {
    private Clinic clinic;

    public MrtCabinet(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Patient patient = clinic.getCurrentPatient();
                if (patient != null) {
                    clinic.setMrtAvailable(false);
                    System.out.println(Clinic.getTime() + " MRT busy now. Patient " + patient.getName() + ".");
                    Thread.sleep(7000);
                    System.out.println(Clinic.getTime() + " MRT done with Patient " + patient.getName() + ".");
                    Thread.sleep(10); //delay for patient coming out first, then mrt is free. Needed for ordered log messages
                    clinic.setCurrentPatient(null);
                }
                clinic.setMrtAvailable(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
