# Welcome to My Automated Test Repo!
There are two practices to coding and running automated tests. 

## Getting Started
I have used a couple of frameworks in this practice. You can see all the dependencies on pom.xml.

### Selenium WebDriver
- In this test automation process, I preferred Selenium WebDriver tool with Java language.
- The fact that Selenium WebDriver is open source and supports multiple languages makes its use widespread. In this way, we can get more resource support.
- I used version 4.25.0 of Selenium WebDriver in this test.
- There are two things we need for Selenium WebDriver: A browser and a webdriver for the browser.
- I chose Mozilla Firefox for this test.

### BDD
- BDD helps to understand the business requirements of the software and develop it based on these requirements.
- BDD facilitates communication between technical and non-technical team members and creates scenarios for all stakeholders to understand.
- It allows test cases to be written early in the development process, which facilitates requirements analysis.
- BDD scenarios can be implemented as automated tests, which offers the possibility to continuously test specific functions of the software.

### TestNG
- TestNG makes the source code where we write our tests look cleaner.
- It shows the status of our tests with annotations such as _@BeforeMethod_, _@Test_, _@AfterMethod_.
- It also shortens test times by running our tests simultaneously.
- By grouping the tests, it allows to run different test scenarios according to different conditions.
- I used version 7.10.2 of TestNG in this test.

### RestAssured
- Makes interacting with RESTful APIs simple. Allows you to easily create HTTP requests.
- Supports anotations used in Java (e.g. JUnit or TestNG) when writing test cases.
- It allows mapping data to Java classes to make API responses more meaningful.
- It provides a convenient structure for writing automated test cases, which makes it easier to use in CI/CD processes.
- Provides detailed error messages for debugging and viewing test results.
- I used version 4.4.0 of RestAssured in this test.

<hr>

## Test Automation - I (UI)

### BDD Structure
Firstly we should write our scenarios in BDD structure. This test validates the comments likes' of product.
```cucumber
Feature: Like the first comment on Amazon product

  Scenario: Liking the first comment of a product
    Given I open https://www.amazon.com.tr
    When I user search for "iphone" in the search bar
    Then I user retrieve the list of products
    And I user click on the first product
    And I user navigate to the comments section
    Then I user click the like button on the first comment
```

## Test Automation - II (API)
### GET Requests
```cucumber
Feature: Get User List (Happy Path)

  Scenario: Successfully retrieve a user
    Given the API is available at "https://reqres.in/api"
    When I send a GET request to "/users/2"
    Then the response status code should be 200
    And the response body should contain user details
```

```cucumber
Feature: Get User List (404 - User Not Found)

  Scenario: User not found
    Given the API is available at "https://reqres.in/api"
    When I send a GET request to "/users/23"
    Then the response status code should be 404
    And the response body should show an error message
```
### POST Requests
#### Happy Path
```cucumber
Feature: Login Account (Happy Path)

  Scenario: Successfully login with valid credentials
    Given the API is available at "https://reqres.in/api"
    And I have valid login credentials
    When I send a POST request to "/login" with the credentials
    Then the response status code should be 200
    And the response body should contain the token

```
#### Invalid Password
```cucumber
Feature: Login Account (400 - Invalid Password)

  Scenario: Fail to login due to missing password
    Given the API is available at "https://reqres.in/api"
    And I have an email but no password
    When I send a POST request to "/login"
    Then the response status code should be 400
    And the response body should contain an error about missing password

```
#### Invalid Bearer Token
```cucumber
Feature: Login Account (401 - Invalid Bearer Token)

  Scenario: Fail to login due to invalid bearer token
    Given the API is available at "https://reqres.in/api"
    And I have valid login credentials
    When I send a POST request to "/login" with an invalid bearer token
    Then the response status code should be 401
    And the response body should contain an authentication error
```

## Bug Reports

### BUG: 
### BUG: 
