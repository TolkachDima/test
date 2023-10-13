package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public static WebDriver webDriver;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement productTitle;
    @FindBy(id = "first-name")
    private WebElement inputFirstName;
    @FindBy(id = "last-name")
    private WebElement inputLastName;
    @FindBy(id = "postal-code")
    private WebElement inputPostalCode;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(id = "finish")
    private WebElement finishButton;
    @FindBy(id = "back-to-products")
    private WebElement backToProductsButton;

    public void clickCheckoutIcon() {
        checkoutButton.click();
    }

    public String verifyCartPageTitle() {
        return pageTitle.getText();
    }

    public String verifyCartProductName() {
        return productTitle.getText();
    }

    public void setInputFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void setInputLastName(String username) {
        inputLastName.sendKeys(username);
    }

    public void setInputPostalCode(String username) {
        inputPostalCode.sendKeys(username);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public void clickBackToProductsButton() {
        backToProductsButton.click();
    }


}
