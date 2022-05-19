Feature: Adding the employees in HRMS Application

  Background:
    When user enters valid admin credentials
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user clicks on add employee option

  @regression @safiul
  Scenario: Adding one employee from feature file
   # Given user is navigated to HRMS application
    When user enters valid admin credentials
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user clicks on add employee option
    And user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully


  Scenario: Adding one employee from feature file
   # Given user is navigated to HRMS application
    When user enters valid admin credentials
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user clicks on add employee option
    And user enters "zuhoor" "Mujeeb" and "silvia"
      And user clicks on save button
      Then employee added successfully


Scenario Outline: Adding multiple employees
  When user enters valid admin credentials
  And user clicks on login button
  Then admin user is successfully logged in
  When user clicks on PIM option
  And user clicks on add employee option
  And user provides "<firstName>" "<middleName>" and "<lastName>"
  And user clicks on save button
  Then employee added successfully
  Examples:
  |firstName|middleName|lastName|
  |asel     |MS        |tolga   |
  |yazgul   |MS        |kishan  |
  |tarik    |MS        |mujeeb  |
  |nassir   |MS        |volkan  |

  @datatable @test
  Scenario: add employee using data table
    When user provides multiple employee data and verify they are added
      |firstName|middleName|lastName|
      |Eren     |Levi        |Jaeger  |
      |Mikasa   |Sasha      |Ackerman|
      |Armin    |Jean        |Alert   |
      |Connie   |Reiner        |Springer|

    @excel
    Scenario: Adding multiple employees from excel file
      When user adds multiple employees from excel file using "EmployeeData" sheet and verify the user added

