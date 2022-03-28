// @author Max Reulet

package parkingappcalculations;

import java.util.Scanner;

public class Preferences {
    
    private String parkPass;
    private int speed;
    private String[] schedule;
    Scanner in = new Scanner(System.in);
    
    public Preferences(String parkingPass, int speedMPH, String[] classSchedule) {
        this.parkPass = parkingPass;
        this.speed = speedMPH;
        this.schedule = classSchedule;
    }
    
    public void addPass() {
        System.out.println("Please enter type of parking pass you own: ");
        parkPass = in.nextLine();
        if(parkPass.equals("A") || parkPass.equals("B") || parkPass.equals("C") || parkPass.equals("D")) {
            System.out.println("You have parking pass " + parkPass);
        }
        else {
            System.out.println("Please enter a valid parking pass.");
            addPass();
        }
    }
    
    public void userSpeed () {
        System.out.println("Please enter the speed you walk in miles per hour: ");
        speed = in.nextInt();
        System.out.println("Updated walking speed in miles per hour is " + speed);
    }
    
    public void userSchedule () {
        System.out.println("Please enter your class schedule in the following format: ex CSC 3380 10:30-12 T-Th");
        System.out.println("How many classes are you currently in?");
        int numClass = Integer.parseInt(in.nextLine());
        schedule = new String[numClass];
        for(int i = 0; i < schedule.length; i++) {
            System.out.println("Enter class schedule:  ");
            schedule[i] = in.nextLine();
        }
        for (String classes:schedule) {
            System.out.println("Updated Schedule");
            System.out.println(classes);
        }
    }
}
