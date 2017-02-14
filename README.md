# SF Movies App

# Requirements:

Create a service that shows on a map where movies have been filmed in San Francisco. The user should be able to filter the view using autocompletion search.

The data is available on DataSF: Film Locations.
https://data.sfgov.org/Culture-and-Recreation/Film-Locations-in-San-Francisco/yitu-d5am

# Approach:

1. Downloaded the sample movie data from the above location in the CSV format.
2. Modifiy the latest Spring Petclinic Application to store the data and for search functionality.
3. Create the Movies and Hall entitiies in the Database. There is a OneToMany relationship between a "Movie" and a movie "Hall".
4. Import the movies data in the csv format into the database and also popluate the location for each Hall which can be found by geocoding the Address Location using the Google Webservice. (MovieController, URL=/loadMovies)
5. Application has the intial login page thorugh which u can authenticate to the application by providing the crendentials.
6. There is a "Movies" menu in the top of the page to see the Movies functionality. (MovieController, URL=/getMovies) and (view="near.jsp") for the autocomplete search and map rendering logic.
7. Used the jQuery UI Autocomplete Widget for Autocomplete search box.
8. Used Google Maps JavaScript API to render the movies on the map.






