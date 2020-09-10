@C_F001 @login
Feature: User should be able to successfully login in the application

  @smoke @login
  Scenario: Login with valid credentials (positive test)
    Given user go to the main page and verify title is "Here's to great coffee served all day, every day"
    When user go to the sign in page and verify title "Sign In"
    And user enter the valid credential and click submit button
    Then verify user successfully login with title "Welcome back, Adam."


  @negative         # Data Driven Testing
  Scenario Outline: Login with invalid credentials(negative test <type>)
    Given user go to the main page and verify title is "Here's to great coffee served all day, every day"
    When user go to the sign in page and verify title "Sign In"
    And user enter "<userEmail>" user email and "<password>" password with invalid and click submit button
    Then Verify error message is "An error has occurred!"
    Examples:
      | userEmail             | password    | type                     |
      | sezen_aksu@gmail.com  | sezen1234+  | email and password wrong |
      | tarkan@gmail.com      | Adembaba40+ | email wrong              |
      | ademsalaruk@gmail.com | adembaba40+ | password wrong           |
      |                       | Adembaba40+ | email blank              |
      | ademsalaruk@gmail.com |             | password blank           |
      |                       |             | email and password blank |




