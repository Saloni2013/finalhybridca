Feature: Log in Validation
@HomePageLogin
Scenario Outline: Validating With valid UserName And Password
	Given URl opened with URL for login
	Then Clicked one Sign in button
	Then Enter Valid "<UName>" and "<Pwd>"
	And click one log in button
	Then user will redirect to my account page


Examples:
|UName|Pwd|
|motog05052000@gmail.com| 12345|
	