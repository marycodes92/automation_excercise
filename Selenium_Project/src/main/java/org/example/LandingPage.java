package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    @FindBy (xpath = "//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[9]/div[1]/div[1]/div[1]/a[1]")
    private WebElement productOne;
    public WebElement getProductOne(){
        return productOne;
    }

    @FindBy (xpath = "//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/div[1]/div[1]/a[1]")
    private WebElement productTwo;
    public WebElement getProductTwo(){
        return productTwo;
    }

    @FindBy (xpath = "//button[contains(text(),'Continue Shopping')]")
    private WebElement continueShoppingBtn;
    public WebElement getContinueShoppingBtn(){
        return continueShoppingBtn;
    }

    @FindBy (xpath = "//u[contains(text(),'View Cart')]")
    private WebElement viewCart;
    public WebElement getViewCart(){
        return viewCart;
    }
}
