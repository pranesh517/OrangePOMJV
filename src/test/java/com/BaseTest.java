package com;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.utility.LaunchBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;

public class BaseTest {
    Page page;
    private LaunchBrowser launchBrowser;

    @BeforeEach
    public void beforeEachTest () {
        launchBrowser = new LaunchBrowser();
        page = launchBrowser.LaunchBrowserAndHitUrl(false);
    }

    public void preserveAuthenticationState() {
        launchBrowser.getBrowserContext().storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("state.json")));
    }

    public void loginWithPreserveAuthState() {
        launchBrowser = new LaunchBrowser();
        page = launchBrowser.LaunchBrowserAndHitUrl(true);
    }

    @AfterEach
    public void afterEachTest () {
        launchBrowser.CleanUpAndGarbageCollect();
    }
}
