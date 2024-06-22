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
