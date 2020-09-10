package com.costa.pages;

import com.costa.utilities.ConfigurationReader;
import com.costa.utilities.Driver;
import com.costa.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.costa.utilities.Utils.*;


public class LoginPage extends ApplicationBasePage{

    WebDriverWait wait = new WebDriverWait(Driver.get(),10);


    @FindBy(css = "h1[class='header headerText']")
    public WebElement loginPageTitleElement;

    @FindBy(id = "longEmail")
    public WebElement userEmailInputBox;

    @FindBy(id = "oldPassword")
    public WebElement userPasswordInputBox;

    @FindBy(css = "button[data-cy='submit__CTA'] ")    //xpath = "//span[.='Submit']"
    public WebElement submitBtn;

    @FindBy(css = "h1[data-cy='accounthomeheader']")
    public WebElement myAccountTitleElement;

    @FindBy(css = "header[data-cy='popup__heading'] h3")
    public WebElement errorMessageElement;

    @FindBy(css = "span[data-cy='toggle__password']")
    public WebElement eyeToogleElement;


    /**
     * This method for click sign in button and login
     */
    public void getSignInPage(){
        accountLoginBtn.click();
        waitFor(1);
        hover(signInHoverBtn);
        signInHoverBtn.click();
        try{
        wait.until(ExpectedConditions.urlToBe("https://www.costa.co.uk/coffee-club/login"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * This method fill out all valid credentials and waiting for new url
     */
    public void loginWithValidCredentials(){
        waitFor(1);
        userEmailInputBox.sendKeys(ConfigurationReader.get("user_name"));
        waitFor(2);
        userPasswordInputBox.sendKeys(ConfigurationReader.get("user_password"));
        eyeToogleElement.click();
        waitFor(2);
        clickWithJS(submitBtn);
        waitFor(2);
        try{
            wait.until(ExpectedConditions.urlToBe("https://www.costa.co.uk/coffee-club/account-home/"));
        }catch (Exception e){
            Driver.get().findElement(By.xpath("//span[.='Close']")).click();
            waitFor(2);
            submitBtn.click();
        }
    }

    /**
     * This method for invalid login
     * @param userEmail invalid data
     * @param password invalid data
     */
    public void invalidLogin(String userEmail,String password){
        userEmailInputBox.sendKeys(userEmail);
        waitFor(2);
        userPasswordInputBox.sendKeys(password);
        waitFor(2);
        submitBtn.click();
        waitFor(5);
    }


    /**
     * This method return sign in page error message
     * @return error message
     */
    public String getErrorMessage(){
       return errorMessageElement.getText();
    }


}
