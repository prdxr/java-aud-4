package org.example.task1_mfc;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CitizenCounter counter = new CitizenCounter();
        MfcWindow window1 = new MfcWindow("young", counter);
        MfcWindow window2 = new MfcWindow("elder", counter);
        MfcWindow window3 = new MfcWindow("business", counter);

        int total = 20;

        for (int i = 0; i < total; i++){
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            int randomizer = new Random().nextInt(3);
            String currentType = "";
            MfcWindow currentWindow = null;

            switch (randomizer){
                case 0:
                    currentType = "young";
                    currentWindow = window1;
                    break;
                case 1:
                    currentType = "elder";
                    currentWindow = window2.checkIfBisy() ? window1 : window2;
                    break;
                case 2:
                    currentType = "business";
                    currentWindow = window3.checkIfBisy() ? window1 : window3;
                    break;
            }
            Citizen citizen = new Citizen(currentType, currentWindow, counter);
            Thread thread = new Thread(citizen);
            thread.start();
        }
        Thread.sleep(5000);
        counter.getStats();
    }
}
