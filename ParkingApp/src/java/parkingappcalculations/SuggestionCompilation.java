package parkingappcalculations;

//@author Samuel Hildebrand

import java.util.ArrayList;
        
public class SuggestionCompilation {
        private ParkingLot[] allLots = {new ParkingLot("Touchdown Village West", "Commuter"), 
        new ParkingLot("Front 9", "Commuter"),
        new ParkingLot("Touchdown Village East", "Commuter"),
        new ParkingLot("West Parker BLVD", "Commuter"),
        new ParkingLot("Parker Coliseum", "Commuter"),
        new ParkingLot("South Stadium East", "Commuter"),
        new ParkingLot("South Stadium West", "Commuter"),
        new ParkingLot("South Quad Dr. West", "Commuter"),
        new ParkingLot("ECE", "Commuter"),
        new ParkingLot("West Stadium 1", "Commuter"),
        new ParkingLot("West Stadium 2", "Commuter"),
        new ParkingLot("Bernie Moore", "Commuter"),
        new ParkingLot("Natatorium", "Commuter"),
        new ParkingLot("Astr St. West", "Commuter"),
        new ParkingLot("Edward Gay", "Commuter"),
        new ParkingLot("Beach Volleyball Lot", "Residential"),
        new ParkingLot("Alaska St. Lot", "Residential"),
        new ParkingLot("Broussard Lot", "Residential"),
        new ParkingLot("WCA West Lot", "Residential"),
        new ParkingLot("WCA North Lot", "Residential"),
        new ParkingLot("Spruce Hall West Lot", "Residential"),
        new ParkingLot("Spruce Hall North Lot", "Residential"),
        new ParkingLot("Aster St. East Lot", "Residential"),
        new ParkingLot("Tiger Band Hall West Lot", "Residential"),
        new ParkingLot("Parker Coliseum Lot", "Residential"),
        new ParkingLot("Blake Hall Lot", "Residential"),
        new ParkingLot("Acadian Lot", "Residential"),
        new ParkingLot("Acadian Lot", "Residential"),
        new ParkingLot("West Hall Lot", "Residential"),
        new ParkingLot("South Campus/East Campus/Highland", "Residential"),
        new ParkingLot("Show Barn Service Dr.", "Residential"),
        new ParkingLot("South Stadium E Parker/Highland", "Residential"),
        new ParkingLot("South Stadium", "Residential"),
        new ParkingLot("Herget Hall Lot", "Residential"),
        new ParkingLot("Miller Hall Lot", "Residential"),
        new ParkingLot("Corporation Canal South Lot", "Residential"),
        new ParkingLot("East Campus East Lot", "Residential"),
        new ParkingLot("East Campus Apartments Lot", "Residential"),
        new ParkingLot("East Campus West 1", "Residential"),
        new ParkingLot("East Campus West 2", "Residential"),
        new ParkingLot("East Campus Dr. Lot", "Residential"),
        new ParkingLot("East Campus Apartments Lot", "Residential"),
        new ParkingLot("Hill Farm Lot", "Residential"),
        new ParkingLot("Greek Row West Lot", "Residential"),
        new ParkingLot("South Law Lot", "Law"),
        new ParkingLot("Law Center East Lot", "Law"),
        new ParkingLot("Law Center - Street Lot", "Law"),
        new ParkingLot("Law Center Lot", "Law"),
        new ParkingLot("Isaac Cline Lot", "Law"),
        new ParkingLot("Darlymple Dr", "Law"),
        new ParkingLot("Greek Row South Lot", "Greek"),
        new ParkingLot("Greek Row Central", "Greek"),
        new ParkingLot("Greek Row North Lot", "Greek"),
        new ParkingLot("Greek Row West Lot", "Greek"),
        new ParkingLot("Isaac Cline Lot", "Greek"),
        new ParkingLot("Darlymple Dr", "Greek"),
        new ParkingLot("Fraternity Lane", "Greek"),
        new ParkingLot("Fraternity Circle", "Greek"),
    };
    
    private ArrayList suggestions;
    
    public SuggestionCompilation(String buildingName, String permit){
        ArrayList parkingLots = new ArrayList();
        for (ParkingLot lot : allLots){
            if(lot.getPermit().equals(permit)){
                parkingLots.add(lot);
            }
        }
        SuggestionList suggestionList = new SuggestionList(parkingLots, buildingName);
        suggestions = suggestionList.getUserSuggestions();
        }

    public ArrayList<Suggestion> getSuggestions(){
        return suggestions;
    }
}
