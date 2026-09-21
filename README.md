# Task Manager API

A simple Task Management REST API built with Spring Boot, following Clean Architecture / Hexagonal Architecture principles.

## Features

- Create, read, update, and delete tasks.
- In-memory task storage.
- API Documentation via OpenAPI and Spring REST Docs.
- Input validation.

## Tech Stack

- **Language:** Java 21
- **Framework:** Spring Boot 3.4.3
- **Build Tool:** Maven
- **Testing:** JUnit 5, AssertJ, Mockito, MockMvc
- **Documentation:** OpenAPI (Swagger), Spring REST Docs (Asciidoctor)

## Prerequisites

- **JDK 21** or higher
- **Maven 3.x** (optional, as Maven Wrapper is included)

## Getting Started

### Clone the Repository
```bash
git clone <repository-url>
cd taskmanager
```

### Run the Application
You can run the application using the Maven Wrapper:

```powershell
./mvnw spring-boot:run
```

The server will start at `http://localhost:8080`.

## Scripts and Commands

- **Build the project:**
  ```powershell
  ./mvnw clean install
  ```
- **Run tests:**
  ```powershell
  ./mvnw test
  ```
- **Generate Documentation:**
  Documentation is generated during the `prepare-package` phase (included in `install`).
  ```powershell
  ./mvnw prepare-package
  ```

## API Documentation

- **OpenAPI Specification:** Available at `src/main/resources/static/taskmanager-openapi.yaml`.
- **REST Docs:** Once built, documentation is available at `target/generated-docs/index.html`.

## Project Structure

The project follows a hexagonal architecture:

- `com.ercsn.taskmanager.domain`: Core business logic and entities (e.g., `Task`, `TaskRepository` interface).
- `com.ercsn.taskmanager.application`: Use cases and input/output ports.
- `com.ercsn.taskmanager.infrastructure`: Implementation details such as HTTP controllers and in-memory repository.
- `com.ercsn.taskmanager.TaskmanagerApplication`: Spring Boot entry point.

## Configuration

Environment variables and configuration can be managed in `src/main/resources/application.properties`.

Currently defined properties:
- `spring.application.name=taskmanager`

## TODOs

- [ ] Add persistent database storage (e.g., PostgreSQL).
- [ ] Implement user authentication and authorization.
- [ ] Add more comprehensive integration tests.

## License

TODO: Add license information.

