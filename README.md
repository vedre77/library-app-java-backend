# library-app-java-backend

Spring Boot Backend to serve React-TS frontend. 
In order to utilize the built-in endpoint exposure (also pagination, search, etc...), instead of creating
and configuring the controller layer, config file was created to override/ configure allowed access and methods.
XML file was initialized with these packages:
* Lombok (for annotation libraries)
* Rest Repositories
* Spring Data JPA
* MySQL driver

<hr>

* Scripts loaded into MySQL workbench to populate data and set user access.
* Added dependency for okta.
 
