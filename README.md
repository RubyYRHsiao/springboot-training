# Spring Boot & RESTful API

## Technologies Used

- Spring Boot 3.0.2
- Java 17
- Gradle 7.6
- Postgres 14.6
- Spring Data JPA
- Hibernate
- Flyway
- Docker

## Getting Started

1. Clone the repo

   ```
   git clone https://github.com/RubyYRHsiao/springboot-training.git
   ```

2. Create a database with Docker
    ```
    docker pull postgres:alpine
    ```

    ```
    docker run --name postgres-test -e POSTGRES_PASSWORD=password -d -p 2023:5432 postgres:alpine
    ```

3. Run server
   ```
   cd training
   ```
   ```
   ./gradlew bootrun
   ```

4. API Document：[Swagger UI](http://localhost:8080/swagger-ui/index.html#/)