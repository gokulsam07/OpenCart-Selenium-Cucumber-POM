Feature: Global search feature
  Verify if the global search feature works fine with & without valid search keyword

  Scenario: Search with existent product
    Given user opens the application
    When user enters "HP" in the search field
    And user clicks on the search button
    Then only relevant products should be displayed

  Scenario: Search with nonexistent product
    Given user opens the application
    When user enters "Dominos" in the search field
    And user clicks on the search button
    Then relevant error should be displayed

  Scenario: Search with no product
    Given user opens the application
    And user clicks on the search button
    Then relevant error should be displayed
