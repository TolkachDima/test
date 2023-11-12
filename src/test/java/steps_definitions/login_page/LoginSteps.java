package steps_definitions.login_page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.JoinPage;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps_definitions.Hooks;

public class LoginSteps {
    private WebDriver driver = Hooks.driver;

    LoginPage loginPage = new LoginPage(driver);


    @Given("User click on sign in button")
    public void signInButtonClick(){
        loginPage.clickSignInButton();
    }

    @And("User already open the website")
    public void verifyLoginPage(){
        loginPage.switchToFrame();
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


    @Then("User already on account page")
    public void getTextUserName() {
        loginPage.switchToMainPage();

        Assert.assertEquals(loginPage.getTextUserName(), "Hi, Test First");
    }

    @Then("User observe error message")
    public void getErrorText() {

        Assert.assertEquals(loginPage.getTextError(), "Something went wrong, and your request wasn't submitted. Please try again later.");
    }


}
