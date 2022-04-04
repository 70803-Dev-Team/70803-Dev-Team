
package parkingapp;

import java.util.*;

public class LotList {
    
    //General information about the lots -- prints name, capacity, the closest Building, etc.
    private ArrayList<ParkingLot> lots;
    private int amountOfLots;
    
    public LotList(){
        //Sort lots alphabetically
        Collections.sort(lots);
        amountOfLots = lots.size();
    }
    
    //Getter methods
    public ArrayList<ParkingLot> getLotList(){
        return lots; 
    }
    
    public int getAmountOfLots() {
        return amountOfLots;
    }
    
    public void addLot(ParkingLot p){
        lots.add(p);
        amountOfLots++;
        Collections.sort(lots);
    }
    
    //Tester, prints all the information about the lots
     public void printInfo(ArrayList<String> allBuildings){
        for(ParkingLot p : lots){
            String name = p.getName();
            int capacity = p.getCapacity();
            String closestBuilding = p.findClosestBuilding(allBuildings);
            System.out.println("Parking Lot: " + name + "Capacity " + capacity + "ClosestBuilding: " + closestBuilding);
        }
    }
    
}
