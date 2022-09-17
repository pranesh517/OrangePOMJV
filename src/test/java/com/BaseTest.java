package com;

import com.microsoft.playwright.Page;
import com.utility.LaunchBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    Page page;
    private LaunchBrowser launchBrowser;

    @BeforeEach
    public void beforeEachTest () {
        launchBrowser = new LaunchBrowser();
        page = launchBrowser.LaunchBrowserAndHitUrl();
    }

    @AfterEach
    public void afterEachTest () {
        launchBrowser.CleanUpAndGarbageCollect();
    }
}
