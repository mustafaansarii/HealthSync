# HealthSync Patient Management System

## Overview
HealthSync is a patient management system designed to streamline the process of managing patient records, billing, and appointments. The system is built using Spring Boot with gRPC integration to ensure high-performance, scalability, and reliability.

## Features
- **Patient Management**: Add, update, and delete patient records.
- **Billing Management**: Handle billing requests and generate invoices.
- **Appointment Scheduling**: Schedule and manage patient appointments.
- **User Authentication**: Secure login and role-based access control.
- **gRPC Services**: High-performance RPC communication between services.

## Technologies Used
- **Backend**: Spring Boot with gRPC
- **Database**: MySQL (for both development and production)
- **Containerization**: Docker (optional)
- **Protocol Buffers**: For gRPC service definitions

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.8 or higher
- Protocol Buffer Compiler (protoc)
- Docker (optional, for containerization)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/mustafaansarii/HealthSync
   ```
2. Navigate to the project directory:
   ```bash
   cd HealthSync-patient-management
   ```
3. Generate gRPC code:
   ```bash
   mvn protobuf:compile
   ```
4. Build the project:
   ```bash
   mvn clean install
   ```
5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Running with Docker
1. Build the Docker image:
   ```bash
   docker build -t healthsync .
   ```
2. Start the container:
   ```bash
   docker run -p 8080:8080 -p 6565:6565 healthsync
   ```

## API Documentation
The REST API documentation is automatically generated using Springdoc OpenAPI. You can access it via Swagger UI at `http://localhost:8080/swagger-ui.html` once the application is running. For gRPC services, refer to the `.proto` files in the `src/main/proto` directory.

