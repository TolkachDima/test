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
        ChromeOptions options = new ChromeOptions();
        // option.addArguments("start-maximized"); // open Browser in maximized mode
        // option.addArguments("disable-infobars"); // disabling infobars
        // option.addArguments("--disable-extensions"); // disabling extensions
        // option.addArguments("--disable-gpu"); // applicable to windows os only
        // option.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        // option.addArguments("--no-sandbox"); // Bypass OS security model
        // option.addArguments("headless");
        // option.addArguments("disable-gpu");
       
        options.addArguments("--remote-allow-origins=*");
        String appUrl = "https://www.hilton.com/en/hilton-honors/";

        driver = new ChromeDriver(options);
        driver.get(appUrl);
        driver.manage().window().maximize();
    }

   @After
   public void closeBrowser(){
       driver.quit();
   }
}
