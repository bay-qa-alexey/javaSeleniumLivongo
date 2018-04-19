package driverSetup;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DriverSetup {

    static protected WebDriver driver;

    static String pathToDriver = Paths.get(System.getProperty("user.dir")).toAbsolutePath().toString() +
            File.separator + "src"+ File.separator + "test" + File.separator + "java"+ File.separator + "driverSetUp" + File.separator;
    public enum Browser {
        Chrome,
        IE,
        Firefox
    }

    public static WebDriver setupDriver(Browser browser, String driverFileName) {
        WebDriver driver = null;
        String osName = (System.getProperty("os.name").toLowerCase().contains("mac") ? "mac" : "windows");
        if(browser == Browser.Chrome) {
            if (osName.equals("windows")) {
                System.setProperty("webdriver.chrome.driver", pathToDriver + driverFileName);
            } else {
                System.setProperty("webdriver.chrome.driver", pathToDriver + driverFileName);
            }
            driver = new ChromeDriver();
        }

        else if(browser == Browser.Firefox) {
            //Add config
        }

        else if(browser == Browser.IE) {
            //Add config
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }


    @BeforeClass(alwaysRun = true)
    public void setupClass()
    {

    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass()
    {

    }

    @BeforeMethod(alwaysRun = true)
    public void setupTest()
    {
        driver = DriverSetup.setupDriver(Browser.Chrome, "chromedriver");
        driver.get("https://welcome.integration.livongo.com/#/?_vis_test_id=4&_vis_opt_random=0.7494647611939103&_vis_hash=cda431ef841ab55f45ed887f56cfa777&_vis_opt_preview_combination=1");
        driver.manage().window().maximize();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDownTest()
    {
        driver.quit();
    }


}
