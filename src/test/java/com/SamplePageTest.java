package com;

import com.pages.LoginPage;
import com.pages.PimLandingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SamplePageTest extends BaseTest{

    @Test
    public void TC002() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginToOrangeHRMApplication();
        PimLandingPage pimLandingPage = new PimLandingPage(page);
        Assertions.assertTrue(pimLandingPage.isPIMTabActive());
    }
}
