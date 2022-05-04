Feature: Validation of login scenarios


Background:
  #Given user is navigated to HRMS application

  @batch12 @smoke @regression @sprint12
  Scenario: Admin login
#    Given user is navigated to HRMS application
    When user enters valid admin credentials
    And user clicks on login button
    Then admin user is successfully logged in

    @regression @smoke
  Scenario: ESS logins
#    Given user is navigated to HRMS application
    When user enters valid ESS username and password
    And user clicks on login button
    Then ESS user is successfully logged in

@regression @smoke
  Scenario: Invalid Login
#    Given user is navigated to HRMS application
    When user enters invalid username and password
    And user clicks on login button
    Then user see error message on the screen