# Fake Store API - Product Controller

This Spring Boot application provides RESTful API endpoints for managing products and categories using the Fake Store API.

## Endpoints

### Get All Products

**GET** `http://localhost:8080/api/products`

Returns a list of all products.

### Get Product by ID

**GET** `http://localhost:8080/api/products/{id}`

Returns a specific product by its ID.

### Get Limited Products

**GET** `http://localhost:8080/api/products/limited?limit={limit}`

Returns a limited number of products. Default limit is 5, adjustable with `limit` query parameter.

### Get Sorted Products

**GET** `http://localhost:8080/api/products/sorted?sort={sort}`

Returns products sorted by price in ascending or descending order. Specify sort order with `sort` query parameter (`asc` or `desc`).

### Get All Categories

**GET** `http://localhost:8080/api/products/categories`

Returns a list of all product categories.

### Get Products by Category

**GET** `http://localhost:8080/api/products/category/{category}`

Returns products belonging to a specific category.

### Add Product

**POST** `http://localhost:8080/api/products`

Adds a new product. Requires a JSON object representing the product in the request body.

### Update Product

**PUT** `http://localhost:8080/api/products/{id}`

Updates an existing product identified by its ID. Requires a JSON object representing the updated product in the request body.

### Delete Product

**DELETE** `http://localhost:8080/api/products/{id}`

Deletes a product by its ID.

## Cart Endpoints

### Get All Carts
- **URL:** `http://localhost:8080/api/carts/`
- **Method:** `GET`
- **Description:** Retrieves a list of all carts.

### Get Cart By ID
- **URL:** `http://localhost:8080/api/carts/{id}`
- **Method:** `GET`
- **Description:** Retrieves a cart by its ID.
- **URL Parameters:**
  - `id` (required): The ID of the cart.

### Get Limited Carts
- **URL:** `http://localhost:8080/api/carts/limited`
- **Method:** `GET`
- **Description:** Retrieves a limited number of carts.
- **Query Parameters:**
  - `limit` (optional): The number of carts to retrieve. Default is 5.

### Get Sorted Carts
- **URL:** `http://localhost:8080/api/carts/sorted`
- **Method:** `GET`
- **Description:** Retrieves a sorted list of carts.
- **Query Parameters:**
  - `sort` (optional): The sort order. Default is `asc`.

### Get Carts By Date Range
- **URL:** `http://localhost:8080/api/carts/date-range`
- **Method:** `GET`
- **Description:** Retrieves carts within a specific date range.
- **Query Parameters:**
  - `startDate` (required): The start date in the format `yyyy-MM-dd`.
  - `endDate` (required): The end date in the format `yyyy-MM-dd`.

### Get Carts By User ID
- **URL:** `http://localhost:8080/api/carts/user/{userId}`
- **Method:** `GET`
- **Description:** Retrieves carts by user ID.
- **URL Parameters:**
  - `userId` (required): The ID of the user.

### Add Cart
- **URL:** `http://localhost:8080/api/carts`
- **Method:** `POST`
- **Description:** Adds a new cart.
- **Body:**
  - `Cart` (required): The cart to add.

### Update Cart
- **URL:** `http://localhost:8080/api/carts/{id}`
- **Method:** `PUT`
- **Description:** Updates an existing cart by its ID.
- **URL Parameters:**
  - `id` (required): The ID of the cart.
- **Body:**
  - `Cart` (required): The updated cart data.

### Delete Cart
- **URL:** `http://localhost:8080/api/carts/{id}`
- **Method:** `DELETE`
- **Description:** Deletes a cart by its ID.
- **URL Parameters:**
  - `id` (required): The ID of the cart.

## Actuator Endpoints

### Health
- **URL:** `http://localhost:8080/actuator/health`
- **Method:** `GET`
- **Description:** Shows application health information.

### Info
- **URL:** `http://localhost:8080/actuator/info`
- **Method:** `GET`
- **Description:** Displays arbitrary application info.

### Metrics
- **URL:** `http://localhost:8080/actuator/metrics`
- **Method:** `GET`
- **Description:** Shows metrics information.

### Loggers
- **URL:** `http://localhost:8080/actuator/loggers`
- **Method:** `GET`
- **Description:** Shows and modifies the configuration of loggers in the application.

### Environment
- **URL:** `http://localhost:8080/actuator/env`
- **Method:** `GET`
- **Description:** Exposes properties from Spring's `ConfigurableEnvironment`.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- RESTful API
- Mockito for testing

## Running the Application

To run the application locally, ensure you have Java and Maven installed. Then follow these steps:

1. Clone the repository:
   
   git clone https://github.com/abhishek621/fakestore-api

   cd fakestore-api

2. Build the application:
   
   mvn clean install

4. Run the application:
   
   java -jar target/<jar-file-name>.jar

   Replace <jar-file-name> with the actual name of the generated JAR file.

5. Access the API endpoints locally using:
   
   http://localhost:8080/api/products

   Replace 8080 with the port number configured for your application if different.

