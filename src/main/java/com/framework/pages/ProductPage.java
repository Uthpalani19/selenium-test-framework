package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(id = "Search-In-Template")
    private WebElement searchInput;

    @FindBy(xpath = "//form[@class='search']//button[@aria-label='Search']//*[name()='svg']")
    private WebElement searchButton;

    @FindBy(css = "ul.grid.product-grid li.grid__item")
    private List<WebElement> productResults;
    
    @FindBy(xpath = "//summary[@aria-label='Availability (0 selected)']//div//*[name()='svg']")
    private WebElement Filter;
    
    @FindBy(xpath = "//label[@for='Filter-filter.v.availability-1']//*[name()='svg']")
    private WebElement filterOptions;
    
    @FindBy(xpath = "(//a[@id='CardLink--8640838107435'])[1]")
    private WebElement filteredResults;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        navigateTo("https://lk.spaceylon.com/search");
    }

    public void searchProduct(String query) {
        enterText(searchInput, query);
        click(searchButton);
    }
    
    public void filterProduct()
    {
        click(Filter);
    }

    public void filterOptions()
    {
        click(filterOptions);
    }
    
    public boolean isProductDisplayed() {
        return !productResults.isEmpty();
    }
    
    public String isFilterSuccessful()
    {
        return getText(filteredResults);
    }
}
