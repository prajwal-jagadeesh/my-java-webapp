# Use an official Maven runtime as a parent image
FROM maven:3.8.4-openjdk-11 AS builder

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Build the application with Maven
RUN mvn clean install -DskipTests

# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the JAR file from the builder stage to the second stage
COPY --from=builder /app/target/*.jar app.jar

# Specify the command to run on container start
CMD ["java", "-jar", "app.jar"]
