# Travel Book Server

## What is this?
Java backend for Travel Book. The client should be able to create and manage bookings through REST API. 
* Java version: 21 
* Build tool: Gradle
 
## How to run the server as a docker container?
1. Create files `config/customer_config.yml` and `.env`. See examples.
2. Ensure that docker engine is running. Run:
     docker info
3. Run:
     docker compose up --build

## How to run the server locally?
1. Run:
   `./gradlew build`
2. Create files `config/customer_config.yml` and `,env`. See examples.
3. Ensure that PostgreSQL is running and connection using the connection info in the previous step is possible.
4. Run:
   `./gradlew bootRun`

## External dependencies
- Postgres

## Java
- Java 21
- Build with: `./gradlew build` 