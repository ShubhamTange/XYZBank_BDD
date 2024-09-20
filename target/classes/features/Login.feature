@priority1
Feature: Login Page
Scenario Outline:  To Validate login functionality
Given user is on xyz bank url
When user selects customer login 
And validate the url
Then user needs to select customer name from dropdown
Then user needs to click on login button'
And after login validate welcome message, account number and balance  