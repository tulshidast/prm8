Feature: Login feature
         this feature will test login functinality
         
Background:
Given launch application
         
Scenario Outline:
: verify valid login
 
 When user enters "<username>" in username text field
 And user enters password in password text field
 And user click on login button
 Then user logged in successfully
 #And quite browser
 
Examples:
|username|
|admin|
|admin1|
