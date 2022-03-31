package parkingappcalculations;

//@author Samuel Hildebrand

import java.util.ArrayList;

public class SuggestionCompilation {
    private String[] lotNames = {"Touchdown Village 1",
        "Lot U",
        "Alex Box Lot",
        "Olympic Lot",
        "Lot C/ Visitor Parking",
        "Touchdown Village 2"};
    
    private ArrayList suggestions;
    
    public SuggestionCompilation(String buildingName){
        ArrayList parkingLots = new ArrayList();
        for (String lotName : lotNames){
            ParkingLot lot = new ParkingLot(lotName);
            parkingLots.add(lot);
        }
        SuggestionList suggestionList = new SuggestionList(parkingLots, buildingName);
        suggestionList.sortSuggestions();
        suggestions = suggestionList.getUserSuggestions();
        }
    
    public ArrayList<Suggestion> getSuggestions(){
        return suggestions;
    }
}
