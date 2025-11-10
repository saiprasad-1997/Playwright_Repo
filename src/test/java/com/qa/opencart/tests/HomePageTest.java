package com.qa.opencart.tests;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void homePageTitleTest(){
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void homePageUrlTest(){
        String actualUrl = homePage.getHomePageURL();
        Assert.assertEquals(actualUrl, prop.getProperty("url"));
    }
// data provider is used to search multiple items at a time
//    @DataProvider
//    public Object[][] getProductData(){
//        return new Object[][]{
//                {"macbook"}
//        };
//    }

    @Test(priority = 3)
    public void homePageSearchTest() throws InterruptedException {
        String actualSearchHeader = homePage.doSearch("macbook");
        Assert.assertEquals(actualSearchHeader, "Search - macbook");
    }

}
