package com.qa.opencart.base;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory playwrightFactory;
    Page page;
    protected Properties prop;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browserName){
        playwrightFactory = new PlaywrightFactory();
        prop = playwrightFactory.init_prop();
        if(browserName!=null){
            prop.setProperty("browser", browserName);
        }
        page = playwrightFactory.initBrowser(prop);
        homePage = new HomePage(page);
    }
    @AfterTest
    public  void tearDown(){
        page.context().browser().close();
    }
}
