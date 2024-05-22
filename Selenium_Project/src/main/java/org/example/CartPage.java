package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driverr;
    public CartPage(WebDriver driver){
        driverr = driver;
        PageFactory.initElements(driverr, this);
    }

    @FindBy (xpath = "//a[contains(text(),'Proceed To Checkout')]")
    private WebElement proceedToCheckoutBtn;
    public WebElement getProceedToCheckoutBtn(){
        return proceedToCheckoutBtn;
    }

    @FindBy (xpath = "//body/section[@id='cart_items']/div[1]/div[6]/textarea[1]")
    private WebElement comment;
    public WebElement getComment(){
        return comment;
    }

    @FindBy (xpath = "//a[contains(text(),'Place Order')]")
    private WebElement placeOrderBtn;
    public WebElement getPlaceOrderBtn(){
        return placeOrderBtn;
    }
}
