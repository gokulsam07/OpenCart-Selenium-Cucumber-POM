Feature: Login feature
  Verify if the login functionality works if valid credentials is furnished

  Scenario: Login with valid credentials
    Given user navigates to login page
    When user enters the username "gokuls2381@gmail.com"
    And user enters the password "Gokul@123"
    And click login button
    Then it should login and open the accounts page

  Scenario: Login with invalid username and valid pasword
    Given user navigates to login page
    When user enters the invalid username 
    And user enters the password "Gokul@123"
    And click login button
    Then user should get a proper warning message

  Scenario: Login with valid username and invalid pasword
    Given user navigates to login page
    When user enters the username "gokuls2381@gmail.com"
    And user enters the password "Goul@123"
    And click login button
    Then user should get a proper warning message

  Scenario: Login with invalid username and invalid pasword
    Given user navigates to login page
    When user enters the username "gokul2381@gmail.com"
    And user enters the password "Gokl@123"
    And click login button
    Then user should get a proper warning message

  Scenario: Login with no credentials
    Given user navigates to login page
    When user enters the username ""
    And user enters the password ""
    And click login button
    Then user should get a proper warning message
