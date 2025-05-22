@ForgotPasswordTests
Feature: To Test the Forgot Password Functionalities for ValianttInfo
	Scenario: Validate the Input Design
		Given user is in the login page
		When user clicks on forgot password link
		Then user should be able to see forgot password inputs 