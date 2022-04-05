
// Autocomplete for Parking Lot form
function autocomplete(inp, arr) {
    /*the autocomplete function takes two arguments,
    the text field element and an array of possible autocompleted values:*/
    var currentFocus;
    /*execute a function when someone writes in the text field:*/
    inp.addEventListener("input", function(e) {
        var a, b, i, val = this.value;
        /*close any already open lists of autocompleted values*/
        closeAllLists();
        if (!val) { return false;}
        currentFocus = -1;
        /*create a DIV element that will contain the items (values):*/
        a = document.createElement("DIV");
        a.setAttribute("id", this.id + "autocomplete-list");
        a.setAttribute("class", "autocomplete-items");
        /*append the DIV element as a child of the autocomplete container:*/
        this.parentNode.appendChild(a);
        /*for each item in the array...*/
        for (i = 0; i < arr.length; i++) {
          /*check if the item starts with the same letters as the text field value:*/
          if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
            /*create a DIV element for each matching element:*/
            b = document.createElement("DIV");
            /*make the matching letters bold:*/
            b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
            b.innerHTML += arr[i].substr(val.length);
            /*insert a input field that will hold the current array item's value:*/
            b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
            /*execute a function when someone clicks on the item value (DIV element):*/
            b.addEventListener("click", function(e) {
                /*insert the value for the autocomplete text field:*/
                inp.value = this.getElementsByTagName("input")[0].value;
                /*close the list of autocompleted values,
                (or any other open lists of autocompleted values:*/
                closeAllLists();
            });
            a.appendChild(b);
          }
        }
    });

    /*execute a function presses a key on the keyboard:*/
    inp.addEventListener("keydown", function(e) {
        var x = document.getElementById(this.id + "autocomplete-list");
        if (x) x = x.getElementsByTagName("div");
        if (e.keyCode == 40) {
          /*If the arrow DOWN key is pressed,
          increase the currentFocus variable:*/
          currentFocus++;
          /*and and make the current item more visible:*/
          addActive(x);
        } else if (e.keyCode == 38) { //up
          /*If the arrow UP key is pressed,
          decrease the currentFocus variable:*/
          currentFocus--;
          /*and and make the current item more visible:*/
          addActive(x);
        } else if (e.keyCode == 13) {
          /*If the ENTER key is pressed, prevent the form from being submitted,*/
          e.preventDefault();
          if (currentFocus > -1) {
            /*and simulate a click on the "active" item:*/
            if (x) x[currentFocus].click();
          }
        }
    });
    function addActive(x) {
      /*a function to classify an item as "active":*/
      if (!x) return false;
      /*start by removing the "active" class on all items:*/
      removeActive(x);
      if (currentFocus >= x.length) currentFocus = 0;
      if (currentFocus < 0) currentFocus = (x.length - 1);
      /*add class "autocomplete-active":*/
      x[currentFocus].classList.add("autocomplete-active");
    }
    function removeActive(x) {
      /*a function to remove the "active" class from all autocomplete items:*/
      for (var i = 0; i < x.length; i++) {
        x[i].classList.remove("autocomplete-active");
      }
    }
    function closeAllLists(elmnt) {
      /*close all autocomplete lists in the document,
      except the one passed as an argument:*/
      var x = document.getElementsByClassName("autocomplete-items");
      for (var i = 0; i < x.length; i++) {
        if (elmnt != x[i] && elmnt != inp) {
          x[i].parentNode.removeChild(x[i]);
        }
      }
    }
    /*execute a function when someone clicks in the document:*/
    document.addEventListener("click", function (e) {
        closeAllLists(e.target);
    });
  }

var parkingLots = [ "Touchdown Village West",
                    "Front 9",
                    "Touchdown Village East",
                    "West Parker Blvd",
                    "Parker Coliseum",
                    "South Stadium East",
                    "South Stadium West",
                    "South Quad Dr. West",
                    "ECE",
                    "West Stadium 1",
                    "West Stadium 2",
                    "Bernie Moore",
                    "Natatorium",
                    "Aster St West",
                    "Edward Gay",
                    "Beech Volleyball Lot",
                    "Alaska St. Lot",
                    "Broussard Lot",
                    "WCA West Lot",
                    "WCA North Lot",
                    "Spruce Hall West Lot",
                    "Spruce Hall North Lot",
                    "Aster St. East Lot",
                    "Tiger Band Hall West Lot",
                    "Parker Coliseum Lot",
                    "Blake Hall Lot",
                    "Acadian Lot",
                    "West Hall Lot",
                    "South Campus/East Campus/Highland",
                    "Show Barn Service Dr.",
                    "South Stadium E Parker/Highland",
                    "South Stadium",
                    "Herget Hall Lot",
                    "Miller Hall Lot",
                    "Corporation Canal South Lot",
                    "East Campus East Lot",
                    "East Campus Apartments Lot",
                    "East Campus West 1",
                    "East Campus West 2",
                    "East Campus Dr. Lot",
                    "East Campus Apartments Lot",
                    "Hill Farm Lot",
                    "Greek Row West Lot",
                    "South Law Lot",
                    "Law Center East Lot",
                    "Law Center - Street Lot",
                    "Law Center Lot",
                    "Dalrymple Dr",
                    "Issac Cline Lot",
                    "Greek Row South Lot",
                    "Greek Row Central",
                    "Greek Row North Lot",
                    "Greek Row West Lot",
                    "Issac Cline Lot",
                    "Dalrymple Dr",
                    "Fraternity Lane",
                    "Fraternity Circle" ];

/*initiate the autocomplete function on the "myInput" element, and pass along the parkingLots 
array as possible autocomplete values:*/
autocomplete(document.getElementById("myInput"), parkingLots);

