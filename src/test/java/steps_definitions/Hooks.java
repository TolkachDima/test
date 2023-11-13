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
        options.setPlatformName(Platform.ANY.name());
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--headless=new"); // open headless browser
        options.addArguments("--start-maximized"); // open browser in maximized mode
        options.addArguments("--window-size=1920,1080"); // browser resolution
        options.addArguments("--enable-automation");
        options.addArguments("--disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // bypass OS security model
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--whitelisted-ips"); // bypass whitelisted ips
        options.setExperimentalOption("excludeSwitches", new ArrayList(Arrays.asList("disable-popup-blocking"))); // disable Pop-ups
        options.setExperimentalOption("prefs", browserPrefs); // browser preferences
        options.setAcceptInsecureCerts(true); // bypass SSL certs
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
