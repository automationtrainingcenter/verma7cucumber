Feature: branch creation 

 Background: 
    Given admin is in bank home page
    And admin is in admin home page by doing valid login
    And admin clicks branches button
    And admin clicks new branch button


Scenario: branch creation reset with valid data from json file
	When admin clicks reset button after entering data from "branchdata.json" then admin can an empty form
