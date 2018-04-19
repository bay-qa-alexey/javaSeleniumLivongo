package pageObjects;

import driverSetup.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JoinPage extends DriverSetup {

    private static By byFirstName   = By.id("get-started-input-firstname");
    private static By byLastName    = By.id("get-started-input-lastname");
    private static By byMonth       = By.id("get-started-input-month");
    private static By byDay         = By.id("get-started-input-day");
    private static By byYear        = By.id("get-started-input-year");
    private static By byEmail       = By.id("get-started-input-email");
    private static By byPsswd       = By.id("get-started-input-password");
    private static By byCheckBox    = By.id("get-started-terms-and-conditions");
    private static By bySubmitBtn   = By.cssSelector("div.step-button");

    public static void waitUntilPageLoad(int sec) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.elementToBeClickable(byFirstName));
        wait.until(ExpectedConditions.elementToBeClickable(byLastName));
        wait.until(ExpectedConditions.elementToBeClickable(byMonth));
        wait.until(ExpectedConditions.elementToBeClickable(byDay));
        wait.until(ExpectedConditions.elementToBeClickable(byYear));
        wait.until(ExpectedConditions.elementToBeClickable(byEmail));
        wait.until(ExpectedConditions.elementToBeClickable(byPsswd));
    }

    public static void submitForm(String firstName, String lastName, String month, String day, String year, String email, String psswd) throws InterruptedException {

        driver.findElement(byFirstName).sendKeys(firstName);
        driver.findElement(byLastName).sendKeys(lastName);
        driver.findElement(byMonth).sendKeys(month);
        driver.findElement(byDay).sendKeys(day);
        driver.findElement(byYear).sendKeys(year);
        driver.findElement(byEmail).sendKeys(email);
        driver.findElement(byPsswd).sendKeys(psswd);
        driver.findElement(byCheckBox).click();

        //WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(not(ExpectedConditions.attributeContains(bySubmitBtn,"class", "disabled")));

        driver.findElement(bySubmitBtn).click();
    }

}
