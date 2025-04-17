# Customer Management Backend

Backend service for the Customer Management Panel, built with **Java 21**, **Spring Boot 3.x**, and **PostgreSQL**. It provides secure APIs for user authentication and customer data management.

## 🛠️ Tech Stack

- **Java 21**
- **Spring Boot 3.4.4**
- **Spring Security**
- **Spring Data JPA**
- **PostgreSQL**
- **JWT** for authentication
- **Lombok** for boilerplate code reduction

## 📦 Build & Run

### Prerequisites

- Java 21+
- Maven 3.8+
- PostgreSQL running locally (or update connection string)

### Clone and Build

```bash
git clone https://github.com/your-username/customer-management-backend.git
cd customer-management-backend
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

## 🔐 Authentication

- Supports **one panel user**.
- JWT-based authentication.
- Endpoints for:
  - Register
  - Login
  - Password Update

## 👥 Customer Management APIs

- **GET** `/api/customers` – List all customers
- **POST** `/api/customers` – Add a new customer
- **PUT** `/api/customers/{id}` – Edit customer details
- **DELETE** `/api/customers/{id}` – Delete a customer

## 🔧 Configuration

Update your PostgreSQL settings in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/customer_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=your_jwt_secret_key
jwt.expiration=3600000
```

## 🧪 Testing

Run tests with:

```bash
mvn test
```

Includes:

- Spring Boot tests
- Security tests
- API endpoint tests

## 📁 Project Structure (Simplified)

```
src/
  └── main/
      ├── java/com/management/customer/
      │   ├── controller/         # REST controllers
      │   ├── service/            # Business logic
      │   ├── repository/         # JPA repositories
      │   ├── model/              # Entity models
      │   └── security/           # JWT security config
      └── resources/
          ├── application.properties
          └── ...
```

## 📌 Notes

- Passwords are stored securely using BCrypt hashing.
- JWT tokens are issued during login and required for all authenticated routes.
- Only one user is allowed — additional registration is blocked after the first.

---

## 📄 License

This project is licensed under the MIT License.
