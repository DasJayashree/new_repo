Feature: User redirect to the sign up page and can signin

Scenario: Verify user navigation to sign up
Given  User is on valid webpage
When User click on sign up button should redirect to sign up page

Scenario Outline:  User should only be able to login with valid credentials
Given  User is on valid webpage
When User click on sign up button should redirect to sign up page
And User enterd the valid username as "<someusername>" and password as "<somepassword>" into the fields
Examples:
|someusername  |somepassword|
|jayashree123     |testEdureka|