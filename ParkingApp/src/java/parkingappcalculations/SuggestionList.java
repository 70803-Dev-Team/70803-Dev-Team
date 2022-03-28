
package parkingappcalculations;

import java.util.*;


public class SuggestionList {
    
    private ArrayList<Suggestion> userSuggestions;
    
    //We have a list of parking lots, and for each parking lot we make a suggestion object (which has the score for the lot)
    public SuggestionList(ArrayList<ParkingLot> lotList, String buildingName){
        suggestLots(lotList, buildingName);
        sortSuggestions();
    }
    
    public ArrayList<Suggestion> getUserSuggestions(){
        return userSuggestions;
    }
    
    public void suggestLots(ArrayList<ParkingLot> lots, String buildingName){ //iterates through a list of lots and makes a list of suggestions that will be presented to the user
        for(ParkingLot lot : lots){
            Suggestion s = new Suggestion(lot, buildingName);
            userSuggestions.add(s);
        }
    }
    
    public void sortSuggestions(){
        Collections.sort(userSuggestions);
    }
    
}
