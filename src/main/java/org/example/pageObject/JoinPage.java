package org.example.pageObject;

import org.example.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JoinPage {

    public static WebDriver webDriver;


    public JoinPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//*[@aria-label=\"Hilton Honors\"]/ul/li[1]/a")
    private WebElement joinButton;

    @FindBy(xpath = "//*[@class=\"container\"]/div/div/h1")
    private WebElement assertText;
    @FindBy(xpath = "//*[@name=\"name.firstName\"]")
    private WebElement inputFirstName;

    @FindBy(xpath = "//*[@name=\"name.lastName\"]")
    private WebElement inputLastName;

    @FindBy(xpath = "//*[@name=\"phone.phoneNumber\"]")
    private WebElement inputPhoneNumber;

    @FindBy(xpath = "//*[@name=\"address.addressLine1\"]")
    private WebElement inputAddress;

    @FindBy(xpath = "//*[@name=\"address.postalCode\"]")
    private WebElement inputPostal;

    @FindBy(xpath = "//*[@name=\"email.emailAddress\"]")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@name=\"password\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@name=\"confirmPassword\"]")
    private WebElement inputConfirmPassword;

    //*[@class="container"]/div/div/h1

    @FindBy(xpath = "//*[@type=\"submit\"]")
    private WebElement buttonJoinForFree;

    @FindBy(xpath = "//*[@class=\"inline-block\"]/p[1]")
    private WebElement textCustomerLoginId;


    public void clickJoinButton(){
        joinButton.click();
    }

    public void clickJoinForFreeButton(){
        buttonJoinForFree.click();
    }

    public String verifyJoinPage(){
        return assertText.getText();
    }


    public void setInputFirstName(String username){
        inputFirstName.sendKeys(username);
    }
    public void setInputFirstName(){
        inputFirstName.sendKeys(Utilities.getFirstName());
    }

    public void setInputLastName(String lastName){
        inputLastName.sendKeys(lastName);
    }

    public void setInputLastName(){
        inputLastName.sendKeys(Utilities.getLastName());
    }

    public void setInputPhoneNumber(String phoneNumber){
        inputPhoneNumber.sendKeys(phoneNumber);
    }

    public void setInputPhoneNumber(){
        inputPhoneNumber.sendKeys(Utilities.getPhoneNumber());
    }

    public void setInputEmail(String email){
        inputEmail.sendKeys(email);
    }
    public void setInputEmail(){
        inputEmail.sendKeys(Utilities.getEmail());
    }


    public void setInputAddress(String address){
        inputAddress.sendKeys(address);
    }

    public void setInputAddress(){
        inputAddress.sendKeys(Utilities.getStreetName());
    }

    public void setInputPostal(String postal){
        inputPostal.sendKeys(postal);
    }

    public void setInputPostal(){
        inputPostal.sendKeys(Utilities.getZip());
    }

    public void setInputPassword(String password){
        inputPassword.sendKeys(password);
    }


    public void setInputPassword(){
        System.out.println(Utilities.getPassword());
        inputPassword.sendKeys(Utilities.getPassword());
    }
    public void setInputConfirmPassword(){
        inputConfirmPassword.sendKeys(Utilities.getPassword());
    }

    public boolean isJoinSuccessful(){
        return textCustomerLoginId.isDisplayed();
    }

    public void setCustomerLogin(){
         Utilities.setLogin(textCustomerLoginId.getText().replaceAll("\\D+", ""));
    }





}
