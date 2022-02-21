/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkingapp;

/**
 *
 * @author sam
 */
public class Suggestion {
    private String buildingName;
    
    public static String table(){
        return "found";
    }
    public Suggestion(String name){
        buildingName = name;
    }
}
