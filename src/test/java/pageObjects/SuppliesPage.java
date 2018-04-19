package pageObjects;

import driverSetup.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuppliesPage extends DriverSetup {

    private static By byStreetAddress   = By.id("shipping-street-address");
    private static By byCity            = By.id("shipping-city");
    private static By bySelectState     = By.id("shipping-select-state");
    private static By byZipCode         = By.id("shipping-zip-code");
    private static By byPhone           = By.id("shipping-input-phone");
    private static By bySubmitBtn       = By.xpath("//button[contains(text(),\'Next: Coverage\')]");

    public static void waitUntilPageLoad(int sec) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.elementToBeClickable(byStreetAddress));
        wait.until(ExpectedConditions.elementToBeClickable(byCity));
        wait.until(ExpectedConditions.elementToBeClickable(bySelectState));
        wait.until(ExpectedConditions.elementToBeClickable(byZipCode));
        wait.until(ExpectedConditions.elementToBeClickable(byPhone));
    }

    public static void submitForm(String streetAddress, String city, String state, String zipCode, String phone) throws InterruptedException {

        driver.findElement(byStreetAddress).sendKeys(streetAddress);
        driver.findElement(byCity).sendKeys(city);

        driver.findElement(bySelectState).click();
        driver.findElement(By.xpath("//span[text()=\'" + state + "\']")).click();

        driver.findElement(byZipCode).sendKeys(zipCode);
        driver.findElement(byPhone).sendKeys(phone);

        //WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(not(ExpectedConditions.attributeContains(bySubmitBtn,"class", "disabled")));

        driver.findElement(bySubmitBtn).click();
    }
}
