package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public static WebDriver webDriver;

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//*[@class=\"shopping_cart_link\"]")
    private WebElement checkoutIcon;

    @FindBy(xpath = "//*[@class=\"shopping_cart_badge\"]")
    private WebElement checkoutIconBadge;

    public void clickCheckoutIcon(){
        checkoutIcon.click();
    }

    public String getCheckoutIconBadgeData(){
        return checkoutIconBadge.getText();
    }

    public void clickAddToCartButton(String str) {
        webDriver.findElement(By.xpath("//*[text()='"+str+"']/ancestor::div[@class=\"inventory_item_label\"]/following-sibling::div[@class=\"pricebar\"]/button")).click();
    }

}
