
package parkingapp;

import java.util.*;

public class LotList {
    
    private ArrayList<ParkingLot> lots;
    private int amountOfLots;
    
    public LotList(){
        //Sort lots alphabetically
        Collections.sort(lots);
        amountOfLots = lots.size();
    }
    
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
    
    
}
