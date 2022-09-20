package com.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PimLandingPage {
    private Page page;
    private Locator PIMactiveTab;
    private Locator employmentStatusDropDown;

    public PimLandingPage(Page page) {
        this.page = page;
        this.PIMactiveTab = page.locator(".oxd-main-menu .active .oxd-text");
        this.employmentStatusDropDown = page.locator(".oxd-select-text");
    }

    public boolean isPIMTabActive() {
        return PIMactiveTab.textContent().equals("PIM");
    }

    public void clickOnEmploymentStatusDropDown() {
        employmentStatusDropDown.click();
    }
}
