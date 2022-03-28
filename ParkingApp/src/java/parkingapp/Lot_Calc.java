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
        // int[] ratings;
        int rating = 0;
        rating = DataBase.Aggregate_Ratings(lot);
        // int rating_count = ratings.length;
        // for (int i = 0; i < rating_count; i++)
        // {
        //     rating += ratings[i];
        // }
        // rating = rating/rating_count;
        return rating;
    }

    public static double Find_Spot_Time(int capacity, int space)
    {
        int time = 0;
        time = space/capacity;
        return time;
    }

    public static int Lot_To_Building(ParkingLot lot, String building, int space)
    {
        int distance = 0;
        distance = Graph.Distance(lot);
        distance = distance+100*space //5000ft + 400ft for walking through lot
        return distance; //in feet?
    }

    public static double Walk_Time(int distance)
    {
        double time = 0;
        int walk_speed = user.speed();
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
            weather_delay = 2;
        }
        else if (weather == "snow")
        {
            weather_delay = 1;
        }
        else
        {
            weather_delay = 0;
        }
        return weather_delay;
    }

    public static double CalculateTime(ParkingLot lot, String building)
    {
        int space = Avg_Space(lot);
        int capacity = Database.Lot_Capacity(lot);
        double time_to_find_spot = Find_Spot_Time(capacity, space);
        int distance = Lot_To_Building(lot, building, space); //in feet
        double time_to_walk = Walk_Time(distance);
        double time = time_to_find_spot + time_to_walk;
        return time;
    }

    public static double CalculateScore(ParkingLot lot, String building, double time)
    {
        double score = 0;
        String day_type = Calander.Day_Type();
        double weather_delay = Weather_Delay();
        double capacity = Database.Lot_Capacity(lot);
        if(day_type == "normal")
        {
            score = capacity*0.1 + time*0.8 + weather_delay*0.1;
        }
        else if (day_type == "weekend")
        {
            score = capacity*0.1 + time*0.6 + weather_delay*0.3;
        }
        else if (day_type == "game_day")
        {
            score = capacity*0.5 + time*0.4 + weather_delay*0.1;
        }
        else
        {
            score = 0;
        }
        return score;
    }
}