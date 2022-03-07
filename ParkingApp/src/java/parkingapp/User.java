package parkingapp;

// @author Sam Hildebrand
public class User {
    private String userName;
    private String password;
    private Preferences userPreferences;
    
    public User(String name, String passwd){
        userName = name;
        password = passwd;
    }
    boolean isValidUser(){
       return userName != null;
    }

    boolean compareTo(User comparingUser) {
        return comparingUser.password.equals(password);
    }
}
