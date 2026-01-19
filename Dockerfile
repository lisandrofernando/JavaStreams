# Use Maven with OpenJDK 17
FROM maven:3.9.4-openjdk-17-slim

# Set working directory
WORKDIR /app

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