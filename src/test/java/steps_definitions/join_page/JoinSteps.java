package steps_definitions.join_page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.JoinPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps_definitions.Hooks;

import java.time.Duration;

public class JoinSteps {

    private final WebDriver driver = Hooks.driver;


    JoinPage joinPage = new JoinPage(driver);
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("User already open the join website")
    public void verifyLoginPage() {
        joinPage.clickJoinButton();

        Assert.assertEquals(joinPage.verifyJoinPage(), "Join Hilton Honors");
    }


    @When("User set valid data in input fields")
    public void inputUsername() throws InterruptedException {
        Object lock = new Object();
        synchronized (lock) {
            lock.wait(2000);
        }
        joinPage.setInputFirstName();
        synchronized (lock) {
            lock.wait(2000);
        }
        joinPage.setInputLastName();
        synchronized (lock) {
            lock.wait(2000);
        }
        joinPage.setInputPhoneNumber();
        synchronized (lock) {
            lock.wait(2000);
        }
        joinPage.setInputEmail();
        synchronized (lock) {
            lock.wait(2000);
        }
        joinPage.setInputAddress();
        synchronized (lock) {
            lock.wait(2000);
        }
        joinPage.setInputPostal();
        synchronized (lock) {
            lock.wait(2000);
        }
        joinPage.setInputPassword();
        synchronized (lock) {
            lock.wait(2000);
        }
        joinPage.setInputConfirmPassword();
    }

    @And("User wait {int} sec")
    public void waitUser2(Integer time) {
        Object lock = new Object();

        synchronized (lock) {
            try {
                lock.wait(time * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



    @And("User click Join For Free Button")
    public void inputPassword() {
        joinPage.clickJoinForFreeButton();
    }

    @Then("User already on confirmation page")
    public void verifyHomePage(){
        Assert.assertTrue(joinPage.isJoinSuccessful());
    }

    @And("User saves login")
    public void saveLogin(){
        joinPage.setCustomerLogin();
    }


}
