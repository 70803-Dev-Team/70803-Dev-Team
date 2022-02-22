/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
}
