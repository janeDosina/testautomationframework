package com.automation.ui.pages;

import com.automation.ui.components.Header;
import com.automation.ui.components.SideBar;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class DashboardPage extends BasePage implements Header, SideBar {

    private static final By DASHBOARD_TITLE = By.xpath("//span[@title='All Dashboards']");

    @Override
    protected By getPageIdentifier() {
        return DASHBOARD_TITLE;
    }
}