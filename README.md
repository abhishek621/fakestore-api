<<<<<<< HEAD
# Localhost FakeStore API Endpoints

This document outlines the available endpoints provided by your local instance of the FakeStore API.

## Products

- **Get all products:**
  - Method: GET
  - URL: `http://localhost:8080/products`

- **Get a single product by id:**
  - Method: GET
  - URL: `http://localhost:8080/products/{id}`
  - Example: `http://localhost:8080/products/1`

- **Limit results (e.g., limit to 5 products):**
  - Method: GET
  - URL: `http://localhost:8080/products?limit=5`

- **Sort results (ascending or descending):**
  - Method: GET
  - URL: `http://localhost:8080/products?sort=asc`
  - Possible values for `sort`: `asc` (ascending) or `desc` (descending)

## Cart

- **Get all carts:**
  - Method: GET
  - URL: `http://localhost:8080/carts`

- **Get a single cart by id:**
  - Method: GET
  - URL: `http://localhost:8080/carts/{id}`
  - Example: `http://localhost:8080/carts/5`

- **Limit results (e.g., limit to 5 carts):**
  - Method: GET
  - URL: `http://localhost:8080/carts?limit=5`

- **Sort results (ascending or descending):**
  - Method: GET
  - URL: `http://localhost:8080/carts?sort=desc`
  - Possible values for `sort`: `asc` (ascending) or `desc` (descending)

- **Get carts in a date range:**
  - Method: GET
  - URL: `http://localhost:8080/carts?startdate={startdate}&enddate={enddate}`
  - Example: `http://localhost:8080/carts?startdate=2019-12-10&enddate=2020-10-10`

- **Get user carts:**
  - Method: GET
  - URL: `http://localhost:8080/carts/user/{userId}`
  - Example: `http://localhost:8080/carts/user/2`

## Categories

- **Get all categories:**
  - Method: GET
  - URL: `http://localhost:8080/products/categories`

- **Get products in a specific category:**
  - Method: GET
  - URL: `http://localhost:8080/products/category/{category}`
  - Example: `http://localhost:8080/products/category/jewelery`

## Users

- **Get all users:**
  - Method: GET
  - URL: `http://localhost:8080/users`

- **Get a single user by id:**
  - Method: GET
  - URL: `http://localhost:8080/users/{id}`
  - Example: `http://localhost:8080/users/1`

- **Limit results (e.g., limit to 5 users):**
  - Method: GET
  - URL: `http://localhost:8080/users?limit=5`

- **Sort results (ascending or descending):**
  - Method: GET
  - URL: `http://localhost:8080/users?sort=desc`
  - Possible values for `sort`: `asc` (ascending) or `desc` (descending)

## Login

- **User login:**
  - Method: POST
  - URL: `http://localhost:8080/auth/login`
  - Example request body:
    ```json
    {
        "username": "mor_2314",
        "password": "83r5^_"
    }
    ```

---

Use these endpoints to interact with your local instance of the FakeStore API running on `localhost`. Adjust the URLs and ports (`8080` in the examples) according to your actual setup.
=======
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
>>>>>>> b8e301bfa522bb2e3b1538e71ad1ab90404dd889
