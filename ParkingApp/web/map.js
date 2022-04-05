
mapboxgl.accessToken = 'pk.eyJ1Ijoic2VhbmNoYXBwZWxsMTciLCJhIjoiY2wxMW9yMGo2MnU0ajNicnBqbHdyNTJpNyJ9.WWNA7X3FVJWjMN35no373w';

// Creating the map
const map = new mapboxgl.Map({
    container: 'map', // container id
    style: 'mapbox://styles/seanchappell17/cl12w73te003015nkly3pim39', // stylesheet location
    center: [-91.180690, 30.412838], // starting position
    zoom: 15 // starting zoom
});

// Navigation Controller
map.addControl(new mapboxgl.NavigationControl(), 'bottom-right');

// Setting the bounds of the map
const bounds = [
    [-91.242092, 30.340286],
    [-91.092860, 30.456432]
];
map.setMaxBounds(bounds);


// Get current location of user
map.addControl(new mapboxgl.GeolocateControl({ 
    positionOption:{ 
        enableHighAccuracy: true 
    }, trackUserLocation: true 
}), 'bottom-right');


// Commuter Parking Lots
var geojson = {
    type: 'Commuter Collection',
    features: [{
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.179830    ,   30.405662]
        },
        properties: {
            title: 'Touchdown Village West',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.178971	,	30.405319]
        },
        properties: {
            title: 'Front 9',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.176962	,	30.405230]
        },
        properties: {
            title: 'Touchdown Village East',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.174721	,	30.404495]
        },
        properties: {
            title: 'West Parker Blvd',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.175252	,	30.408227]
        },
        properties: {
            title: 'Parker Coliseum',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.184266	,	30.410261]
        },
        properties: {
            title: 'South Stadium East',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.185605	,	30.410408]
        },
        properties: {
            title: 'South Stadium West',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.184008	,	30.407128]
        },
        properties: {
            title: 'South Quad Dr. West',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.185176	,	30.409263]
        },
        properties: {
            title: 'ECE',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.185241	,	30.411263]
        },
        properties: {
            title: 'West Stadium 1',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.185653	,	30.411783]
        },
        properties: {
            title: 'West Stadium 2',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.186776	,	30.414958]
        },
        properties: {
            title: 'Bernie Moore',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.186211	,	30.417135]
        },
        properties: {
            title: 'Natatorium',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.183500	,	30.419880]
        },
        properties: {
            title: 'Aster Street West',
            description: 'Commuter'
        }
    },
    {
        type: 'Commuter',
        geometry: {
            type: 'Point',
            coordinates: [-91.180856	,	30.421157]
        },
        properties: {
            title: 'Edward Gay',
            description: 'Commuter'
        }
    },
]
};

// Add Commuter Markers to the map
geojson.features.forEach(function(commuter) {

    // Create an HTML element for each feature
    var el = document.createElement('div');
    el.className = 'commuter';

    // Make a marker for each feature and add to the map
    new mapboxgl.Marker(el)
    .setLngLat(commuter.geometry.coordinates)

    // Add popups
    .setPopup(new mapboxgl.Popup({ offset: 25}) 
    .setHTML('<h3>' + commuter.properties.title + '</h3><p>' + commuter.properties.description + '</p>'))
    .addTo(map);
});

// Residential Parking Lots
var geojson = {
    type: 'Residential Collection',
    features: [{
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.184592	,	30.416165]
        },
        properties: {
            title: 'Beach Volleyball Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.184492	,	30.417190]
        },
        properties: {
            title: 'Alaska St. Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.182355	,	30.416831]
        },
        properties: {
            title: 'Broussard Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.183690	,	30.418661]
        },
        properties: {
            title: 'WCA West Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.182644	,	30.419438]
        },
        properties: {
            title: 'WCA North Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.181995	,	30.418839]
        },
        properties: {
            title: 'Spruce Hall West Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.180356	,	30.419521]
        },
        properties: {
            title: 'Spruce Hall North Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.180721	,	30.420090]
        },
        properties: {
            title: 'Aster St. East Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.179748	,	30.420220]
        },
        properties: {
            title: 'Tiger Band Hall West Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.174714	,	30.408248]
        },
        properties: {
            title: 'Parker Coliseum Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.174403	,	30.410110]
        },
        properties: {
            title: 'Blake Hall Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.175315	,	30.410454]
        },
        properties: {
            title: 'Acadian Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.175135	,	30.410797]
        },
        properties: {
            title: 'West Hall Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.174226	,	30.411472]
        },
        properties: {
            title: 'South Campus/East Campus/Highland',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.173063	,	30.408057]
        },
        properties: {
            title: 'Show Bar Service Dr.',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.173085	,	30.408387]
        },
        properties: {
            title: 'South Stadium E Parker/Highland',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.173510	,	30.408763]
        },
        properties: {
            title: 'South Stadium',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.172236	,	30.409875]
        },
        properties: {
            title: 'Herget Hall Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.171244	,	30.410082]
        },
        properties: {
            title: 'Miller Hall Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.170340	,	30.410367]
        },
        properties: {
            title: 'Corporation Canal South Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.171857	,	30.412355]
        },
        properties: {
            title: 'East Campus East Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.172619	,	30.411734]
        },
        properties: {
            title: 'East Campus Apartments Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.173656	,	30.412962]
        },
        properties: {
            title: 'East Campus West 1',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.173642	,	30.412041]
        },
        properties: {
            title: 'East Campus West 2',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.173399	,	30.412628]
        },
        properties: {
            title: 'East Campus Dr. Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.172800	,	30.413378]
        },
        properties: {
            title: 'East Campus Apartments Lot 2',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.171005	,	30.412922]
        },
        properties: {
            title: 'Hill Farm Lot',
            description: 'Residential'
        }
    },
    {
        type: 'Residential',
        geometry: {
            type: 'Point',
            coordinates: [-91.170108	,	30.409527]
        },
        properties: {
            title: 'Greek Row West Lot',
            description: 'Residential'
        }
    },  
]
};

// Add Residential Markers to the map
geojson.features.forEach(function(residential) {

    // Create an HTML element for each feature
    var el = document.createElement('div');
    el.className = 'residential';

    // Make a marker for each feature and add to the map
    new mapboxgl.Marker(el)
    .setLngLat(residential.geometry.coordinates)

    // Add popups
    .setPopup(new mapboxgl.Popup({ offset: 25}) 
    .setHTML('<h3>' + residential.properties.title + '</h3><p>' + residential.properties.description + '</p>'))
    .addTo(map);
});

// Greek Parking Lots
var geojson = {
    type: 'Greek Collection',
    features: [{
        type: 'Greek',
        geometry: {
            type: 'Point',
            coordinates: [-91.167829	,	30.410021]
        },
        properties: {
            title: 'Greek Row South Lot',
            description: 'Greek'
        }
    },
    {
        type: 'Greek',
        geometry: {
            type: 'Point',
            coordinates: [-91.168090	,	30.410717]
        },
        properties: {
            title: 'Greek Row Central',
            description: 'Greek'
        }
    },
    {
        type: 'Greek',
        geometry: {
            type: 'Point',
            coordinates: [-91.168139	,	30.412040]
        },
        properties: {
            title: 'Greek Row North',
            description: 'Greek'
        }
    },
    {
        type: 'Greek',
        geometry: {
            type: 'Point',
            coordinates: [-91.170060	,	30.409564]
        },
        properties: {
            title: 'Greek Row West',
            description: 'Greek'
        }
    },
    {
        type: 'Greek',
        geometry: {
            type: 'Point',
            coordinates: [-91.169924	,	30.415748]
        },
        properties: {
            title: 'Issac Cline Lot',
            description: 'Greek'
        }
    },  
    {
        type: 'Greek',
        geometry: {
            type: 'Point',
            coordinates: [-91.174886	,	30.415675]
        },
        properties: {
            title: 'Dalrymple Dr.',
            description: 'Greek'
        }
    },  
    {
        type: 'Greek',
        geometry: {
            type: 'Point',
            coordinates: [-91.174419	,	30.416269]
        },
        properties: {
            title: 'Fraternity Lane',
            description: 'Greek'
        }
    },  
    {
        type: 'Greek',
        geometry: {
            type: 'Point',
            coordinates: [-91.172610	,	30.416467]
        },
        properties: {
            title: 'Fraternity Circle',
            description: 'Greek'
        }
    },    
]
};

// Add Greek Markers to the map
geojson.features.forEach(function(greek) {

    // Create an HTML element for each feature
    var el = document.createElement('div');
    el.className = 'greek';

    // Make a marker for each feature and add to the map
    new mapboxgl.Marker(el)
    .setLngLat(greek.geometry.coordinates)

    // Add popups
    .setPopup(new mapboxgl.Popup({ offset: 25}) 
    .setHTML('<h3>' + greek.properties.title + '</h3><p>' + greek.properties.description + '</p>'))
    .addTo(map);
});

// Law Parking Lots
var geojson = {
    type: 'Law Collection',
    features: [{
        type: 'Law',
        geometry: {
            type: 'Point',
            coordinates: [-91.174160	,	30.413872]
        },
        properties: {
            title: 'South Law Lot',
            description: 'Law'
        }
    },
    {
        type: 'Law',
        geometry: {
            type: 'Point',
            coordinates: [-91.174144	,	30.415224]
        },
        properties: {
            title: 'Law Center East Lot',
            description: 'Law'
        }
    },
    {
        type: 'Law',
        geometry: {
            type: 'Point',
            coordinates: [-91.174756	,	30.413902]
        },
        properties: {
            title: 'Law Center - Street Lot',
            description: 'Law'
        }
    },
    {
        type: 'Law',
        geometry: {
            type: 'Point',
            coordinates: [-91.174904	,	30.415210]
        },
        properties: {
            title: 'Law Center Lot',
            description: 'Law'
        }
    },
    {
        type: 'Law',
        geometry: {
            type: 'Point',
            coordinates: [-91.174886	,	30.415675]
        },
        properties: {
            title: 'Dalrymple Dr.',
            description: 'Law'
        }
    },
    {
        type: 'Law',
        geometry: {
            type: 'Point',
            coordinates: [-91.169969	,	30.415747]
        },
        properties: {
            title: 'Issac Cline Lot',
            description: 'Law'
        }
    },    
]
};

// Add Law Markers to the map
geojson.features.forEach(function(law) {

    // Create an HTML element for each feature
    var el = document.createElement('div');
    el.className = 'law';

    // Make a marker for each feature and add to the map
    new mapboxgl.Marker(el)
    .setLngLat(law.geometry.coordinates)

    // Add popups
    .setPopup(new mapboxgl.Popup({ offset: 25}) 
    .setHTML('<h3>' + law.properties.title + '</h3><p>' + law.properties.description + '</p>'))
    .addTo(map);
});