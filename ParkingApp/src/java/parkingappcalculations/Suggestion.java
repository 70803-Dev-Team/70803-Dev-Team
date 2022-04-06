
package parkingappcalculations;

import java.util.*;

/**
 *
 * @author Sam Hildebrand and Luke LeGoullon
 */
public class Suggestion implements Comparable<Suggestion>{    
    
    private double score;
    private ParkingLot lot;
    private String buildingName;
    private double totalParkTime;
    private String userPermit;
    
    //Suggestions are given to the user to tell them where to park based on what takes the leat amount of time
    public Suggestion(ParkingLot parkLot, String nameOfBuilding){
        Lot_Calc lc = new Lot_Calc();
        lot = parkLot;
        buildingName = nameOfBuilding;
        //userPermit = User.getPermit();
        totalParkTime = lc.CalculateTime(lot, buildingName, "commuter"); //Static method from the lot calculator class
        score = lc.CalculateScore(lot, buildingName, totalParkTime);
    }
    
    //Getter methods
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
            return -1;
        } else {
            return 1;
        }
    }
    
    
    
}

