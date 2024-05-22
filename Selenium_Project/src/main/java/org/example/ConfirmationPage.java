package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    WebDriver driverr;
    public ConfirmationPage(WebDriver driver){
        driverr = driver;
        PageFactory.initElements(driverr, this);
    }

    @FindBy (xpath = "//b[contains(text(),'Order Placed!')]")
    private WebElement orderPlaced;
    public WebElement getOrderPlaced(){
        return orderPlaced;
    }

    @FindBy (xpath = "//p[contains(text(),'Congratulations! Your order has been confirmed!')]")
    private WebElement confirmationMsg;
    public WebElement getConfirmationMsg(){
        return confirmationMsg;
    }
}
