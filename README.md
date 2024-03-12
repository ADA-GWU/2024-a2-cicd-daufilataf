[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/jwssRZI4)

Project README
Overview
This project is a Spring Boot application that manages student information. It provides functionalities to update student records and search for students by name. This README file provides an overview of the project and details the test cases implemented to ensure the functionality works as expected.

Test Cases
UpdateUser Test
Description: This test case verifies the functionality to update a user's information.
Test Method: UpdateUser()
Test Steps:
Navigates to the update page for a user with ID 1.
Waits for input fields to be present.
Clears existing data in input fields and enters new data.
Checks checkboxes for specific courses.
Submits the form.
Expected Result:
User information should be updated successfully.
The updated user should have the new information reflected on the list page.
CheckUpdatedUser Test
Description: This test case verifies that the updated user information is correctly reflected on the list page.
Test Method: CheckUpdatedUser()
Test Steps:
Navigates to the list page.
Searches for the updated user's first and last name.
Expected Result:
The updated user's first and last name should be present in the list.
testStudentBoth Test
Description: This test case verifies the functionality to search for a student by first and last name.
Test Method: testStudentBoth()
Test Steps:
Mocks a list of students.
Calls the service method to search for students with a specific first and last name.
Expected Result:
The method should return a list containing the expected student.
testStudentSearchbyName Test
Description: This test case verifies the functionality to search for a student by name.
Test Method: testStudentSearchbyName()
Test Steps:
Mocks a list of students with the specified name.
Calls the repository method to search for students by name.
Expected Result:
The method should return a list containing the expected student.
