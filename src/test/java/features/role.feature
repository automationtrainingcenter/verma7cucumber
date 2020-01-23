Feature: role creation
  Description: verify role creation functionality with valid and invalid data and also with 
  multiple data

  Scenario: role creation with valid data
    Given admin is in bank home page
    And admin is in admin home page by doing valid login
    And admin clicks roles button
    And admin clicks on new role button
    When admin enters role name
    And admin selects role type
    And admin click on submit button
    Then admin can see a message saying new role created successfully with some id
