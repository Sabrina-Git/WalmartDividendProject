Feature: Login Page Validation

  Background: opening the app
    Given user launches the application

    Scenario: Verify login page UI elements
      Then user should be on the login page
      And Username field should be displayed
      And Password field should be displayed
      And Keep me signed in checkbox should be unchecked

   #   @smoke
      Scenario: Verify login with valid credential
        When user enter username
        When user enter password
        When user click on LoginButton
        Then verify user should be navigated to the profile page

     #   Scenario Outline: Verify system behavior with invalid credentials
      #    When user enters valid or invalid <username> and <password>
       #   And user click on LoginButton
        #  Then verify that user receive an error <expectedMessage>
         # Examples:
          #|username | password | expectedMessage|
          #|"TestUser" | "Test@456" | "Password is incorrect. Please try again." |
          #|"TestUser1" | "Test@123" | "Password is incorrect. Please try again."|
          #|"TestUser1" | "Test@456" | "Password is incorrect. Please try again."|
@smoke
  Scenario Outline: Verify system's bahaviour of invalid data from a excel file
    When user enters invalid data from <rownum>
    And user click on LoginButton
    Then An <rownum> msg should be displayed at the page
    Examples:
      | rownum |
      | 1 |
      | 2 |
      | 3 |
