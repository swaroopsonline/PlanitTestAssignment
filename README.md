# PlanitTestAssignment

This is a sample project that demonstrates how to use the Page Object Model pattern with Data Driven approach to automate web applications with Selenium.

## Getting Started

To get started, you will need to install the following main dependencies(For the complete set of dependencies, please refer the POM.xml of the project):

* Java 8
* Maven
* Selenium WebDriver
* TestNG

Once you have installed the dependencies, you can clone the project from GitHub:


git clone https://github.com/swaroopsonline/PlanitTestAssignment.git

## Running the Tests

To run all the tests, you can run the testng.xml located at the path 'src/test/resources/runner/testng.xml'.
Alternatively you may run the testng1, testng2 & testng3 individually to test individual Test cases.

## Structure of the Project

The project is structured as follows:

* `src/main/java`: This directory contains the Java source code for the project(i.e., the Business logic is coded in the same).
* `src/test/resources`: This directory contains the resources for the project, such as the test data in the excel, the Properties and the runner files.
* `src/test/java`: This directory contains the Testcases and utilities for the project.

## Reporting in the Project

* Reporting is enabled using the Extent reporting with the latest successful run attached. It can be accessed in the 'reports' directory.

## The Page Object Model Pattern

The Page Object Model pattern is a design pattern that can be used to improve the maintainability and readability of Selenium tests. The pattern involves creating classes that represent the different pages in the application under test. Each page object class contains methods that interact with the elements on the page.

## Benefits of Using the Page Object Model Pattern

There are several benefits to using the Page Object Model pattern, including:

* Improved maintainability: The Page Object Model pattern makes it easier to maintain Selenium tests because the code for interacting with each page is centralized in a single class. This makes it easier to find and fix bugs, and to add new features.
* Improved readability: The Page Object Model pattern makes Selenium tests easier to read because the code for interacting with each page is organized in a logical way. This makes it easier for other developers to understand how the tests work.
* Increased testability: The Page Object Model pattern makes it easier to write testable code because the code for interacting with each page is isolated from the rest of the test code. This makes it easier to write unit tests for the page object classes.


