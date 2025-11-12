package com.qa.opencart.base;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import org.testng.annotations.*;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory playwrightFactory;
    Page page;
    protected Properties prop;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome")String browserName){
        playwrightFactory = new PlaywrightFactory();
        prop = playwrightFactory.init_prop();
        if(browserName!=null){
            prop.setProperty("browser", browserName);
        }
        page = playwrightFactory.initBrowser(prop);
        homePage = new HomePage(page);
    }
    @AfterClass
    public  void tearDown(){
        page.context().browser().close();
    }
}
