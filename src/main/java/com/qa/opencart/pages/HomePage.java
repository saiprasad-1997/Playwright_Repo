package com.qa.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    private  Page page;

    //1. String locators
    private String search = "//input[@placeholder='Search']";
    private String searchButton = "//i[@class='fa fa-search']";
    private  String searchPageHeader = "//h1[normalize-space()='Search - macbook']";
    private String myAccount = "//span[normalize-space()='My Account']";
    private String login = "//a[normalize-space()='Login']";

    //2. page constructor
    public HomePage(Page page) {
        this.page = page;
    }

    //3. page actions/methods
    public String getHomePageTitle(){
        String title =  page.title();
        System.out.println("page title is : " + title);
        return title;
    }

    public String getHomePageURL(){
        String url =  page.url();
        System.out.println("page url is : " + url);
        return url;
    }

    public String doSearch(String productName) throws InterruptedException {
        page.fill(search, productName);
        page.click(searchButton);
        Thread.sleep(3000);
        String searchHeader =  page.textContent(searchPageHeader);
        System.out.println("search header is : " + searchHeader);
        return  searchHeader;
    }

    public LoginPage navigateToLoginPage(){
        page.click(myAccount);
        page.click(login);
        return new LoginPage(page);
    }

}
