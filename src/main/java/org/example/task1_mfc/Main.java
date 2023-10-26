package org.example.task1_mfc;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        MfcWindow window1 = new MfcWindow("young");
        MfcWindow window2 = new MfcWindow("elder");
        MfcWindow window3 = new MfcWindow("business");

        int total = 100;

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
            Citizen citizen = new Citizen(currentType, currentWindow);
            Thread thread = new Thread(citizen);
            thread.start();
        }
    }
}
