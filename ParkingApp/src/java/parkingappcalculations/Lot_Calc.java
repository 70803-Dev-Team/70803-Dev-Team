package parkingappcalculations;

import java.sql.Array;
import java.util.ArrayList;

public class Lot_Calc {

    public int space;
    public int capacity;
    public double time_to_find_spot;
    public double distance;
    public double time_to_walk;
    public double weather_delay;
    
    // public static int Lot_Capacity(String lot)
    // {
    //     int capacity = 0;
    //     capacity = Database.();
    //     return capacity;
    // }
    
    // public static int[] Aggregate_Ratings(String lot)
    // {
    //     int ratings[]; 
    //     ratings = database.();
    //     return ratings;
    // }

    //Finds the amount of spots currently used by cars.
    //Since we do not have access to cameras, we are using
    //user ratings on how full the lot is. This takes the average
    //of the ratings on how full the lot is. So a 3.5/5 is 70% full
    public static double Avg_Space(ParkingLot lot)
    {
        ArrayList<Integer> ratings;
        double rating = 4;
        DataBase db = DataBase.getInstance();
        ratings = db.aggregateRatings(lot.getName());
        int rating_count = ratings.size();
        
        for (int i = 0; i < rating_count; i++)
        {
             rating = rating + ratings.get(i);
        }
        if (rating > 0 && rating_count > 0){
            rating = rating/rating_count; 
        }
        
        return rating;
    }

    //This ended up being a stretch feature we could not fully implement
    //This function uses the capacity of the lot and the rating of how
    //full the lot is to find out how much time it takes to find
    //a spot. Capacity is not data we have access to.
    //So we set the time to find a spot to 2 minutes as a placeholder.
    public static double Find_Spot_Time(int capacity, int space)
    {
        int time = 2; //set to 2 minutes until capacity feature implemented
        //time = space/capacity;
        return time;
    }

    //This function calls a method in Graph.java to find the distance from
    //the user's designated building to a given lot.
    //We also include extra distance depending on how full the lot is
    //to account for walking from a spot in the back of the lot to the front.
    public static double Lot_To_Building(ParkingLot lot, String building, int space, String permit)
    {
        double distance = 0;
        distance = Graph.MinDistance(building, lot, permit);
        distance = distance+ 50*space; //5000ft + some ft for walking through lot
        return distance; //in feet?
    }

    //This function gets the walking speed a user sets in their profile settings
    //The walking speed is default at 4mph.
    //Once the walking speed is retrieved, it converts mph to feet per minute.
    public static double Walk_Time(int distance)
    {
        double time = 0;
        User user = new User("user", "password"); //placeholder user
        int walk_speed = user.getWalkingSpeed(); //returns 4 mph
        
        //convert mph to f/min
        int feet_per_hour = 5280*walk_speed;
        int feet_per_minute = feet_per_hour/60;
        time = Math.abs(distance)/feet_per_minute;
        
        return time;
    }

    //Another stretch feature we weren't able to fully implement
    //This function would use a weather api to find the weather for
    //the day, such as if it was raining, and modify the score based on that.
    //On a rainy day, it can be worthwhile to spend more time looking for a
    //good spot than immediately parking in the back and walking.
    public static double Weather_Delay()
    {
        String weather = Weather.Get_Weather();
        int weather_delay = 0;
        
        if(weather == "rainy")
        {
            weather_delay = 10;
        }
        else if (weather == "snow")
        {
            weather_delay = 5;
        }
        else
        {
            weather_delay = 0;
        }
        
        return weather_delay;
    }

    //Finds the time it takes to find a spot, park, and walk to the building
    //This calls the bulk of the main work.
    //The time to park includes how long it takes to find a spot, the distance to
    //the building from the spot, and how long it takes the user to walk to the building.
    public static double CalculateTime(ParkingLot lot, String building, String permit)
    {
        double space = Avg_Space(lot);
        double capacity = 1;//Database.Lot_Capacity(lot);
        double time_to_find_spot = Find_Spot_Time(capacity, space);
        double distance = Lot_To_Building(lot, building, space, permit); //in feet
        double time_to_walk = Walk_Time((int)distance);
        double time = time_to_find_spot + time_to_walk;
        
        return time;
    }

    //An extra feature that assigns a score to each lot
    //We know that the desirability of a lot depends on more than time.
    //For example, on rainy days, the time to find a spot matters less
    //than on a sunny day as a spot closer to the building is more valuable.
    //It also accounts for other days such as game days or weekends where
    //the parking situation is different. However, the stretch feature to
    //modify the suggested buildings based on game days or weekends was not implemented.
    public static double CalculateScore(ParkingLot lot, String building, double time)
    {
        double score = 0;
        String day_type = Calandar.Day_Type();
        double weather_delay = Weather_Delay();
        double space = Avg_Space(lot);
        double capacity = 1;//Database.Lot_Capacity(lot);
        double fullness = space/capacity;
        
        if(null == day_type)
        {
            score = 0;
        }
        else switch (day_type) {
            case "normal":
                score = 100 - fullness*10 - time*4 - weather_delay;
                break;
            case "weekend":
                score = 100 - fullness*5 - time*5 - weather_delay;
                break;
            case "game_day":
                score = 100 - fullness*10 - time*3 - weather_delay;
                break;
            default:
                score = 0;
                break;
        }     
        return Math.abs(score);
    }
}
