package parkingappcalculations;

//Finds the distance between lot and building
//Originally wanted to make a graph of the lots and buildings
//to calculate distances, since bird-eye views are not accurate.
//However, that would require enormous amounts of data collection
//and being down a team member, that was not possible.
public class Graph {

    //Converts the differences in latitude and longitute
    //to distance in feet. Uses pythagorean theorem.
    //Distances are too short to use a more complex algorithm
    //that takes into account curvature of the Earth
    public static double latlongconv(double bldlat, double bldlong, double lotlat, double lotlong)
    {
        double latdist = Math.abs(bldlat - lotlat);
        double latfeet = latdist*364000;
        double longdist = Math.abs(bldlong - lotlong);
        double longfeet = longdist*288200;
        double totalfeet = Math.sqrt(latfeet*latfeet + longfeet*longfeet);
        return totalfeet;
    }

    //Finds the distance between a lot and the building
    //depending on the user's permit
    public static double MinDistance(String building, ParkingLot lot, String permit){

        //Stretch feature we weren't able to implement
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

        //Stretch feature we weren't able to implement
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

        //List of buildings and their latitude
        //and longitude positions
        String[][] bld_latlong = {{"PFT","30.407535","-91.179743"},
        {"College of Buisness","30.407005","-91.178426"},
        {"Union","30.412313","-91.177084"},
        {"Main Library","30.414436","-91.179983"},
        {"Cox Communications","30.414319","-91.182949"},
        {"Lockett Hall","30.413428","-91.181728"},
        {"Tiger Stadium","30.412011","-91.183815"},
        {"Art and Design","30.411928","-91.180909"},
        {"Law Center","30.414677","-91.174878"},
        {"UREC","30.410795","-91.169064"}};

        //List of commuter lots and their latitude
        //and longitude positions
        String[][] comlot_latlong = {{"Touchdown Village West","-91.179830","30.405662"},
        {"Front 9","-91.178971","30.405319"},
        {"Touchdown Village East","-91.176962","30.405230"},
        {"West Parker Blvd","-91.174721","30.404495"},
        {"Parker Coliseum","-91.175234","30.405229"},
        {"South Stadium East","-91.184266","30.410261"},
        {"South Stadium West","-91.185605","30.410408"},
        {"South Quad Dr. West","-91.184008","30.407128"},
        {"ECE","-91.185176","30.409263"},
        {"West Stadium 1","-91.185241","30.411263"},
        {"West Stadium 2","-91.185653","30.411783"},
        {"Bernie Moore","-91.186776","30.414958"},
        {"Natatorium","-91.186211","30.417135"},
        {"Astr St West","-91.183500","30.419880"},
        {"Edward Gay","-91.180856","30.421157"}};

        //List of residential lots and their latitude
        //and longitude positions
        String[][] reslot_latlong = {{"Beech Volleyball Lot","-91.184592","30.416165"},
        {"Alaska St. Lot","-91.184492","30.417190"},
        {"Broussard Lot","-91.182355","30.416831"},
        {"WCA West Lot","-91.183690","30.418661"},
        {"WCA North Lot","-91.182644","30.419438"},
        {"Spruce Hall West Lot","-91.181995","30.418839"},
        {"Spruce Hall North Lot","-91.180356","30.419521"},
        {"Aster St. East Lot","-91.180721","30.420090"},
        {"Tiger Band Hall West Lot","-91.179748","30.420220"},
        {"Parker Coliseum Lot","-91.175234","30.405229"},
        {"Blake Hall Lot","-91.174403","30.410110"},
        {"Acadian Lot","-91.175315","30.410454"},
        {"West Hall Lot","-91.175135","30.410797"},
        {"South Campus/East Campus/Highland","-91.174226","30.411472"},
        {"Show Barn Service Dr.","-91.173063","30.408057"},
        {"South Stadium E Parker/Highland","-91.173085","30.408387"},
        {"South Stadium","-91.173510","30.408763"},
        {"Herget Hall Lot","-91.172236","30.409875"},
        {"Miller Hall Lot","-91.171244","30.410082"},
        {"Corporation Canal South Lot","-91.170340","30.410367"},
        {"East Campus East Lot","-91.171857","30.412355"},
        {"East Campus Apartments Lot","-91.172619","30.411734"},
        {"East Campus West 1","-91.173656","30.412962"},
        {"East Campus West 2","-91.173642","30.412041"},
        {"East Campus Dr. Lot","-91.173399","30.412628"},
        {"East Campus Apartments Lot","-91.172800","30.413378"},
        {"Hill Farm Lot","-91.171005","30.412922"},
        {"Greek Row West Lot","-91.170060","30.409564"}};

        //List of law lots and their latitude
        //and longitude positions
        String[][] lawlot_latlong = {{"South Law Lot","-91.174160","30.413872"},
        {"Law Center East Lot","-91.174144","30.415224"},
        {"Law Center - Street Lot","-91.174756","30.413902"},
        {"Law Center Lot","-91.174904","30.415210"},
        {"Dalrymple Dr","-91.174886","30.415675"},
        {"Issac Cline Lot","-91.169969","30.415747"}};

        //List of greek lots and their latitude
        //and longitude positions
        String[][] greeklot_latlong = {{"Greek Row South Lot","-91.167829","30.410021"},
        {"Greek Row Central","-91.168090","30.410717"},
        {"Greek Row North Lot","-91.168139","30.412040"},
        {"Greek Row West Lot","-91.170060","30.409564"},
        {"Issac Cline Lot","-91.169969","30.415747"},
        {"Dalrymple Dr","-91.174886","30.415675"},
        {"Fraternity Lane","-91.174419","30.416269"},
        {"Fraternity Circle","-91.172610","30.416467"}};

        //initializing variables
        double bldlat = 0;
        double bldlong = 0;
        double lotlat = 0;
        double lotlong = 0;
        double distance = 0;
        double mindistance = 0;

        //get latitude and longitude of user's building
        for (int i = 0; i < bld_latlong.length; i++) {
            // accessing each element of array
            if (bld_latlong[i][0].equals(building))
            {
                bldlat = Double.parseDouble(bld_latlong[i][2]);
                bldlong = Double.parseDouble(bld_latlong[i][1]);
            }
        }  

        //get latitude and longitude for lot, given
        //that the lot is a commuter lot
        if(permit == "commuter")
        {
            for (int i = 0; i < comlot_latlong.length; i++) {
                if (comlot_latlong[i][0] == lot.getName())
                {
                    lotlat = Double.parseDouble(comlot_latlong[i][1]);
                    lotlong = Double.parseDouble(comlot_latlong[i][2]);
                    distance = latlongconv(bldlat, bldlong, lotlat, lotlong);
                }
            }
        }

        //get latitude and longitude for lot, given
        //that the lot is a residential lot
        else if (permit == "residential")
        {
            for (int i = 0; i < reslot_latlong.length; i++) {
                if (reslot_latlong[i][0].equals(lot.getName()))
                {
                    lotlat = Double.parseDouble(reslot_latlong[i][1]);
                    lotlong = Double.parseDouble(reslot_latlong[i][2]);
                    distance = latlongconv(bldlat, bldlong, lotlat, lotlong);
                }
            }
        }

        //get latitude and longitude for lot, given
        //that the lot is a law lot
        else if (permit == "law")
        {
            for (int i = 0; i < lawlot_latlong.length; i++) {
                if (lawlot_latlong[i][0].equals(lot.getName()))
                {
                    lotlat = Double.parseDouble(lawlot_latlong[i][1]);
                    lotlong = Double.parseDouble(lawlot_latlong[i][2]);
                    distance = latlongconv(bldlat, bldlong, lotlat, lotlong);
                }
            }
        }

        //get latitude and longitude for lot, given
        //that the lot is a greek lot
        else if (permit == "greek")
        {
            for (int i = 0; i < greeklot_latlong.length; i++) {
                if (greeklot_latlong[i][0] == lot.getName())
                {
                    lotlat = Double.parseDouble(greeklot_latlong[i][1]);
                    lotlong = Double.parseDouble(greeklot_latlong[i][2]);
                    distance = latlongconv(bldlat, bldlong, lotlat, lotlong);
                }
            }
        }

        return distance;
    }
}
