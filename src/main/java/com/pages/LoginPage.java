package com.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    private Locator userNameTextField;
    private Locator passwordTextField;
    private Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        this.userNameTextField = page.locator("[name='username']");
        this.passwordTextField = page.locator("[name='password']");
        this.loginButton = page.locator("button[type='submit']");
    }

    public void enterUserName() {
        userNameTextField.fill("Admin");
    }

    public void enterPassword() {
        passwordTextField.fill("admin123");
    }

    public void clickOnLoginButton() {
        loginButton.click(new Locator.ClickOptions().setForce(true));
    }

    public PimLandingPage loginToOrangeHRMApplication() {
        enterUserName();
        enterPassword();
        clickOnLoginButton();
        return new PimLandingPage(page);
    }
}
