package com.automation.ui.components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface SideBar {
    String SIDE_BAR_BUTTON = "//a[contains(@href,'%s') and contains(@class,'sidebarButton__nav-link')]";

    default boolean isSideBarButtonDisplayed(String buttonName) {
        By sideBarBtn = By.xpath(String.format(SIDE_BAR_BUTTON, buttonName.toLowerCase()));
        return $(sideBarBtn).isDisplayed();
    }
}