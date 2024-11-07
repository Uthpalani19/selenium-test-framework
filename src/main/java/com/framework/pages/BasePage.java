package com.framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    protected WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    public WebElement getDynamicElement(String dynamicXPath) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXPath)));
        } catch (TimeoutException e) {
            System.out.println("Element not found within the given time (Timeout): " + dynamicXPath);
            return null;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + dynamicXPath);
            return null;
        }
    }

    // Wait for an element to be visible
    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Common click method
    protected void click(WebElement element) {
        waitForElementToBeVisible(element);
        element.click();
    }

    // Common sendKeys method
    protected void enterText(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    // Common getText method
    protected String getText(WebElement element) {
        waitForElementToBeVisible(element);
        return element.getText();
    }
}
