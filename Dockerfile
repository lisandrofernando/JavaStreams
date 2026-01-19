# Use OpenJDK 8 as base image to match project requirements
FROM openjdk:8-jdk-alpine

# Set working directory
WORKDIR /app

# Install Maven
RUN apk add --no-cache maven

# Copy pom.xml first for better layer caching
COPY JavaStreams/pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY JavaStreams/src ./src

# Build the application
RUN mvn clean compile -B

# Expose port (if needed for future web functionality)
EXPOSE 8080

# Default command to run tests
CMD ["mvn", "test"]