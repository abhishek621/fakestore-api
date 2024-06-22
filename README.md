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
