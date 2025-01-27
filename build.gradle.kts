plugins {
    id("java")
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

}

dependencies {
    // https://mvnrepository.com/artifact/org.mockito/mockito-core
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // https://mvnrepository.com/artifact/org.springframework.data/spring-data-jdbc
    implementation("org.springframework.data:spring-data-jdbc:4.0.0-M1")

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jdbc
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:3.4.2")

    // https://mvnrepository.com/artifact/org.postgresql/postgresql
    implementation("org.postgresql", "postgresql", "42.7.4")
}

tasks.test {
    useJUnitPlatform()
}