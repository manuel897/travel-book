# syntax=docker/dockerfile:1

# ---- Build stage ----
FROM gradle:8.7-jdk21 AS build
WORKDIR /workspace

# Copy only build scripts first to leverage Docker layer caching
COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle

# Download dependencies (will be cached unless build files change)
RUN gradle --no-daemon dependencies

# Copy source and build the boot jar
COPY src ./src
RUN gradle --no-daemon bootJar

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /workspace/build/libs/*.jar app.jar

# Spring Boot listens on 8080 by default
EXPOSE 8080

# Optional: allow passing JVM opts at runtime, e.g. -e JAVA_OPTS="-Xms256m -Xmx512m"
ENV JAVA_OPTS=""

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]