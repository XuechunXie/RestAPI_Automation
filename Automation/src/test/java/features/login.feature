Feature: Application Login


Scenario: Home page default login
Given user is on NetBanking landing page
When User login into application with "Mike" and "1234"
Then Home page is populated
And Cards displayed is "true"

Scenario: Home page default login
Given user is on NetBanking landing page
When User login into application with "Michelle" and "5678"
Then Home page is populated
And Cards displayed is "false"