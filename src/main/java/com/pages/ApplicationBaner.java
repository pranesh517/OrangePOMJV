package com.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ApplicationBaner {

    private Page page;
    private Locator avtarBaner;
    private Locator logoutButton;

    public ApplicationBaner(Page page) {
        this.page = page;
        this.avtarBaner = page.locator(".oxd-userdropdown-tab");
        this.logoutButton = page.locator("[href='/web/index.php/auth/logout']");
    }

    public void logOutFromApplication() {
        avtarBaner.click();
        logoutButton.click();
    }
}
