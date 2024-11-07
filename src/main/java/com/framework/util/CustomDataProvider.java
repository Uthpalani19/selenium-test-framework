package com.framework.util;


import org.testng.annotations.DataProvider;

public class CustomDataProvider {
    @DataProvider(name = "loginCredentials")
    public Object[][] getData() {
        return new Object[][]{
                {"uthpalanijayasinghe19@gmail.com", "12345", "https://lk.spaceylon.com/account/login"},
        };
    }
    
    @DataProvider(name = "searchQueries")
    public static Object[][] searchQueries() {
        return new Object[][] {
            {"soap"}
        };
    }
    

}


