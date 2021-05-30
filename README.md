
# Reporting App
Reporting  application for Volthread assignment project.    
Contains REST api's to create/delete/change survey items and get Football/Happiness survey items.

**Technologies and Tools Used:**
- Java 11
- Spring Boot 2.5.0
- Lombok for lots of useful annotations
- DevTools for Live Reload
- Maven for dependency management
- MySql as database
- Docker and Docker Compose

**Requirements:**
- JDK 11
- Maven
- Mysql Server
- Docker
- Docker Compose

## Compile and Run:
Change **application.properties** file(db settings and server port) for your environment first.

Settings file; `src/main/resources/application.properties`
### To compile;
`mvn clean install`

After successful build, you will find jar file with the path; `target/volthreadreporting-1.0.0-SNAPSHOT.jar`

### To run;

Compile application and create jar file as described at previous step.

Run first time(pulls mysql and builds app docker image):  `docker-compose up -d`

To stop running compose: `docker-compose stop`

To start existing compose: `docker-compose start`

To restart existing compose: `docker-compose restart`

To see logs: `docker-compose logs`

To delete compose(delete with db data): `docker-compose down -v`

## Postman Collection:

[Download from here](Volthread.postman_collection.json)

Path:

     Volthread.postman_collection.json

## Swagger Documentation:

Swagger api-docs can be reached with swagger request what in the postman collection.

## Creator and Contributors

- Muhammed Said Gultekin(gultekinmsg) - gultekinmsg@gmail.com
