public class Graph {

    public static int MinDistance(String building, String lot){

        String[][] lot_to_bld = {{"Touchdown Village 1","PFT","619"},
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

        String[][] bld_to_bld = {{"PFT","Lockett Hall","2145"},
        {"PFT","Coates Hall","1981"},
        {"PFT","Tiger Stadium","1795"},
        {"PFT","Student Union","1866"},
        {"PFT","LSU Library","2356"},
        {"PFT","Himes Hall","2465"},
        {"PFT","Tureaud","400"},
        {"Lockett Hall","PFT","2145"},
        {"Lockett Hall","Coates Hall","612"},
        {"Lockett Hall","Tiger Stadium","396"},
        {"Lockett Hall","Student Union","1361"},
        {"Lockett Hall","LSU Library","678"},
        {"Lockett Hall","Himes Hall","802"},
        {"Lockett Hall","Tureaud","1867"},
        {"Coates Hall","PFT","1981"},
        {"Coates Hall","Lockett Hall","612"},
        {"Coates Hall","Tiger Stadium","1173"},
        {"Coates Hall","Student Union","710"},
        {"Coates Hall","LSU Library","501"},
        {"Coates Hall","Himes Hall","363"},
        {"Coates Hall","Tureaud","1405"},
        {"Tiger Stadium","PFT","1795ft"},
        {"Tiger Stadium","Lockett Hall","396"},
        {"Tiger Stadium","Coates Hall","1173"},
        {"Tiger Stadium","Student Union","2126"},
        {"Tiger Stadium","LSU Library","1371"},
        {"Tiger Stadium","Himes Hall","1368"},
        {"Tiger Stadium","Tureaud","1848"},
        {"Student Union","PFT","1866"},
        {"Student Union","Lockett Hall","1361"},
        {"Student Union","Tiger Stadium","2126"},
        {"Student Union","LSU Library","1099"},
        {"Student Union","Himes Hall","873"},
        {"Student Union","Tureaud","1276"},
        {"LSU Library","PFT","2356"},
        {"LSU Library","Lockett Hall","678"},
        {"LSU Library","Coates Hall","501"},
        {"LSU Library","Tiger Stadium","1371"},
        {"LSU Library","Student Union","1099"},
        {"LSU Library","Himes Hall","181"},
        {"LSU Library","Tureaud","1814"},
        {"Himes Hall","PFT","2465"},
        {"Himes Hall","Lockett Hall","802"},
        {"Himes Hall","Coates Hall","363"},
        {"Himes Hall","Tiger Stadium","1368"},
        {"Himes Hall","Student Union","873"},
        {"Himes Hall","LSU Library","181"},
        {"Himes Hall","Tureaud","1599"},
        {"Tureaud","PFT","400"},
        {"Tureaud","Lockett Hall","1867"},
        {"Tureaud","Coates Hall","1405"},
        {"Tureaud","Tiger Stadium","1848"},
        {"Tureaud","Student Union","1276"},
        {"Tureaud","LSU Library","1814"},
        {"Tureaud","Himes Hall","1599"}};

        // int[][] graph = new int[14][14];
        int i = 0;
        // int j = 0;
        // for (i=0; i<bld_to_bld.length; i++)
        // {
        //     for (j=0; j<; j++)
        //     {
                
        //     }
        // }
        
        int distance = 0; 
        for (i = 0; i < lot_to_bld.length; i++) {
            // accessing each element of array
            if (lot_to_bld[i][0] == lot)
            {
                if (lot_to_bld[i][1] == building)
                {
                    distance = Integer.parseInt(lot_to_bld[i][2]); 
                }
            }
        }  
        return distance;
    }
}
