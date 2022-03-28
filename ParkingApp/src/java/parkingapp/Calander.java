import javax.lang.model.util.ElementScanner6;

public class Calander {

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

    public static int[] Get_Calander(int month_num)
    {
        int num_of_days = Days_In_Month(month_num);
        int[] month_calander = Create_Fake_Calander(num_of_days);
        return month_calander;
    }

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
        int month_num = Integer.parseInt(month);
        int day_num = Integer.parseInt(day);
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
