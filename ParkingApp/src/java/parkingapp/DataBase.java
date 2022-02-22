/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingapp;

/**
 *
 * @author sam
 */
public class DataBase {
    public User getUser(String userName){
        User user = new User("test Name", "test Password");
        return user;
    }
    public Suggestion getSuggestion(String lotName){
        Suggestion suggestion = new Suggestion(lotName);
        return suggestion;
    }
}
