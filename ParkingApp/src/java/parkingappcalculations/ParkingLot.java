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
    
    @Override
    public int compareTo(ParkingLot other){
        return this.getName().compareToIgnoreCase(other.getName());
    }

}
