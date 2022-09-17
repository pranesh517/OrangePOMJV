package com.utility;

import com.microsoft.playwright.*;

public class LaunchBrowser {
    ReadConfigFile readConfigFile = new ReadConfigFile();
    private Playwright playwright;
    private Browser browser;
    private BrowserType browserType;
    private BrowserContext browserContext;

    public Page LaunchBrowserAndHitUrl() {
        playwright = Playwright.create();
        String browserName = readConfigFile.ReadConfigData().getProperty("browserName");
        String urlToHit = readConfigFile.ReadConfigData().getProperty("url");
        if (browserName.equals("chromium")) {
            browserType = playwright.chromium();
            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        } else if (browserName.equals("firefox")) {
            browserType = playwright.firefox();
            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        }
        browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.navigate(urlToHit);
        return page;
    }

    public void CleanUpAndGarbageCollect() {
        if(browser.isConnected()) {
            browserContext.close();
            browser.close();
            playwright.close();
        }
    }
}
