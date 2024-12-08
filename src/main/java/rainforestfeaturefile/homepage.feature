Feature: This is a feature file for Rainforest Homepage
  @One
  Scenario: Valid username Test
    Given User lands on the rainforest homepage
    When User clicks and enters valid username on the username field
    And User clicks and enters valid password on the password field
    When User clicks on the Login button
    Then User is successfully logged in

  @Two
  Scenario: Searching for a valid item using search bar
    Given User lands on the rainforest homepage
    When User clicks on the search bar and enter for an "item"
    When User clicks on the search button
    Then  User should see the search results

  @Three
  Scenario Outline: Searching for multiple items
    Given User lands on the rainforest homepage
    When User serches for an "<item>"
    When User clicks on the search button
    Then  User should see the search results

    Examples:
    |item|
    |Rainforest|
    |Tree|

    @Four
    Scenario Outline: Tests for multiple username and password
      Given User lands on the rainforest homepage
      When User enters username "<Username>"
      And  User enters password "<Password>"
      When User clicks on the Login button
      Then  User is successfully logged if user is valid in or see an error message if user is invalid

      Examples:
      |Username||Password|
      |username1||password1|
      |User     ||Pass     |
      |Demo     ||Dummy    |