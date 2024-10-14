# Gender In Film

## About

Why am I doing this?


## App Info


### Frontend
- TBD

### Backend
- SpringBoot 3.3.2 with Java 22
- Postgres database
- Liquibase for database migrations


## TODO
- create dockerfile for generating jar so that Java isn't a dev requirement anymore
- create indexes on all tables


## Installation Instructions
- [Install Docker](https://www.docker.com/)

That's it! All other dependencies are managed from within Docker.


## Developer Instructions


### Setup
- Make sure to install Java 22.


### Running The App Via Docker
1. `cd /backend`
2. `./mvnw spring-boot:run`

Internally, this run `docker-compose up` which will start the `api` backend and postgres `db` in Docker containers.


#### Running The App Via JAR
1. `cd /backend`
2. `mvn package`
3. `java -jar target/genderinfilm-0.0.1.jar`


### Creating A New Release
1. Update the version tag in the pom file with the new version.
2. Bring down the app: `docker-compose down`
3. Generate a new jar: `./mvnw package`
4. Generate a new tagged Docker image: `docker build . -t genderinfilm:0.0.1`


### Debugging

To debug the postgres container: `docker exec -it db psql -U postgres -d genderinfilm`


### Troubleshooting

- If you make changes to Dockerfile, remember to run `docker-compose build --no-cache` before `docker-compose up`
- If there are any dangling containers, run `docker-compose down` to clean them up.


### Contributing

This is just a hobby project, and so I can't guarantee the fastest of response times, but I'll try my best to
get to any questions. Pull requests are always welcome!
