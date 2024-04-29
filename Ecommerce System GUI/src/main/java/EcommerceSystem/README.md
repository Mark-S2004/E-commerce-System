# E-commerce System - System Package

This directory contains the system package classes for the E-commerce System GUI. These classes play a crucial role in the functionality of the application. Here’s an overview of the system package.

## Main Classes Overview

- *AccountManager*: Static class responsible for creating, authenticating and storing accounts
- *OrderManagement*: Responsible for handling orders made by each user
- *ProductCatalog*: Static class responsible for adding, removing, searching and storing products

## White-Box Testing Approach

White Box Testing (also known as structural or glass box testing) focuses on the internal logic, structure, and coding of the software.
Testers have access to the source code and design documents, allowing them to inspect and verify the software’s inner workings.
Here’s how we approach white-box testing for the system package classes:

### [Code Coverage](https://ecommerce-junit-coverage-report.netlify.app/)

Ensure complete code coverage by designing test cases that exercise all parts of the code. This includes testing different branches, loops, and conditions within each class.

### Unit Testing

Write unit tests for each system package class. These tests should cover individual methods and functions.
Verify that methods handle edge cases, invalid inputs, and boundary conditions appropriately.

### Error Handling and Exception Testing

Test error-handling scenarios (e.g., invalid input, database connection failure).
Ensure exceptions are caught and handled appropriately.
