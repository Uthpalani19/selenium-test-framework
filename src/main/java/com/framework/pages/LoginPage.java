package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends BasePage{
    @FindBy(id = "CustomerEmail")
    private WebElement emailField;

    @FindBy(id = "CustomerPassword")
    private WebElement passwordField;

    @FindBy(id = "customize-login-button")
    private WebElement loginButton;

    private static final String PAGE_URL = "https://lk.spaceylon.com/account/login";

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
    navigateTo(PAGE_URL);
    }

    public void loginUser(String username, String password){
        enterText(emailField, username);
        enterText(passwordField, password);
        click(loginButton);
    }



}
