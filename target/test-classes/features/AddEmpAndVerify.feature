Feature: Adding the employees in HRMS Application and verifying
@hw
  Scenario: Adding one employee from feature file
# Given user is navigated to HRMS application
When user enters valid admin credentials
And user clicks on login button
Then admin user is successfully logged in
When user clicks on PIM option
And user clicks on add employee option
And user enters "Janusz" "Stefan" and "Maj"
And user clicks on save button
Then employee "Janusz" "Stefan" and "Maj" added successfully