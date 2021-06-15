package com.automation.ui.tests;

import com.automation.ui.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Epic("Report portal regression tests")
@Feature("Login test")
public class LoginPageTest extends BaseTest {

    @Test(description = "Login with valid userName and password")
    public void login() {
        loginPageSteps.openPage(property.getBaseUrl())
                .fillForm(property.getUserName(), property.getPassword())
                .submitForm()
                .verifyLoginIsSuccessful();
    }

    @AfterMethod
    public void logout() {
        loginPageSteps.logOut();
    }
}