
# Computer Shop Management System

This project implements a Computer Shop Management System using Spring Boot and Thymeleaf. It allows users to manage products and parts, check inventory, and make purchases. Below are the key features and changes made in this project:

## Features Implemented:

### 1. Product Management:
   - **Add, Update, Delete:** Users can add new products, update existing ones, and delete products from the inventory.
   - **Inventory Tracking:** The system keeps track of product inventory, ensuring products are not sold when out of stock.

### 2. Part Management:
   - **Add, Update, Delete:** Users can add new parts, update their details, and remove parts from the inventory.
   - **Inventory Validation:** Parts have minimum and maximum inventory limits, preventing values outside this range.

### 3. Purchase Functionality:
   - **Buy Now Button:** A "Buy Now" button allows users to purchase products, reducing inventory when a purchase is made.

### 4. Data Validation:
   - **Price Validation:** Product and part prices are validated to ensure they are positive values.
   - **Inventory Validation:** Parts have minimum and maximum inventory limits, preventing invalid inventory values.

### 5. Error Handling and User Messages:
   - **Error Messages:** Custom error messages are displayed to users when they attempt to perform invalid actions (e.g., buying out-of-stock products, setting invalid inventory values).

## Changes Made:

### 1. Inventory Validation:
   - Implemented custom validators for price, inventory minimum, and inventory maximum to enforce data integrity and provide clear error messages.

### 2. Purchase Functionality Enhancement:
   - Enhanced the "Buy Now" functionality to display purchase success or failure messages using modals, providing a better user experience.

### 3. User Interface Improvements:
   - **Modal Popups:** Utilized modals for displaying messages, improving user interaction and feedback.

### 4. Repository Changes:
   - **Database File:** Updated the database file path in `application.properties` for storing persistent data.

### 5. Readability and Code Cleanup:
   - **Removed Unused Code:** Unused validators and classes were removed to maintain a clean codebase.
   - **Code Comments:** Added comments for clarity and documentation purposes.

## How to Run the Project:

1. Clone the repository to your local machine.
2. Ensure you have Java and Maven installed.
3. Navigate to the project directory using the terminal/command prompt.
4. Run `mvn spring-boot:run` to start the application.
5. Access the application in your web browser at `http://localhost:8080`.
