package com;

import com.pages.LoginPage;
import com.pages.PimLandingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    public void TC001() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginToOrangeHRMApplication();
        PimLandingPage pimLandingPage = new PimLandingPage(page);
        Assertions.assertTrue(pimLandingPage.isPIMTabActive());
    }
}
