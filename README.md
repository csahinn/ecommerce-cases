# Welcome to My Automated Test Repo!

## Test Automation - I (UI)

Firstly we should write our scenarios in BDD structure.
```gherkin
Feature: Like the first comment on Amazon product

  Scenario: Liking the first comment of a product
    Given I open "https://www.amazon.com.tr"
    When I user search for "iphone" in the search bar
    Then I user retrieve the list of products
    And I user click on the first product
    And I user navigate to the comments section
    Then I user click the like button on the first comment
```
