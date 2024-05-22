package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    WebDriver driverr;
    public PaymentPage(WebDriver driver){
        driverr = driver;
        PageFactory.initElements(driverr, this);
    }

    @FindBy(css = "input[data-qa='name-on-card']")
    private WebElement nameOnCard;
    public WebElement getNameOnCard(){
        return nameOnCard;
    }

    @FindBy(css = "input[data-qa='card-number']")
    private WebElement cardNumber;
    public WebElement getCardNumber(){
        return cardNumber;
    }

    @FindBy(css = "input[data-qa='cvc']")
    private WebElement cvc;
    public WebElement getCvc(){
        return cvc;
    }

    @FindBy(css = "input[data-qa='expiry-month']")
    private WebElement expiryMonth;
    public WebElement getExpiryMonth(){
        return expiryMonth;
    }

    @FindBy(css = "input[data-qa='expiry-year']")
    private WebElement expiryYear;
    public WebElement getExpiryYear(){
        return expiryYear;
    }

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submit;
    public WebElement getSubmit(){
        return submit;
    }
}
