package parkingappcalculations;

import javax.lang.model.util.ElementScanner6;


//Calandar was part of a stretch feature we couldn't fully implement
//but we implemented a base for it and decided to keep its partial functionality
public class Calandar {

    //Contains checks if a key is in an array
    //This is used to check which months are 30 and which
    //are 31 days long, since a full calandar api was not used.
    public static boolean Contains(int key, int[] arr)
    {
        for (int i : arr)
        {
            if(i==key)
            {
                return true;
            }
        }
        return false;
    }

    //This returns the number of days in the current month.
    //This is used to create the calandar of the month, setting
    //game days to Saturdays, for example, and accounting for weekends
    public static int Days_In_Month(int month_num)
    {
        int days = 0;
        int[] short_months = {4, 6, 9, 11};
        if (month_num == 2)
        {
            days = 28;
        }
        else if (Contains(month_num, short_months))
        {
            days = 30;
        }
        else
        {
            days = 31;
        }
        return days;
    }

    //A fake calandar was used since the stretch feature of a
    //real calandar API was not implemented in time. This will
    //set different days to weekends, gamedays, or just normal days.
    public static int[] Create_Fake_Calander(int n)
    {
        int[] fake_calander = new int[n];
        for (int i = 0; i < n; i++)
        {
            if (i == 5)
            {
                fake_calander[i] = 2;
            }
            else if (i == 0 || i == 6)
            {
                fake_calander[i] = 0;
            }
            else
            {
                fake_calander[i] = 1;
            }
        }
        return fake_calander;
    }

    //Returns the calandar for the current month,
    //getting the number of days in the current month then
    //creating a fake calandar with those number of days.
    public static int[] Get_Calander(int month_num)
    {
        int num_of_days = Days_In_Month(month_num);
        int[] month_calander = Create_Fake_Calander(num_of_days);
        return month_calander;
    }

    //Returns the type of day it is, namely normal, gameday,
    //or weekend. Calls Current_Time.java to get the time
    //and extracts the month and day. Based on that day and 
    //the calandar for that month, it will return the type of day
    //that the current date is. If it is a Saturday in October, then
    //it would be a game day, for example.
    public static String Day_Type()
    {
        String temp = Current_Time.Get_Time();
        String month = "";
        String day = "";
        if (temp != null) 
        {
            month = temp.substring(4, 6);
            day = temp.substring(7, 9);
        } 
        else
        {
            month = "03";
        }
        //String month = parse temp
        int month_num = 0;
        int day_num = 0;
        try{
            month_num = Integer.parseInt(month);
            day_num = Integer.parseInt(day);
        } catch (Exception e){

        }
        String day_type = "";
        int[] month_calander = Get_Calander(month_num);
        if (month_calander[day_num] == 0)
        {
            day_type = "weekend";
        }
        else if (month_calander[day_num] == 1)
        {
            day_type = "gameday";
        }
        else
        {
            day_type = "normal";
        }
        return day_type;
    }
}
