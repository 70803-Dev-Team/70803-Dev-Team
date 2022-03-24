
mapboxgl.accessToken = 'pk.eyJ1Ijoic2VhbmNoYXBwZWxsMTciLCJhIjoiY2wxMW9yMGo2MnU0ajNicnBqbHdyNTJpNyJ9.WWNA7X3FVJWjMN35no373w';

// navigator.geolocation.getCurrentPosition(successLocation, 
//     errorLocation, {
//         enableHighAccuracy: true
//     })

// function successLocation(position){
//     console.log(position)
//     setupMap([position.coords.longitude, position.coords.latitude])
// }

// function errorLocation(){
//     setupMap([30.41, 91.18])
// }


const map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/seanchappell17/cl12w73te003015nkly3pim39',
    center: [-91.180690, 30.412838],
    zoom: 15
})



