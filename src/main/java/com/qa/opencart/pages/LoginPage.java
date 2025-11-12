package com.qa.opencart.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class LoginPage {

    Page page;

    private  String email = "//input[@id='input-email']";
    private String pwd = "//input[@id='input-password']";
    private String loginBtn = "//input[@value='Login']";
    private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    public LoginPage(Page page){
        this.page = page;
    }

    public String getLoginPageTitle(){
        return page.title();
    }

    public boolean isForgotPedLinkExist(){
        return page.isVisible(forgotPwdLink);
    }

    public boolean doLogin(String appUserName, String appPassword){
        System.out.println("App creds: " + appUserName + ":" + appPassword);
        page.fill(email, appUserName);
        page.fill(pwd, appPassword);
        page.click(loginBtn);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        if(page.isVisible(logoutLink)){
            System.out.println("user is logged in successfully......");
            return true;
        }else {
            return false;
        }
    }

}
