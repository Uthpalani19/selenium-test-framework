package com.framework.tests;

import com.framework.pages.CartPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    private CartPage cartPage;

    @Test
    public void testAddCartFunctionality() {
        Reporter.log("*** Adding an item to the cart functionality ***", true);
        cartPage = new CartPage(driver);
        cartPage.openPage();
        cartPage.clickAddToCartBtn();
        cartPage.clickCheckOutBtn();
        
        Assert.assertTrue(cartPage.isTotalVisible().contains("Rs 3,900.00"), "Checkout is not successful.");
        Reporter.log("*** Cart functionality works successfully. ***", true);
    }
}
