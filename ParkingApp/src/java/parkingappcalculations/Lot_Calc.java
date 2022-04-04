package parkingappcalculations;

import java.sql.Array;
import java.util.ArrayList;

public class Lot_Calc {

    public int space;
    public int capacity;
    public double time_to_find_spot;
    public int distance;
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

    public static int Avg_Space(ParkingLot lot)
    {
        ArrayList<Integer> ratings;
        int rating = 0;
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

    public static double Find_Spot_Time(int capacity, int space)
    {
        int time = 2; //set to 2 minutes until capacity feature implemented
        //time = space/capacity;
        return time;
    }

    public static int Lot_To_Building(ParkingLot lot, String building, int space, String permit)
    {
        int distance = 0;
        distance = Graph.MinDistance(lot, building, permit);
        distance = distance+ 100 * space; //5000ft + 400ft for walking through lot
        return distance; //in feet?
    }

    public static double Walk_Time(int distance)
    {
        double time = 0;
        User user = new User("user", "password");
        int walk_speed = user.getWalkingSpeed();
        
        //convert mph to f/min
        int feet_per_hour = 5280*walk_speed;
        int feet_per_minute = feet_per_hour/60;
        time = distance/feet_per_minute;
        
        return time;
    }

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

    public static double CalculateTime(ParkingLot lot, String building) //ADD STRING PERMIT TO PARAMETER AND DELETE PERMIT = "COMMUTER"
    {
        int space = Avg_Space(lot);
        int capacity = 1;//Database.Lot_Capacity(lot);
        double time_to_find_spot = Find_Spot_Time(capacity, space);
        String permit = "commuter";
        int distance = Lot_To_Building(lot, building, space, permit); //in feet
        double time_to_walk = Walk_Time(distance);
        double time = time_to_find_spot + time_to_walk;
        
        return time;
    }

    public static double CalculateScore(ParkingLot lot, String building, double time)
    {
        double score = 0;
        String day_type = Calandar.Day_Type();
        double weather_delay = Weather_Delay();
        int space = Avg_Space(lot);
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
        return score;
    }
}
