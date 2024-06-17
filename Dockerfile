# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper and configuration files
COPY gradlew ./
COPY gradle gradle
COPY build.gradle ./
COPY settings.gradle ./

# Download the dependencies
RUN ./gradlew dependencies

# Copy the source code
COPY src src

# Build the application
RUN ./gradlew build -x test

# Expose the port the app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "build/libs/oauth2.0-0.0.1-SNAPSHOT.jar"]
