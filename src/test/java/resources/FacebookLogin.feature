Feature: Facebook Login Feature

Scenario: Login with valid username & password
Given I navigate to "https://facebook.com" login page
When I enter valid username "anand.ec.2002@gmail.com" and password "@anand123#"
Then I see facebook home page