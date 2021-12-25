# ui-api-sample

This monorepo consists of a simple Vue 3 UI project and a sample API project based on Spring Boot.

## Build & Run

### Vue 3 UI Project

in folder sample-gui run

`npm install`

and 

`npm run dev`

The vite server runs on port 3000.


### Spring Boot API Project

Use maven wrapper. In folder sample-gui run

`mvnw clean install `

to build the jar.

Use 

`java -jar target/sample-api-0.0.1-SNAPSHOT.jar`

to run the Spring Boot Application on port 8080. 
