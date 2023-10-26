package org.example.task1_mfc;

public class CitizenCounter {
    private int totalYoung, totalElder, totalBusiness;
    private int quitYoung, quitElder, quitBusiness;

    public void addCitizen(String type, boolean rageQuit){
        switch (type){
            case "young":
                totalYoung++;
                if (rageQuit) { quitYoung++; }
                break;
            case "elder":
                totalElder++;
                if (rageQuit) { quitElder++; }
                break;
            case "business":
                totalBusiness++;
                if (rageQuit) { quitBusiness++; }
                break;
        }
    }

    public void getStats(){
        System.out.println("---==Ragequit Statistics==---");
        System.out.println("YOUNG    - total: "+totalYoung+" ragequit: "+quitYoung+" ("+quitYoung*100/totalYoung+"%)");
        System.out.println("ELDER    - total: "+totalElder+" ragequit: "+quitElder+" ("+quitElder*100/totalElder+"%)");
        System.out.println("BUSINESS - total: "+totalBusiness+" ragequit: "+quitBusiness+" ("+quitBusiness*100/totalBusiness+"%)");
        System.out.println("---=======================---");
    }
}
