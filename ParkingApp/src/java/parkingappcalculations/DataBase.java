package parkingappcalculations;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.File;
import java.util.Scanner;

// @author Sam Hildebrand
public class DataBase { 
    private String userName;
    private String password;
    private String url;
    private String driver;
    private Connection con;
    private Statement statement;
    
    
    // Singlton design pattern. Call DataBase.getInstance() to get db object
    // to access the database functions.
    private static DataBase db;
  
    private DataBase(){
        try {
            File credentialsFile = new File("LoginCredentials.txt");
            Scanner sc = new Scanner(credentialsFile);
            userName = sc.next();
            password = sc.next();
            url = sc.next();
            driver = sc.next();
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
        String permitType = null;
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM users WHERE UserName=\"" + userName + "\";");
            rs.next();
            password = rs.getString("Password");
            permitType = rs.getString("PermitType");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (password == null){
            return null;
        }
        User user = new User(userName, password, permitType);
        return user;
    }
    
        public void addUser(String userName, String password, String permitType){
        try {
            statement.execute("INSERT INTO users (UserName, Password, PermitType)"
                    + " VALUES (\"" + userName + "\", \"" + password + "\", \"" + permitType + "\");");
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
        Calendar calendar = Calendar.getInstance();
        int ratingInt = -9999;
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM ratings WHERE ParkingLot=\"" + parkingLot + "\";");
            while (rs.next()){
                if (rs.getString("Month").equals(Integer.toString(calendar.get(Calendar.MONTH)+1))){
                    String rating = rs.getString("Rating");
                    ratingInt = Integer.parseInt(rating);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ratingInt;
    }
    
    public ArrayList<Integer> aggregateRatings(String parkingLot){
        ArrayList<Integer> ratings = new ArrayList<Integer>();
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM ratings WHERE ParkingLot=\"" + parkingLot + "\";");
            while (rs.next()){
                String rating = rs.getString("Rating");
                int ratingInt = Integer.parseInt(rating);
                ratings.add(ratingInt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ratings;
    }
}
