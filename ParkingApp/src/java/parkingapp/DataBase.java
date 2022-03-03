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
        try {
            statement.execute("INSERT INTO ratings (ParkingLot, UserName, Rating) VALUES (\""
            + ParkingLot + "\", \"" + UserName + "\", \"" + rating + "\");");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
