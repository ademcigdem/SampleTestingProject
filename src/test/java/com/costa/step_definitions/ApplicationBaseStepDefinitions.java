package com.costa.step_definitions;

import com.costa.pages.ApplicationBasePage;
import io.cucumber.java.en.*;
import org.junit.Assert;

import static org.junit.Assert.*;

public class ApplicationBaseStepDefinitions {

    ApplicationBasePage appBase = new ApplicationBasePage();

    @Given("user go to the main page and verify title is {string}")
    public void user_go_to_the_main_page_and_verify_title_is(String expectedTitleText) {
        appBase.acceptCookies();
        assertEquals("Verify Main Page Title",expectedTitleText,appBase.getMainPageTitle() );
    }
}
