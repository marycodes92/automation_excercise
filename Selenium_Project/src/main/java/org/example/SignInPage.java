package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy (xpath = "//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
    private WebElement signInBtn;
    public WebElement getSignInBtn(){
        return signInBtn;
    }

    @FindBy (css = "input[data-qa=login-email]")
    private WebElement email;
    public WebElement getEmail(){
        return email;
    }

    @FindBy (css = "input[data-qa=login-password]")
    private WebElement password;
    public WebElement getPassword(){
        return password;
    }

    @FindBy (xpath = "//button[contains(text(),'Login')]")
    private WebElement loginBtn;
    public WebElement getLoginBtn(){
        return loginBtn;
    }
}
