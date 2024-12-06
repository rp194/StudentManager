# Student Manager

## Overview

Student Manager is a Spring Boot-based application designed to manage student records. It provides features for adding, updating, deleting, and viewing student details along with the pagination, as well as finding the average age of students.

### Technologies Used
- Java
- Spring Boot
- Hibernate/JPA
- PostgreSQL
- Maven

## Features (Services)

- Create new student records
- View all students in a tabular format equipped with pagination
- Update existing student details (Both partially and fully update)
- Delete student records
- Find the average age of the students
- Throwing errors and making the end-user aware of a bad field related to their request

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/rp194/StudentManager.git
   cd StudentManager
   ```
2. Create a database in PostgreSQL (e.g., `student_manager`) using the configurations provided in the `docker-compose.yml` file
3. Run this command in your terminal to set up the database
   ```bash
    docker-compose up
5. Update the `src/main/resources/application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
   spring.datasource.username=your_chosen_username
   spring.datasource.password=your_chosen_password
   spring.datasource.driver-class-name=org.postgresql.Driver
   spring.jpa.hibernate.ddl-auto=update
   ```
## Build the project:
```bash
 mvn clean install
```
## Run the application:
```bash
 mvn spring-boot:run
```
The application should now be accessible at http://localhost:8080.
## Usage
1. Access the application via an API platform such as the "Postman" software and try to access this address in each section :
   ```bash
    http://localhost:8080:dbInteractions
   ```
2. Navigate through different sections such as "POST", "GET", "PUT", etc.
3. Provide correct fields for a student(firstName(String), lastName(String), id(String), birthYear(Long)) as a JSON object of your request body to create a student entity inside the database. You can follow the format below:
   ```bash
   {
    "firstName": "John",
    "lastName": "Wick",
    "id": "0513456780",
    "birthYear": 1964
   }
    ```

4. By providing a valid student (for example id must be a 10-digit string consisting of mere numbers, and also birthYear must be an interger between 1900 and 2024), you must recieve a "201 Created" validation and a validation message on your user-end API, as bellow:

![image](https://github.com/user-attachments/assets/a445e1fa-c22c-44e4-8722-857be5867c16)

Otherwise you are guided to provide the fields with correct values through a message telling you which fields are misentered and how they should be, as bellow:
![image](https://github.com/user-attachments/assets/6648ce65-2873-4f9d-8c9e-d08543b80dac)
Or another error like this:
![image](https://github.com/user-attachments/assets/37a6dbee-e46a-4b7f-a229-38c7483adf6e)


5. In order to reveive a list of entities which have been stored so far, you can send a GET request at the same url. You can also perform pagination and scroll through pages with the parameters of size and page. An example is shown below:
![image](https://github.com/user-attachments/assets/540cb4ea-9a57-4ee2-9037-f1a6d5098295)
 
6. For updating a student you can send a PUT request for a full update, and a PATCH request for a partial update. For each, you should add a "/{id}" where you need to replace your desired id of a student (if it currently exists) at the end of your given url. After a successfull update you would recieve a corresponding message, like below:
    ![image](https://github.com/user-attachments/assets/0faba105-0804-480d-88c6-f577ad0f1fa7)
   You can see we successfully have updated the Taylor Swift's first name, adding on her middle name.
   You can do the same with a PUT request, but mind that you need to provide all fields of the student properties in your request body.
7.  For a delete operation, you simply can pass a DELETE request with the same url pattern with the "/id" at its end.
    ![image](https://github.com/user-attachments/assets/f2f880a9-8646-4e1b-ae2e-886fc74f1dfe)
8. Finally, for receiving a service of finding the average age of the students, you can request GET and add "/avgage" at the end of your url without passing any id. The result would be like this:
    ![image](https://github.com/user-attachments/assets/e23fc7b3-80a5-408c-a5c0-12c8213d2852)
    Knowing that John Wick (Keanu Reeves) and Taylor Swift are born in 1964 and 1989 respectively, in 2024 they are 60 and 35 years old. So, their average age is 47.5, which is shown the same as a result of our request.

## Important note
If you wish to build this project from an IDE, I strongly recommend using VS Code, as IntelliJ might fail to interpret the Lombok configurations and usages. Other than using an IDE, you should be fine, having followed the above steps successfully.
