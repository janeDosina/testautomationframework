package com.automation.ui.components;

import com.automation.ui.utils.enums.MenuItem;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface Header {

    By HEADER_CONTAINER = By.xpath("//div[contains(@class,'header-container')]");
    By MENU_ICON = By.xpath(".//div[contains(@class,'userBlock__menu-icon')]");
    By MENU_ICON_OPENED = By.xpath("//div[contains(@class,' userBlock__opened')]");
    String MENU_FORM_ITEM = "./*[contains(text(),'%s')]";

    default boolean isHeaderDisplayed() {
        return $(HEADER_CONTAINER).isDisplayed();
    }

    default void clickMenuIcon() {
        $(HEADER_CONTAINER).$(MENU_ICON).click();
    }

    default boolean isMenuIconOpened() {
        return $(HEADER_CONTAINER).$(MENU_ICON_OPENED).isDisplayed();
    }

    default void clickMenuFormItem(MenuItem menuItem) {
        By menuButton = By.xpath(String.format(MENU_FORM_ITEM, menuItem.getValue()));
        $(MENU_ICON_OPENED).$(menuButton).click();
    }
}