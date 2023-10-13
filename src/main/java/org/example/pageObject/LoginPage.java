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


    @FindBy(xpath = "//*[@placeholder=\"Username\"]")
    private WebElement inputUsername;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(name = "login-button")
    private WebElement buttonLogin;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartItem;

    @FindBy(xpath = "//*[@data-test='error']")
    private WebElement loginErrorMsg;


    public boolean verifyLoginPage(){
        return inputUsername.isDisplayed();
    }

    public void setInputUsername(String username){
        inputUsername.sendKeys(username);
    }

    public void setInputPassword(String username){
        inputPassword.sendKeys(username);
    }

    public void clickLoginButton(){
        buttonLogin.click();
    }

    public boolean isLoginSuccessful(){
        return shoppingCartItem.isDisplayed();
    }

    public String isLoginError(){
        return loginErrorMsg.getText();
    }
}
