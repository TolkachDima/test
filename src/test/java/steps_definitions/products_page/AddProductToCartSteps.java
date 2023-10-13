package steps_definitions.products_page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.CheckoutPage;
import org.example.pageObject.ProductPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import steps_definitions.Hooks;

public class AddProductToCartSteps {
    private final WebDriver driver = Hooks.driver;

    ProductPage productPage = new ProductPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);




    @When("User add item: {string} into a cart")
    public void AddingCart(String str) {
        productPage.clickAddToCartButton(str);
    }

    @Then("Shopping cart badge {string}")
    public void VerifyShoppingCartBadge(String str) {
        Assert.assertEquals(str, productPage.getCheckoutIconBadgeData());
    }

    @When("User click on cart icon")
    public void ClickOnCartIcon() {
        productPage.clickCheckoutIcon();
    }

    @When("User click checkout button")
    public void ClickCheckout() {
        checkoutPage.clickCheckoutIcon();
    }

    @Then("User verify page title {string}")
    public void VerifyCartPage(String str) {
        Assert.assertEquals(str, checkoutPage.verifyCartPageTitle());
    }

    @And("User verify product name {string}")
    public void VerifyCartProductName(String str) {
        Assert.assertEquals(str, checkoutPage.verifyCartProductName());
    }

    @When("User set input {string} as firstName")
    public void inputUsername(String firstName) {
        checkoutPage.setInputFirstName(firstName);
    }

    @And("User set input {string} as lastName")
    public void inputPassword(String lastName) {
        checkoutPage.setInputLastName(lastName);
    }

    @And("User set input {string} as Postal Code")
    public void inputPostalCode(String postalCode) {
        checkoutPage.setInputPostalCode(postalCode);
    }

    @And("User click continue button")
    public void clickContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @And("User click Finish button")
    public void clickFinishButton() {
        checkoutPage.clickFinishButton();
    }

    @And("User click Back To Products button")
    public void clickBackToProductsButton() {
        checkoutPage.clickBackToProductsButton();
    }

}
