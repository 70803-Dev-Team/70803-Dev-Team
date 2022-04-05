package parkingappcalculations;

import java.util.*;

public class ParkingLot implements Comparable<ParkingLot> {
   
    private String name;
    private int capacity;
    private boolean isFavorite; //stretch feature
    private double averageRating;
    private ArrayList<Rating> lotRatingList;
    private String permitType;
    
    public ParkingLot(String lotName){
        name = lotName;
    }
    
    public ParkingLot(String lotName, String permit) {
        name = lotName;
        permitType = permit;
    }
    
    //Getter methods
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean getFavorite() {
        return isFavorite;
    }

    public double getAverageRating() {
        return averageRating;
    }
   
    public void favoriteLot(boolean favorite){
        isFavorite = favorite;
    }
    
    public String getPermit() {
        return permitType;
    }
    
    public void addLotRating(double rating){
        //lotRatingList.add(rating);
    }
    
    //Override compareTo in order to compare parking lots alphabettically in the lotList
    @Override
    public int compareTo(ParkingLot other){
        return this.getName().compareToIgnoreCase(other.getName());
    }
   
   //Find the closest building to to the ParkingLot -- implement in LotList Stretch Feature
    public String findClosestBuilding(ArrayList<String> allBuildings){
        
        String closestBuilding = allBuildings.get(0);
        double closestDistance = Lot_Calc.CalculateTime(this, closestBuilding, "commuter");
        
        for(String b : allBuildings){
            double distance = Lot_Calc.CalculateTime(this, b, "commuter");
            if(distance < closestDistance){
                closestBuilding = b;
            }
        }
        
        return closestBuilding;
    }
   
   

}