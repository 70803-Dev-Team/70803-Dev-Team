package parkingappcalculations;

import java.util.*;

public class ParkingLot implements Comparable<ParkingLot> {
   
    private String name;
    private int capacity;
    private boolean isFavorite; //stretch feature
    private double averageRating;
    private ArrayList<Rating> lotRatingList;

    
    //Does each parking lot have an arrayList of Lot ratings at that time?
    public ParkingLot(String lotName, double lotPercentFull, int lotCapacity) {
        name = lotName;
        capacity = lotCapacity;
    }
    
    public ParkingLot(String lotName){
        name = lotName;
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
    
    public void addLotRating(double rating){
        lotRatingList.add(rating);
    }
    
    //Override compareTo in order to compare parking lots alphabettically in the lotList
    @Override
    public int compareTo(ParkingLot other){
        return this.getName().compareToIgnoreCase(other.getName());
    }
   
   //Find the closest building to to the ParkingLot -- implement in LotList Stretch Feature
    public String findClosestBuilding(ArrayList<String> allBuildings){
        
        String closestBuilding = allBuildings.get(0);
        double closestDistance = Lot_Calc.CalculateTime(this, closestBuilding);
        
        for(String b : allBuildings){
            double distance = Lot_Calc.CalculateTime(this, b);
            if(distance < closestDistance){
                closestBuilding = b;
            }
        }
        
        return closestBuilding;
    }
   
   

}
