package pageObjects;

import driverSetup.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoveragePage extends DriverSetup {

    private static By byPromocode   = By.id("coverage-input-promocode");
    private static By byDropDown    = By.xpath("//div[@id=\'signup-dropdown-wrapper\']/ul/li[1]");

    public static void waitUntilPageLoad(int sec) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.elementToBeClickable(byPromocode));
    }

    public static void putPromocode(String promocode) {
        driver.findElement(byPromocode).sendKeys(promocode);
        driver.findElement(byDropDown).click();
    }

}
