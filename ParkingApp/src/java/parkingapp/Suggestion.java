
package parkingapp;

import java.util.*;

/**
 *
 * @author Sam and Luke LeGoullon
 */
public class Suggestion implements Comparable<Suggestion>{    
    
    private double score;
    private ParkingLot lot;
    private String buildingName;
    private double totalParkTime;
    
    
    public Suggestion(ParkingLot parkLot, String nameOfBuilding){
        lot = parkLot;
        buildingName = nameOfBuilding;
        totalParkTime = Lots_Calc.CalculateTime(lot, buildingName); //Static method from the lot calculator class
        score = Lots_Calc.CalculateScore(lot, buildingName, totalParkTime);
    }
    
    public double getScore(){
        return score;
    }
    
    public ParkingLot getLot(){
        return lot;
    }
    
    public String getBuildingName(){
        return buildingName;
    }
    
    public double getParkingtime(){
        return totalParkTime;
    }
    
    @Override
    public int compareTo(Suggestion other){
        if(this.score - other.score >= 0){
            return 1;
        } else {
            return -1;
        }
    }
    
    
    
}

