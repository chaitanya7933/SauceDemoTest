package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class SeleniumPage {
    WebDriver driver;

    public SeleniumPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement passWord;

    @FindBy(id = "login-button")
    public WebElement loginBtn;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartBtn;

    @FindBy(id = "shopping_cart_container")
    public WebElement shopingCartBtn;

    @FindBy(id = "checkout")
    public WebElement checkoutBtn;

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement postalCode;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(id = "finish")
    public WebElement finishBtn;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    public WebElement successMsg;

    public void verifySuccessScreenAfterCheckout() {
        driver.get("https://www.saucedemo.com/"); //Enter Test URL
        userName.sendKeys("standard_user"); //Enter User ID
        passWord.sendKeys("secret_sauce"); // Enter Password
        loginBtn.click(); // Click login button
        addToCartBtn.click(); //Click Add to Cart button for the item
        shopingCartBtn.click();// Click shopping cart to open the cart
        checkoutBtn.click(); //Click checkout button on the cart page
        firstName.sendKeys("Test"); //Enter first name
        lastName.sendKeys("Tester"); //Enter last name
        postalCode.sendKeys("12345"); //Enter zip code
        continueBtn.click(); //Click Continue button
        finishBtn.click(); // Click Finish button
        Assert.assertEquals(successMsg.getText(), "THANK YOU FOR YOUR ORDER"); //Validate Thank you message
       
    }
}
