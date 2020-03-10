Feature: Verifying the Login of the application

  Scenario: To validate the login functionality with test credentials
    Given User should be in the login page
    When user enters the username and password
    Then user clicks the login button

  Scenario Outline: To validate the search box to search the products
    Given user in homepage view
    When user enters the products "<prd>" in search box
    Then user clicks the go button

    Examples: 
      | prd       |
      | men shoes |
      | toys      |
      | Iphones   |
