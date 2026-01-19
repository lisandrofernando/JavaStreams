# Use Eclipse Temurin JDK 17 and install Maven
FROM eclipse-temurin:17-jdk-alpine

# Install Maven
RUN apk add --no-cache maven

# Set working directory
WORKDIR /app

# Copy pom.xml first for better layer caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean compile -B

# Expose port (if needed for future web functionality)
EXPOSE 8080

# Default command to run tests
CMD ["mvn", "test"]