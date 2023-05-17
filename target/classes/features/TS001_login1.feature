Feature: Login Action
Scenario: Verify Login with valid data
Given user is on home page
When user clicks on Signin
Then Verify title in next page as Rediffmail
When user enters user name password clicks on Submit button
Then verify user and display message as Login Successful
And Logout

Scenario: Verify Login with invalid data
Given user is on home page
When user clicks on Signin
Then Verify title in next page as Rediffmail
When user enters invalid user name or password clicks on Submit button
Then verify error message 
And close