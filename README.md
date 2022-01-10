# Description
Rest service designed to find the weather for today. If there is no record of the weather in the database for today, the weather data is taken from the site yandex.ru

## Technologies used
+ Spring Boot
+ Spring Data JPA
+ Hibernate (MySQL)
+ Flyway data migrations
+ Global exception handling

## Before starting the application
1. create database with any name in your database management system
2. create a file called ***application.properties*** along the path: **(src/main/resources/application.properties)**.

**The content of the file application.properties should look like this:**
***Datasource properties***
spring.datasource.url=jdbc:mysql://localhost:3306/{database name}?serverTimezone=UTC
spring.datasource.username={username}
spring.datasource.password={password}

***Flyway properties***
spring.flyway.url=jdbc:mysql://localhost:3306/{database name}?serverTimezone=UTC
spring.flyway.user={username}
spring.flyway.password={password}


## Architecture levels
+ ***src/main/java/com/lis/projects/WebService/domain*** - Defining the service entity and linking it to a table in the database
+ ***src/main/java/com/lis/projects/WebService/repository*** - Implementation of the "repository" pattern for accessing and manipulating the database
+ ***src/main/java/com/lis/projects/WebService/service*** - 
Service business logic implementation layer. Aimed at processing database queries
+ ***src/main/java/com/lis/projects/WebService/parser*** -
Parsing temperature data on the site yandex.ru
+ ***src/main/java/com/lis/projects/WebService/exception*** - 
Global exception handling in the controller, implementing your own exceptions, creating a response model with an error
+ ***src/main/java/com/lis/projects/WebService/controller*** - Creating an endpoint that handles http requests. 
Returns data about today's weather in json format

