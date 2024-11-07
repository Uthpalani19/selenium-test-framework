package com.framework.tests;

import com.framework.pages.ProductPage;
import com.framework.util.CustomDataProvider;
import java.time.Duration;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchAndFilterTest extends BaseTest {

    private ProductPage searchPage;

    @Test(dataProvider = "searchQueries", dataProviderClass = CustomDataProvider.class)
    public void testSearchFunctionality(String query) {
        Reporter.log("*** Testing search functionality ***", true);
        searchPage = new ProductPage(driver);
        searchPage.openPage();
        searchPage.searchProduct(query);

        searchPage.filterProduct();
        searchPage.filterOptions();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        Assert.assertTrue(searchPage.isFilterSuccessful().contains("Baby Soap 100g"), "Filter is not successful.");
        Reporter.log("*** Search functionality works properly. ***", true);
    }
}
