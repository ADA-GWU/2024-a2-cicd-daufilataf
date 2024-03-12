[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/jwssRZI4)

# Project README

## Overview
This project is a Spring Boot application that manages student information. It provides functionalities to update student records and search for students by name. This README file provides an overview of the project and details the test cases implemented to ensure the functionality works as expected.

## Test Cases

### 1. Update User Test
   
- **Description**: This test case verifies the functionality of updating a user's information.
- **Test Method**: Automated UI test using Selenium WebDriver.
- **Test Steps**:
    1. Navigate to the user update page.
    2. Locate input fields for first name, last name, and email.
    3. Fill in new user information.
    4. Check specific checkboxes.
    5. Submit the form.
- **Expected Outcome**: The user information should be updated successfully.

### 2. Check Updated User Test

- **Description**: This test case checks if the updated user's information is correctly reflected on the user list page.
- **Test Method**: Automated UI test using Selenium WebDriver.
- **Test Steps**:
    1. Navigate to the user list page.
    2. Search for the updated user's first and last name.
- **Expected Outcome**: The updated user's information should be displayed on the user list page.

### 3. Search by First and Last Name Test

- **Description**: This test case validates the functionality of searching for a student by their first and last name.
- **Test Method**: JUnit test.
- **Test Steps**:
    1. Create a list of mocked students.
    2. Mock the behavior of the student repository to return the list of mocked students.
    3. Invoke the method to search for students by first and last name.
- **Expected Outcome**: The method should return the correct student based on the provided first and last name.

### 4. Search by Name Test

- **Description**: This test case verifies the functionality of searching for a student by their name.
- **Test Method**: JUnit test.
- **Test Steps**:
    1. Mock the behavior of the student repository to return a list of mocked students with the specified name.
    2. Invoke the method to search for students by name.
- **Expected Outcome**: The method should return the correct student with the specified name.


