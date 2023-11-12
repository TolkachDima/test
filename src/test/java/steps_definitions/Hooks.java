package steps_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void openBrowser(){

        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions option = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        option.addArguments("--remote-allow-origins=*");
        String appUrl = "https://www.hilton.com/en/hilton-honors/";

        driver = new ChromeDriver(option);
        driver.get(appUrl);
        driver.manage().window().maximize();
    }

//    @After
//    public void closeBrowser(){
//        driver.quit();
//    }
}
