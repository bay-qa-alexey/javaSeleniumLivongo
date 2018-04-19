package tests;

import driverSetup.DriverSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CoveragePage;
import pageObjects.HomePage;
import pageObjects.JoinPage;
import pageObjects.SuppliesPage;

public class LivongoTest extends DriverSetup{

    @Test
    public void firstTest() throws InterruptedException {

        HomePage.waitUntilPageLoad(15);
        HomePage.clickJoinNowBtn();

        JoinPage.waitUntilPageLoad(15);
        JoinPage.submitForm("Alex", "Kir", "11", "12", "1988", "kira@gmail.com", "gogoDance0");

        SuppliesPage.waitUntilPageLoad(15);
        SuppliesPage.submitForm("3394 Lemon St", "Riverside", "CA", "92501", "8172049876");

        CoveragePage.waitUntilPageLoad(15);
        CoveragePage.putPromocode("LIV-TEST");

        Assert.assertEquals(driver.getTitle(), "Livongo Health - Registration");

    }

}
