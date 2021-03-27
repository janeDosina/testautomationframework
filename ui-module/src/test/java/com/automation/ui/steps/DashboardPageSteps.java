package com.automation.ui.steps;

import com.automation.ui.pages.DashboardPage;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DashboardPageSteps {

    @Autowired
    public DashboardPage dashboardPage;

    @Step("Verify that side bar button is displayed")
    public DashboardPageSteps verifySideBarButtonDisplayed(String buttonName) {
        dashboardPage.waitUntilPageOpened();
        Assertions.assertThat(dashboardPage.isSideBarButtonDisplayed(buttonName)).isTrue();
        return this;
    }
}