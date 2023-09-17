# <a href='https://github.com/Muryginds/BeatifulCodeContest'>Text punctuation checker</a>

### An application that helps people determine whether they have correctly placed parentheses in their text

Default address http://localhost:8080

Features implemented:

- Rest controller for handling incoming request
- Separated service for business logic
- Tests for both controller and service
- Incoming requests validation and controller advice for error handling
- Lombok for boilerplate code reduction
- API documented with swagger-ui

POST request example: /api/checkBrackets

![img_1.png](img_1.png)

API documentation http://localhost:8080/swagger-doc

![img.png](img.png)

Technology stack:

- Spring Boot 3.0.3 (Web, Test, Validation)
- Java 17
- Lombok
- Swagger 3

To run the project follow next steps:

- download project files
- open terminal inside root folder
- if you have <b>Maven</b> installed, use these commands to create and run package:
    ```agsl
    mvn clean package
  
    java -jar target/TextCheckup-0.0.1-SNAPSHOT.jar
    ```
- in other case you can you <b>Maven Wrapper</b> to run the project:

  on Unix:
  ```agsl
  ./mvnw clean package
  
  ./mvnw spring-boot:run
  ```

  on Windows:
  ```agsl
  mvnw.cmd clean package
  
  mvnw.cmd spring-boot:run
  ```