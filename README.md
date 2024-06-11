# Inventory Management System

## Overview
This Inventory Management System allows administrators to manage products in an e-commerce store's inventory, handle customers' shopping carts, and apply discount coupons.

## Features
- Add and remove items from inventory
- Add items to a customer's cart
- Apply discount coupons to a cart's total value
- View current inventory and cart contents

## Technologies Used
- Java
- Spring Boot
- Spring Web
- Maven

## Getting Started

### Prerequisites
- Java 11 or later
- Maven
- Postman (for API testing)
- AWS Account (for deployment, optional)

### Setup
1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/inventory-management-system.git
    cd inventory-management-system
    ```

2. **Build the project:**
    ```bash
    mvn clean package
    ```

3. **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

4. **Access the application:**
    Open your browser and navigate to `http://localhost:8080`.

## API Endpoints

### Add Item to Inventory
- **URL:** `/api/inventory/add`
- **Method:** `POST`
- **Parameters:**
  - `productId` (String): The ID of the product.
  - `quantity` (int): The quantity to add.
- **Description:** Adds a specified quantity of a product to the inventory.

### Remove Item from Inventory
- **URL:** `/api/inventory/remove`
- **Method:** `DELETE`
- **Parameters:**
  - `productId` (String): The ID of the product.
  - `quantity` (int): The quantity to remove.
- **Description:** Removes a specified quantity of a product from the inventory.

### Add Item to Cart
- **URL:** `/api/cart/add`
- **Method:** `POST`
- **Parameters:**
  - `customerId` (String): The ID of the customer.
  - `productId` (String): The ID of the product.
  - `quantity` (int): The quantity to add.
- **Description:** Adds a specified quantity of a product to a customer's cart.

### Apply Discount Coupon
- **URL:** `/api/cart/apply-discount`
- **Method:** `GET`
- **Parameters:**
  - `cartValue` (double): The total value of the cart.
  - `discountId` (String): The ID of the discount coupon.
- **Description:** Applies a discount coupon to the cart value and returns the discounted value.

### Add Discount Coupon
- **URL:** `/api/discount/add`
- **Method:** `POST`
- **Parameters:**
  - `discountId` (String): The ID of the discount coupon.
  - `percentage` (double): The discount percentage.
  - `maxDiscount` (double): The maximum discount amount.
- **Description:** Adds a new discount coupon.

### View Inventory
- **URL:** `/api/inventory`
- **Method:** `GET`
- **Description:** Retrieves the current inventory.

### View Cart
- **URL:** `/api/cart/{customerId}`
- **Method:** `GET`
- **Parameters:**
  - `customerId` (String): The ID of the customer.
- **Description:** Retrieves the contents of a customer's cart.

## Postman Collection
You can import the provided Postman collection to easily test the API endpoints. Download and import the collection from [here](your-postman-collection-link).
