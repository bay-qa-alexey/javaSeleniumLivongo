package pageObjects;

import org.openqa.selenium.By;
import driverSetup.DriverSetup;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends DriverSetup {

    private static By bySignup  = By.cssSelector("button#landing-button-signup");

    public static void waitUntilPageLoad(int sec) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.elementToBeClickable(bySignup));
    }

    public static void clickJoinNowBtn() {
        driver.findElement(bySignup).click();
    }

}
