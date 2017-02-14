<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<petclinic:layout pageName="near">
	<jsp:attribute name="customScript">

<script>
	$(function() {
		function log(message) {
			$("<div>").text(message).prependTo("#log");
			$("#log").scrollTop(0);
		}

		$("#searchBox").autocomplete({
			source : "/petclinic/getMovies",
			minLength : 1,
			select : function(event, ui) {
				log("Selected: " + ui.item.label + " aka " + ui.item.value);
		
				locations = []; // create array here
			    $.each(ui.item.halls, function (index, hall) {
			        locations.push(new google.maps.LatLng(parseFloat(hall.lat),parseFloat(hall.lon))); //push values here
			    });
				
				
			initMap();
			}
		});
	});
</script>


</jsp:attribute>

	<jsp:body>


<script>
		var locations;
		
	    function initMap() {

	        var map = new google.maps.Map(document.getElementById('map'), {
		          zoom: 4,
		          center: new google.maps.LatLng(39.5, -98.35)
		        });

	    	if(locations != null)
	    	{

	        // Create an array of alphabetical characters used to label the markers.
	        var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

	        
	        // Add some markers to the map.
	        // Note: The code uses the JavaScript Array.prototype.map() method to
	        // create an array of markers based on a given "locations" array.
	        // The map() method here has nothing to do with the Google Maps API.
	        var markers = locations.map(function(location, i) {
	          return new google.maps.Marker({
	            position: location,
	            label: labels[i % labels.length]
	          });
	        });

	        // Add a marker clusterer to manage the markers.
	        var markerCluster = new MarkerClusterer(map, markers,
	            {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
	      }
	    }
	    </script>
	
  <script
			src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
  </script>
 <script async defer
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCu8S-qQVi0Yzg0vit1vGnMrx8sAZCUKKU&callback=initMap">
    </script>	


<STYLE>
#map {
	height: 400px;
	width: 100%;
}
</STYLE>

<div class="ui-widget">
  <label for="searchBox">Movies: </label>
  <input id="searchBox">
</div>	
 
<div class="ui-widget" style="margin-top: 2em; font-family: Arial">
  Result:
  <div id="log" style="height: 200px; width: 300px; overflow: auto;"
				class="ui-widget-content"></div>
</div>


    <div id="map"></div>

</jsp:body>
</petclinic:layout>
