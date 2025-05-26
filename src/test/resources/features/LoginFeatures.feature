@LoginTests
Feature: To Test the Login Functionalities of Valiantt Info

  Background: 
    Given user is in the login page

  Scenario: Validate the Login Form Design
    Then user can able to see the input elements and submit button

  Scenario Outline: Verify successful login with valid credientials
    And user enters <username> and <password>
    When user clicks on login button
    Then user can able to see the dashboard page

    Examples: 
      | username          | password    |
      | "joel_viltrumite" | "Vrdella!6" |

  Scenario Outline: Verify failiure logins with invalid credientials
    And user enters <username> and <password>
    When user clicks on login button
    Then user should see a error prompt or alert

    Examples: 
      | username | password    |
      | "joel"   | "Vrdella"   |
      | "@3442"  | "123422233" |
      | "KJ2@3"  | "veD#2@1"   |
