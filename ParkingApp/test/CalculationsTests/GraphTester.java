package CalculationsTests;

//@author Samuel Hildebrand

import java.util.Scanner;
import parkingappcalculations.Graph;
import parkingappcalculations.ParkingLot;


public class GraphTester {
    
    private static String[] buildings = {"Patrick F Taylor", "Buisness Education Complex", 
        "Student Union", "The Library", "Cox Auditorium", "Lockett Hall", "Tiger Stadium", 
        "Design Building", "Law Center", "UREC"};
    
    private static String[] comLots = {"Touchdown Village West", "Front 9", "Touchdown Village East",
       "West Parker Blvd", "Parker Coliseum", "South Stadium East", "South Stadium West",
       "South Quad Dr. West", "ECE", "West Stadium 1", "West Stadium 2", "Bernie Moore", 
       "Natatorium", "Astr St West", "Edward Gay"};

    public static void main(String args[]) {
        int i = 1;
        for (String building : buildings) {
            System.out.println(i + " " + building + ":");
            for (String comLot : comLots){
                ParkingLot lot = new ParkingLot(comLot);
                System.out.printf("\n   %s - Distance: %.1f\n", comLot, Graph.MinDistance(building, lot, "Commuter"));
            }
            System.out.println("\n");
            i++;
        }               
    }
}
