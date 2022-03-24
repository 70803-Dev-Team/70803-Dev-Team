
package parkingapp;
import java.util.Calendar;

public class Rating {
    
    //This is the individual user Rating (1-5), that will be used to calculate how long it will take to find parking spot/if there is a parking spot available
    //The user is given Suggestions -- lsit of the "scores" of the parking lot -- and they have to pick the parking lot after they park, and then rate it.
    
    private int dayOfWeek; //Sunday -> Saturday, 0 --> 6
    private int month; //January --> December, 0 --> 11
    private int dayOfMonth;
    private int year;
    private int ratingScore;
    private ParkingLot ratedLot;
    private User userThatRated;
    
    public Rating(ParkingLot lot, User user, int userRating){
        ratingScore = userRating;
        Calendar cal = Calendar.getInstance(); //calendar info at the time the object is created
        dayOfWeek = cal.get(cal.DAY_OF_WEEK);
        month =  cal.get(cal.MONTH);
        dayOfMonth = cal.get(cal.DAY_OF_MONTH);
        year = cal.get(cal.YEAR);
        
        ratedLot = lot;
        userThatRated = user;
    }
    
    public int getScore(){
        return ratingScore;
    }
    
    public void changeScore(int newScore){
        ratingScore = newScore;
    }
    
    public User getUser(){
        return userThatRated;
    }
    
    public ParkingLot getLot(){
        return ratedLot;
    }
    
    public String toString(){
        String s = "User: " + userThatRated + "\n Lot: " + ratedLot + "Score: " + ratingScore;
        return s;
    }

}
