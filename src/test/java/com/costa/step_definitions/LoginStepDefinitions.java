package com.costa.step_definitions;

import com.costa.pages.LoginPage;
import io.cucumber.java.en.*;

import static com.costa.utilities.Utils.*;
import static org.junit.Assert.*;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @When("user go to the sign in page and verify title {string}")
    public void user_go_to_the_sign_in_page_and_verify_title(String expectedTitleText) {
        loginPage.getSignInPage();
        assertEquals("Verify Expected Title ", expectedTitleText, loginPage.loginPageTitleElement.getText());
    }

    @When("user enter the valid credential and click submit button")
    public void user_enter_the_valid_credential_and_click_submit_button() {
        loginPage.loginWithValidCredentials();
    }


    @Then("verify user successfully login with title {string}")
    public void verify_user_successfully_login_with_title(String expectedTitle) {
        waitFor(2);
        assertEquals("Verify user my account page title ", expectedTitle, loginPage.myAccountTitleElement.getText());
    }

    @And("user enter {string} user email and {string} password with invalid and click submit button")
    public void userEnterUserEmailAndPasswordWithInvalidAndClickSubmitButton(String invalidUserMail, String invalidUserPassword) {
        loginPage.invalidLogin(invalidUserMail,invalidUserPassword);
    }

    @Then("Verify error message is {string}")
    public void verifyErrorMessageIs(String errorMessage) {
      assertEquals("Verify Error Message ",errorMessage,loginPage.getErrorMessage());
    }
}
