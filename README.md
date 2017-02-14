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

# If I had enough time and Other considerations.

1. The data import job should ideally be a batch job. If can make use of any batch framework it would scale the import process. For now I am just reading the file using FileReader and importing into the database.
2. The Movie search is based on only title of movie for now, but searching based on other parameters is a nice to have feature.
3. Making the markers and map look pretty. This is a nice to have feature to make the markers and map look good.
4. The Database I choose is the in-memory hsqldb for quick prototyping. A No-SQL based solution like SOLR search would increase the performance of the search functionality.
5. A multi-page application instead of an Angular based SPA . This choice I made as I have not started on learning Angular. I did not want to waste time on learning Angular. 
6. ** I have added maps in the petclinic application please see around other menu tabs also to see other features.

# What I learnt from this assignment.

1. How to use the Google Maps JavaScript API and also the Google Web Services API using Java.
2. Working of an AutoCompletion widget.

# Deploying the application.

1. This project is a Maven project. Please import this project in a Eclipse or You can use the command line maven to build a war artifact for this project.
2. After successful deployment you will be able access the application on the below URL.
   http://localhost:8080/petclinic/
   
# Bugs and Errors.
1. Some of the movies can be shown placed out of SF Area. This is due to incomplete Address Information where the Google Geocoder gives you a wrong location.
This can be fixed by limiting the geocoder to only SF Area. 

# Screenshots
![Alt text](/1.png?raw=true "1")
![Alt text](/2.png?raw=true "2")
![Alt text](/3.png?raw=true "3")
![Alt text](/4.png?raw=true "4")
![Alt text](/5.png?raw=true "5")
![Alt text](/6.png?raw=true "6")
![Alt text](/7.png?raw=true "7")
