Feature: login functionality
  Description: verfify login functionality with valid and invalid credentials

  Scenario: login with valid credentials
    Given admin is in bank home page
    When admin enters valid username
    And admin enters valid password
    And admin clicks on login button
    Then admin can see welcome to admin message with logout link
    
	Scenario: login with invalid password
		Given admin is in bank home page
		When admin enters valid username
		But admin enters invalid password
		And admin clicks on login button
		Then admin can see an error message saying incorrect bankername or password
		
	Scenario: login with invalid username
		Given admin is in bank home page
		When admin enters invalid username
		And admin enters valid password
		And admin clicks on login button
		Then admin can see an error message saying incorrect bankername or password
		
