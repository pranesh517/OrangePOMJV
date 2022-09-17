package com.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PimLandingPage {
    private Page page;
    private Locator PIMactiveTab;

    public PimLandingPage(Page page) {
        this.page = page;
        this.PIMactiveTab = page.locator(".oxd-main-menu .active .oxd-text");
    }

    public boolean isPIMTabActive() {
        return PIMactiveTab.textContent().equals("PIM");
    }
}
