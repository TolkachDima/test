package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public static WebDriver webDriver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//*[@aria-label = 'Sign In']/span[1]")
    private WebElement signInButton;
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement inputUsername;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@data-e2e=\"signInButton\" and @type=\"submit\"]")
    private WebElement buttonLogin;

    @FindBy(xpath = "//*[@data-e2e=\"loginIframe\"]")
    private WebElement frameLogin;
    @FindBy(xpath = "//*[@data-e2e=\"errorText\"]")
    private WebElement errorText;


    @FindBy(xpath = "//*[@id=\"menu-button--menu--5\"]/span[1]")
    private WebElement textUserName;

    public boolean verifyLoginPage(){
        return inputUsername.isDisplayed();
    }

    public void setInputUsername(String username){
        inputUsername.sendKeys(username);
    }

    public String getTextUserName(){
        return textUserName.getText();
    }

    public String getTextError(){
        return errorText.getText();
    }
    public void setInputPassword(String username){
        inputPassword.sendKeys(username);
    }

    public void clickSignInButton(){
        signInButton.click();
    }
    public void clickLoginButton(){
        buttonLogin.click();
    }

    public void switchToFrame(){
         webDriver.switchTo().frame(frameLogin);
    }

    public void switchToMainPage(){
        webDriver.switchTo().defaultContent();
        Object lock = new Object();
        try {
            synchronized (lock) {
            Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
