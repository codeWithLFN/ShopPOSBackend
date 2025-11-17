# ShopPOS Backend

This is the backend service for the ShopPOS application. It provides a RESTful API for managing products (and is designed to be extended with orders and customers) in a point-of-sale system.

## Features
- **Product Management**: Add, update, delete, and view products.
- **Order Processing**: (Planned) Create and manage customer orders.
- **Customer Management**: (Planned) Handle customer information and history.
- **Authentication**: (Planned) Secure endpoints with JWT-based authentication.
- **Receipt Generation**: (Planned) Generate receipts for completed orders.

## Tech Stack
- Java (Spring Boot)
- MongoDB
- Gradle

## Getting Started

### Prerequisites
- Java (compatible with the version configured in `build.gradle`)
- MongoDB running locally (default port `27017`) or accessible via network
- Git (optional, for cloning)

### Clone the Project
```bash
git clone <your-repo-url>
cd shopBackend
```

### Configuration
Application configuration is located in `src/main/resources/application.yml`.

Typical settings you may want to adjust:
- Server port
- MongoDB connection URI and database name
- Any future security/JWT settings

### Build
Use the Gradle wrapper included in the project.

```powershell
./gradlew clean build
```

### Run
Run the application using the Gradle wrapper:

```powershell
./gradlew bootRun
```

After startup, the API will be available at:

- `http://localhost:8080` (default Spring Boot port, unless changed in `application.yml`).

## API Overview

### Products
Current product-related endpoints (paths may vary depending on your controller mappings):
- `GET /api/products` – List all products
- `GET /api/products/{id}` – Get product by ID
- `POST /api/products` – Create a new product
- `PUT /api/products/{id}` – Update an existing product
- `DELETE /api/products/{id}` – Delete a product

DTOs/entities involved include:
- `CreateProductRequest`
- `ProductResponse`
- `ProductEntity`

### Orders & Customers (Planned)
The backend is intended to support:
- Order endpoints (`/api/orders`)
- Customer endpoints (`/api/customers`)

These are not fully documented here yet and may still be under development.

### Authentication (Planned)
The project is designed to use JWT-based authentication in the future. Once implemented, protected endpoints will require a Bearer token in the `Authorization` header.

## Project Structure

- `src/main/java/com/codewithlfn/shopbackend/`
  - `controller/` – REST controllers (e.g., `ProductController`)
  - `service/` – Service interfaces
  - `service/impl/` – Service implementations (e.g., `ProductServiceImpl`)
  - `entity/` – Persistence entities (e.g., `ProductEntity`)
  - `dto/` – Request/response payloads
  - `exception/` – Global exception handling (e.g., `ControllerAdvisor`)
- `src/main/resources/` – Application configuration and resources

## Development

Run tests with:

```powershell
./gradlew test
```

You can also run or debug the application directly from your IDE (e.g., IntelliJ) using the `ShopBackendApplication` main class.

## Contributing

This is a personal/demo project, but contributions are welcome:
1. Fork the repository.
2. Create a feature branch.
3. Commit your changes with clear messages.
4. Open a pull request describing your changes.

## License

License: TBD. Feel free to use this project for learning and experimentation. For any other use, please open an issue or contact the author.
