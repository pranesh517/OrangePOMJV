package com.utility;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;

import java.awt.*;
import java.nio.file.Paths;

public class LaunchBrowser {
    ReadConfigFile readConfigFile = new ReadConfigFile();
    private Playwright playwright;
    private Browser browser;
    private BrowserType browserType;
    private BrowserContext browserContext;
    private Page page;

    public Page LaunchBrowserAndHitUrl(boolean usePreserveState) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();

        playwright = Playwright.create();
        String browserName = readConfigFile.ReadConfigData().getProperty("browserName");
        String urlToHit = readConfigFile.ReadConfigData().getProperty("url");
        if (browserName.equals("chromium")) {
            browserType = playwright.chromium();
            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        } else if (browserName.equals("firefox")) {
            browserType = playwright.firefox();
            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        } else if (browserName.equals("chrome")) {
            browserType = playwright.chromium();
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        } else if (browserName.equals("edge")) {
            browserType = playwright.chromium();
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
        }
        if (usePreserveState == true) {
           browserContext = browser.
                    newContext(new Browser.NewContextOptions().setViewportSize(width, height).setStorageStatePath(Paths.get("state.json")));
        } else {
            browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
        }
        page = browserContext.newPage();
        Assertions.assertTrue(browser.contexts().size() == 1);
        Assertions.assertTrue(browser.isConnected());
        page.navigate(urlToHit);
        return page;
    }

    public void CleanUpAndGarbageCollect() {
        if(browser.isConnected()) {
            browserContext.close();
            browser.close();
            Assertions.assertFalse(browser.isConnected());
            playwright.close();
        }
    }

    public BrowserContext getBrowserContext () {
        return browserContext;
    }
}
