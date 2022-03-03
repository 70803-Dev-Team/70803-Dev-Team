package parkingapp;

import java.sql.*;

// @author Sam Hildebrand
public class DataBase { 
    private final String userName="parking-user";
    private final String password="70803";
    private final String url="jdbc:mariadb://lsuparking.tech:3306/parkingapp";
    private final String driver="org.mariadb.jdbc.Driver";
    private Connection con;
    private Statement statement;
    
    // Constructor. This creates the connection to the database. 
    // All other fuctions are object oriented and will look something like
    // db.storeRating() see RateLot.java for an example.
    public DataBase(){
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, userName, password);
            statement = con.createStatement();
            System.out.println("Connected");
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    
    public User getUser(String userName){
        User user = new User(userName, "password");
        return user;
    }
    public Suggestion getSuggestion(String lotName){
        Suggestion suggestion = new Suggestion(lotName);
        return suggestion;
    }
    
    public void storeRating(String ParkingLot, String UserName, String rating){
        //Anytime you need to access the database you can surround it in this
        //try catch statment
        try {
            //The constructor creates "statement". To make an sql call, just 
            //pass a string to statement.execute("your call here");
            statement.execute("INSERT INTO ratings (ParkingLot, UserName, "
                    + "DayOfWeek, Month, DayOfMonth, Year, Rating) VALUES (\""
                    + ParkingLot + "\", \"" + UserName + "\", "
                    + "DAYOFWEEK(CURRENT_DATE), MONTH(CURRENT_DATE), "
                    + "DAY(CURRENT_DATE), YEAR(CURRENT_DATE), \"" + rating + "\");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
