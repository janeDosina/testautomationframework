package com.automation.ui.components;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.automation.ui.configuration.constants.GlobalConstants.TIMEOUT_5000;
import static com.codeborne.selenide.Selenide.$;

public interface LoginMessage {

    By LOGIN_MESSAGE = By.xpath("//div[contains(@class,'notificationItem__message-container')]");

    default boolean isLoginSuccessMsgDisplayed() {
        return $(LOGIN_MESSAGE).waitUntil(Condition.visible, TIMEOUT_5000).isDisplayed();
    }
}