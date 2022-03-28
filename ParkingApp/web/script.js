
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

// setting the bounds of the map
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



