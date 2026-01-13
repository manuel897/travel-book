# Travel Book Server

## What is this?
Java backend for Travel Book. The client should be able to create and manage bookings through REST API. 
* Java version: 21 
* Build tool: Gradle
 
## How to run the server?
1. Run:
   `./gradlew build`
2. Create `/config/customer_config.yml`file to define customer specific values:
```yaml
distance_unit_of_measurement: <km/mi>
db_url: jdbc:postgresql://localhost:<port>/<db>
db_user: <user>
db_password: <password>
db_ssl: true
db_poolsize: 30
sslmode: verify-ca
sslrootcert: path/to.crt
```
3. Ensure that PostgreSQL is running and connection using the connection info in the previous step is possible.
4. Run:
   `./gradlew bootRun`

## External dependencies
- Postgres

## Java
- Java 21
- Build with: `./gradlew build` 