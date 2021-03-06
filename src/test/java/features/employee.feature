@employee
Feature: Employee creation

  Background: 
    Given admin is in bank home page
    And admin is in admin home page by doing valid login
    And admin clicks employee button
    And admin clicks new employee button

	@valid @create @dd
  Scenario Outline: employee creation with multiple sets of valid data
    When admin enters employee name "<empName>"
    And admin enters login password "<loginPass>"
    And admin selects role "<role>"
    And admin selects branch name "<branchName>"
    And admin clicks on submit button
    Then admin can see a message saying employee created successfully

    Examples: 
      | empName   | loginPass     | role         | branchName |
      | rameshOne | passwordOne   | employeeFour | srnagar    |
      | rakeshOne | passwordTwo   | employeeFour | srnagar    |
      | rajeshOne | passwordThree | employeeFour | srnagar    |
      | sureshOne | passwordFour  | employeeFour | srnagar    |
      | vermaOne  | passwordFive  | employeeFour | srnagar    |

	@invalid @dd
  Scenario: employee creation with invalid employee name
    When admin enters invalid employee name then admin can see an error message
      | empName |
      | abc     |
      |     123 |
      | a12     |
      | abcd@   |
      | ab24#   |


	@reset @dd @valid
  Scenario: employee creation reset with multiple sets of data
    When admin clicks reset button after filling form then admin can see an empty form
      | empName   | loginPass     | role         | branchName |
      | rameshOne | passwordOne   | employeeFour | srnagar    |
      | rakeshOne | passwordTwo   | employeeFour | srnagar    |
      | rajeshOne | passwordThree | employeeFour | srnagar    |
      | sureshOne | passwordFour  | employeeFour | srnagar    |
      | vermaOne  | passwordFive  | employeeFour | srnagar    |
