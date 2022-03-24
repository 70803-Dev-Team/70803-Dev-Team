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
    
    
    // Singlton design pattern. Call DataBase.getInstance() to get db object
    // to access the database functions.
    private static DataBase db;
  
    private DataBase(){
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, userName, password);
            statement = con.createStatement();
            System.out.println("Connected");
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    
    public static DataBase getInstance(){
        if (db == null){
            db = new DataBase();
        }
        return db;
    }
    // end singlton design pattern
    
    public User getUser(String userName){
        String password = null;
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE UserName=\"" + userName + "\";");
            rs.next();
            password = rs.getString("Password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (password == null){
            return null;
        }
        User user = new User(userName, password);
        return user;
    }
    
        public void addUser(String userName, String password){
        try {
            statement.execute("INSERT INTO users (UserName, Password)"
                    + " VALUES (\"" + userName + "\", \"" + password + "\");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    public Suggestion getSuggestion(String lotName){
        Suggestion suggestion = null;
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
    
    public int getRating(String parkingLot){
        int ratingInt = 0;
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE ParkingLot=\"" + parkingLot + "\";");
            rs.next();
            String rating = rs.getString("Rating");
            ratingInt = Integer.parseInt(rating);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ratingInt;
    }
}
