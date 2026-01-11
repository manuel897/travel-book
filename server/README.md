# Travel Book Server

## What is this?
Java backend for Travel Book. The client should be able to create and manage bookings through REST API. 

## How to run
1. Java version: 21
2. Build tool: Gradle
3. Create `config/customer_config.yml`file to define customer specific values
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
4. Run:
   ./gradlew bootRun

## External dependencies
- Postgres

## Notes to future me
- Config is messy, cannot connect to db
- Needs cleanup before adding features

## Java
- Java 21
- Build with: ./gradlew