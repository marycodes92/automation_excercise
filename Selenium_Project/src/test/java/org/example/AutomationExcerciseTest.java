package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationExcerciseTest {
    WebDriver driver = null;
    SignInPage login;
    LandingPage landing;
    CartPage cart;
    PaymentPage payment;
    ConfirmationPage confirm;
    JavascriptExecutor scroll;

    @BeforeTest
    public void login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/maryonuorah/Desktop/automation_excercise/Selenium_Project/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

        driver.get("https://www.automationexercise.com/");
        Thread.sleep(3000);

        login = new SignInPage(driver);
// Login
        login.getSignInBtn().click();
        login.getEmail().sendKeys("qat@mailinator.com");
        login.getPassword().sendKeys("123456");
        login.getLoginBtn().click();
        Thread.sleep(2000);

        scroll = (JavascriptExecutor) driver;
    }
    @Test
    public void getLabelAndPriceTest() {
//  Scroll down to featured list
        scroll.executeScript("window.scrollBy(0, 500)");

        List<WebElement> products = driver.findElements(By.cssSelector(".features_items .col-sm-4"));
        List<Product> productList = new ArrayList<>();

        for(WebElement product: products){
            String priceInText = product.findElement(By.cssSelector("h2")).getText();
            String label = product.findElement(By.cssSelector("p")).getText();
            double price = Double.parseDouble(priceInText.replaceAll("[^0-9.]", "").replaceFirst("\\.([^.]*)$", "$1"));
            productList.add(new Product(label, price));
        }

        productList.sort(Comparator.comparingDouble(Product::getPrice));

        for (Product product : productList) {
            System.out.println("Label: " + product.getLabel() + ", Price: " + product.getPrice());
        }

        driver.close();
    }

    @Test
    public void purchaseProductTest(){
        landing = new LandingPage(driver);
        cart = new CartPage(driver);
        payment = new PaymentPage(driver);
        confirm = new ConfirmationPage(driver);

//        Add first and second product to cart and got to cart page
        scroll.executeScript("window.scrollBy(0, 1000)");
        landing.getProductOne().click();
        landing.getContinueShoppingBtn().click();

        scroll.executeScript("window.scrollBy(1000, 700)");
        landing.getProductTwo().click();
        landing.getViewCart().click();

//        Go to checkout page
        cart.getProceedToCheckoutBtn().click();
        cart.getComment().sendKeys("Order placed.");
        cart.getPlaceOrderBtn().click();

//        Enter payment details and pay
        payment.getNameOnCard().sendKeys("Test Card");
        payment.getCardNumber().sendKeys("4100 0000 0000");
        payment.getCvc().sendKeys("123");
        payment.getExpiryMonth().sendKeys("01");
        payment.getExpiryYear().sendKeys("2027");
        payment.getSubmit().click();

//        Confirm order has been placed
        confirm.getOrderPlaced().isDisplayed();
        confirm.getConfirmationMsg().isDisplayed();
        String message = confirm.getConfirmationMsg().getText();
//        Assert.assertEquals(message, message);
    }

    @AfterClass
    public  void quitBrowser(){
        driver.quit();
    }
}
