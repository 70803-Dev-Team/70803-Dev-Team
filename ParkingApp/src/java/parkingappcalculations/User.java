package parkingappcalculations;

// @author Sam Hildebrand
public class User {
    private String userName;
    private String password;
    private Preferences userPreferences;
    
    public User(String name, String passwd){
        userName = name;
        password = passwd;
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
}
