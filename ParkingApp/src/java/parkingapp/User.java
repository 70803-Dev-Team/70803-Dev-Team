/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingapp;

/**
 *
 * @author sam
 */
public class User {
    private String userName;
    private String password;    
    
    public User(String name, String passwd){
        userName = name;
        password = passwd;
    }
    boolean isValidUser(){
       return userName != null;
    }
}
