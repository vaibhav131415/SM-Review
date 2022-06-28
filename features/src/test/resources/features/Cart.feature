Feature: User Cart 

Background: 
Given user is on the homepage
When user clicks on Get it done button
Then user should get Cart pop-up with referenced items in it
And user clicks on SelectAll button


Scenario: To verify if user is able to select all items and View my selection button is enabled

Then View my selections button should be enabled



Scenario: To verify if Deselect all button is enabled when user clicks on SelectAll button in the user cart

Then Deselect All button should be enabled
