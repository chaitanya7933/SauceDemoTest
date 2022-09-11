package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SeleniumTest {
    Common common = new Common();
    WebDriver driver = common.setup();
    SeleniumPage seleniumPage = new SeleniumPage(driver);

    @Test(priority = 1)
    //Test Description: Validate that an order can be completed
    public void successOrderTest() {
        seleniumPage.verifySuccessScreenAfterCheckout();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
