package com;

import com.pages.ApplicationBaner;
import com.pages.LoginPage;
import com.pages.PimLandingPage;
import com.utility.LaunchBrowser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SamplePageTest extends BaseTest{

    @Test
    public void TC002() {
        LoginPage loginPage = new LoginPage(page);
        PimLandingPage pimLandingPage = loginPage.loginToOrangeHRMApplication();
        Assertions.assertTrue(pimLandingPage.isPIMTabActive());
        preserveAuthenticationState();

        loginWithPreserveAuthState();
        pimLandingPage = new PimLandingPage(page);
        Assertions.assertTrue(pimLandingPage.isPIMTabActive());

        ApplicationBaner applicationBaner = new ApplicationBaner(page);
        applicationBaner.logOutFromApplication();
    }
}
