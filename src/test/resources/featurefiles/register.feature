Feature: Register feature
  Verify if the user is able to register with a unique email address

  Scenario: Register account with unique email
    Given user navigates to register page
    When user enters the following fields
      | firstName      | Gokul                |
      | lastName       | Saminathan           |
      | email          | gokuls2381@gmial.com |
      | telephone      |           1234567891 |
      | password        | Gokul@123            |
      | confirmPassword | Gokul@123            |
    And user verifies the privacy policy
    And user clicks continue for page registration
    Then account should be created successfully

  Scenario: Register account with duplicate email
    Given user navigates to register page
    When user enters the following fields with duplicate email
      | firstName      | Gokul                |
      | lastName       | Saminathan           |
      | email          | gokuls2381@gmial.com |
      | telephone      |           1234567891 |
      | password        | Gokul@123            |
      | confirmPassword | Gokul@123            |
    And user verifies the privacy policy
    And user clicks continue for page registration
    Then proper warning should be given and account should not be created

  Scenario: Register account with no details
    Given user navigates to register page
    When user do not enter any details
    And user clicks continue for page registration
    Then proper warning should be given for all fields and account should not be created
