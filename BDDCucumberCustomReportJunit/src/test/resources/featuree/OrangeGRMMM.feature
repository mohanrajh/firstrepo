Feature: login functionality

Scenario: entering valid username and pswd

Given I load the "https://opensource-demo.orangehrmlive.com/"
Then I enter "Admin" into the element "//*[@id='txtUsername']"
And I enter "admin123" into the element "//*[@id='txtPassword']"
Then I click the element "//*[@id='btnLogin']"


