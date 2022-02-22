package parkingapp;

// @author Sam Hildebrand
public class DataBase {
    public static User getUser(String userName){
        User user = new User(userName, "password");
        return user;
    }
    public Suggestion getSuggestion(String lotName){
        Suggestion suggestion = new Suggestion(lotName);
        return suggestion;
    }
    
    public static void storeRating(int rating){
        
    }
}
