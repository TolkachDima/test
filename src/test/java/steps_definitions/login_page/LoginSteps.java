package steps_definitions.login_page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import steps_definitions.Hooks;

public class LoginSteps {
    private final WebDriver driver = Hooks.driver;

    LoginPage loginPage = new LoginPage(driver);

    @Given("User already open the website")
    public void verifyLoginPage(){
        Assert.assertTrue(loginPage.verifyLoginPage());
    }

    @When("User set input {string} as username")
    public void inputUsername(String username) {
        loginPage.setInputUsername(username);
    }

    @And("User set input {string} as password")
    public void inputPassword(String password) {
        loginPage.setInputPassword(password);
    }

    @And("User click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User already on homepage")
    public void verifyHomePage(){
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }

    @Then("User get {string} as error message")
    public void verifyUserError(String errorMessage) {
        Assert.assertEquals(errorMessage, loginPage.isLoginError());
    }


}
