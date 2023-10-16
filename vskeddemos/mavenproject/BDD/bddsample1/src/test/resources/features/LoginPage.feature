Feature: login function test
Scenario: check login is success
Given User is on login
When User enters valid username and password
Then User is navigated to Home page
And Print good