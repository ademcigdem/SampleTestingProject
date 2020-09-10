package com.costa.pages;

import com.costa.utilities.Driver;
import com.costa.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.accessibility.AccessibleSelection;

import static com.costa.utilities.Utils.*;

public class ApplicationBasePage {

    public ApplicationBasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "div[class='logo__Logo-ymc9hh-0 gYjfBV gatsby-image-wrapper']")
    public WebElement homePageBtn;

    @FindBy(css = "li[class='mainNav__Links-yvfgl4-1 jZXCmk'] a[aria-current='page']")
    public WebElement ourCoffeesModuleBtn;

    @FindBy(xpath = "//a[contains(text(),'Our menu')]")
    public WebElement ourMenuModuleBtn;

    @FindBy(xpath = "//a[contains(text(),'Order online')]")
    public WebElement orderOnlineModuleBtn;

    @FindBy(xpath = "//a[contains(text(),'Coffee Club')]")
    public WebElement coffeClubModuleBtn;

    @FindBy(css = "a[href='/behind-the-beans']")
    public WebElement behindTheBeansModuleBtn;

    @FindBy(xpath = "//a[.='Gift cards']")
    public WebElement giftCardsModuleBtn;

    @FindBy(css = "a[href='/locations/store-locator']")
    public WebElement storeLocationBtn;

    @FindBy(css = "div[aria-label='Account Menu']")
    public WebElement accountLoginBtn;

    @FindBy(css = "div[data-cy='iconsbar__signinlink'] [href='/coffee-club/login']")
    public WebElement signInHoverBtn;

    @FindBy(css = "div[class='hero__Content-bw7wbl-5 jPHOj']")
    public WebElement mainTitleElement;


    /**
     * This method return main page title information text
     * @return string
     */
    public String getMainPageTitle(){
       return  mainTitleElement.getText();
    }

    /**
     * This method clicking the cookies accept
     */
    public void acceptCookies(){
        Driver.get().findElement(By.cssSelector("button[aria-label='Accept Cookie']")).click();
        waitFor(1);
    }









}
