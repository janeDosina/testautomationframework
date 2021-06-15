package com.automation.ui.tests;

import com.automation.ui.BaseTest;
import com.automation.ui.listeners.TestListener;
import com.automation.ui.utils.enums.SideBarButtons;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
@Epic("Report portal regression tests")
@Feature("SideBar test")
public class SideBarTest extends BaseTest {

    @BeforeClass
    public void login() {
        loginPageSteps.openPage(property.getBaseUrl())
                .fillForm(property.getUserName(), property.getPassword())
                .submitForm()
                .verifyLoginIsSuccessful();
    }

    @Test(dataProvider = "sideBarButtons", dataProviderClass = SideBarButtons.class,
            description = "Check that side bar buttons are displayed.")
    public void checkSideBarButtonsPresent(String sideBarBtnName) {
        dashboardPageSteps.verifySideBarButtonDisplayed(sideBarBtnName);
    }

    @AfterClass
    public void logout() {
        loginPageSteps.logOut();
    }
}