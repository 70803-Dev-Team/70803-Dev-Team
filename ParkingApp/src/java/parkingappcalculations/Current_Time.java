package parkingappcalculations;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

//Utilizing the system's ability to get current date and time
//Used in Calandar.java
public class Current_Time 
{  

  public int month_num;

  //Will return the number of the month
  //So if it is March, it will return 3
  //Pulls system info and parses for month
  public static int Get_Month()
  {
      String temp = Get_Time();
      String month = "";
      if (temp != null) 
      {
          month = temp.substring(4, 6);
      } 
      else
      {
          month = "03";
      }
      //String month = parse temp
      int month_num = 0;
      try {
        Integer.parseInt(month);   
      } catch (Exception e){
          
      }
      return month_num;
  }

  public static String Get_Time() 
  {  
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime cur_date_time = LocalDateTime.now();
    String cur_time_dtf = dtf.format(cur_date_time);
    return cur_time_dtf;
  }  
}  
