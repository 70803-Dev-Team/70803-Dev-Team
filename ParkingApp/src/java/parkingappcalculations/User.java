//package parkingappcalculations;

// @author Sam Hildebrand
public class User {
    private String userName;
    private String password;
    private Preferences userPreferences;
    private String permitType;
    
    public User(String name, String passwd){
        userName = name;
        password = passwd;
    }
    
    public User(String name, String passwd, String permit){
        userName = name;
        password = passwd;
        permitType = permit;
    }
    public boolean isValidUser(){
       return userName != null;
    }

    public boolean compareTo(User comparingUser) {
        return comparingUser.password.equals(password) && comparingUser.userName.equals(userName);
    }
    
    public String getUserName(){
        return userName;
    }
    
   public int getWalkingSpeed(){
        return 4;
    }
   
   public String getPermit(){
       return permitType;
   }
}
