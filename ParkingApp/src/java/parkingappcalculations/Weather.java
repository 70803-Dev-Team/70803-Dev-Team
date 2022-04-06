package parkingappcalculations;

//Note: for future implementation, make a real weather API, we are down a team member so this was taken off the lsit
public class Weather {  

    public Weather(){
        
    }
    
    public String Randomize_Weather(int month)
    {
        String weather = "";
        if(month < 2 || month > 10) //winter
        {
            weather = "snow";
        }
        else if (month > 1 && month < 4)
        {
            weather = "rain";
        }
        else if (month > 3 && month < 7)
        {
            weather = "sun";
        }
        else //
        {
            weather = "cloudy";
        }
        return weather;
    }

    public String Get_Weather()
    {
        String weather = "Rainy";
        int month = Current_Time.Get_Month();
        weather = Randomize_Weather(month); //in place of implementing API
        return weather;
    }
}
