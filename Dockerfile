
# Stage 1: Build the application using Maven and Java 21
FROM maven:3.9-eclipse-temurin-21 AS build

# Set the working directory
WORKDIR /app

# Copy the Maven configuration file
COPY pom.xml .

# Download the required dependencies
RUN mvn dependency:go-offline -B

# Copy the application source code
COPY src ./src

# Build the JAR file without running tests
RUN mvn clean package -DskipTests -B


# Stage 2: Run the application using Java 21 only
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy the finished JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]









