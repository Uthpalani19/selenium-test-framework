package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(xpath = "(//button[@id='quick-add-template--20899506454827__d544bf17-77e0-4503-bf0e-5a51bb67f6fe8640830865707-submit'])[1]")
    private WebElement addToCartBtn;
    
    @FindBy(xpath = "(//button[normalize-space()='Check out'])[1]")
    private WebElement checkOutBtn;
    
    @FindBy(xpath = "(//strong[@class='_19gi7yt0 _19gi7yt10 _19gi7ytz _1fragemnw _19gi7yt2 notranslate'])[1]")
    private WebElement total;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        navigateTo("https://lk.spaceylon.com");
    }

    public void clickAddToCartBtn() {
        click(addToCartBtn);
    }
    
    public void clickCheckOutBtn(){
        click(checkOutBtn);
    }
    
    public String isTotalVisible()
    {
        return getText(total);
    }
}
