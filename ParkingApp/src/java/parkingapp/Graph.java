package parkingapp;

public class Graph {

    public static int MinDistance(String building, String lot){

        String[][] lots = {{"Touchdown Village 1","PFT","619"},
        {"Touchdown Village 1","Lockett Hall","3696"},
        {"Touchdown Village 1","Coates Hall","422"},
        {"Touchdown Village 1","Tiger Stadium","2728"},
        {"Touchdown Village 1","Student Union","2835"},
        {"Touchdown Village 1","LSU Library","4224"},
        {"Touchdown Village 1","Himes Hall","4097"},
        {"Touchdown Village 1","Tureaud","1558"},
        {"Lot U","PFT","1211"},
        {"Lot U","Lockett Hall","3005"},
        {"Lot U","Coates Hall","2988"},
        {"Lot U","Tiger Stadium","1275"},
        {"Lot U","Student Union","3602"},
        {"Lot U","LSU Library","3296"},
        {"Lot U","Himes Hall","3336"},
        {"Lot U","Tureaud","2168"},
        {"Alex Box Lot","PFT","3168"},
        {"Alex Box Lot","Lockett Hall","2947"},
        {"Alex Box Lot","Coates Hall","3329"},
        {"Alex Box Lot","Tiger Stadium","1243"},
        {"Alex Box Lot","Student Union","3700"},
        {"Alex Box Lot","LSU Library","3549"},
        {"Alex Box Lot","Himes Hall","3558"},
        {"Alex Box Lot","Tureaud","2640"},
        {"Olympic Lot","PFT","4904"},
        {"Olympic Lot","Lockett Hall","4683"},
        {"Olympic Lot","Coates Hall","5065"},
        {"Olympic Lot","Tiger Stadium","2979"},
        {"Olympic Lot","Student Union","5436"},
        {"Olympic Lot","LSU Library","5285"},
        {"Olympic Lot","Himes Hall","5294"},
        {"Olympic Lot","Tureaud","4376"},
        {"Lot C/ Visitor Parking","PFT","2668"},
        {"Lot C/ Visitor Parking","Lockett Hall","2447"},
        {"Lot C/ Visitor Parking","Coates Hall","2829"},
        {"Lot C/ Visitor Parking","Tiger Stadium","171"},
        {"Lot C/ Visitor Parking","Student Union","3696"},
        {"Lot C/ Visitor Parking","LSU Library","3696"},
        {"Lot C/ Visitor Parking","Himes Hall","3696 "},
        {"Lot C/ Visitor Parking","Tureaud","2140"},
        {"Touchdown Village 2","PFT","1542"},
        {"Touchdown Village 2","Lockett Hall","4619"},
        {"Touchdown Village 2","Coates Hall","5147"},
        {"Touchdown Village 2","Tiger Stadium","3651"},
        {"Touchdown Village 2","Student Union","3758"},
        {"Touchdown Village 2","LSU Library","5147"},
        {"Touchdown Village 2","Himes Hall","5020"},
        {"Touchdown Village 2","Tureaud","2481"}};

        int i = 0;
        int distance = 0; 
        for (i = 0; i < lots.length; i++) {
            // accessing each element of array
            if (lots[i][1] == building)
            {
                if (lots[i][0] == lot)
                {
                    distance = Integer.parseInt(lots[i][2]); 
                }
            }
        }  
        return distance;
    }
}
