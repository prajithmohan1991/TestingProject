Feature: Validate the login functionality of facebook page
Scenario:Validate the login with invalid username and invalid password
Given user should launch the chrome browser and load the url
When user should input the invalid username and invalid password in the textbox
And user should click the login button
Then user should navigate to incorrect credential page
