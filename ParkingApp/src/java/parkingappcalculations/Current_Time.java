package parkingappcalculations;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

public class Current_Time 
{  

  public int month_num;

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
      int month_num = Integer.parseInt(month);
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