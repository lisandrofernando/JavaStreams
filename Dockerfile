# Use Eclipse Temurin JDK 17 (Ubuntu-based, supports arm64 natively)
FROM eclipse-temurin:17-jdk

# Install Maven (Ubuntu/Debian package manager)
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

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