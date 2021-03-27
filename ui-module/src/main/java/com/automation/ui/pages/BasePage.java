package com.automation.ui.pages;

import com.automation.ui.configuration.springConfig.TestConfig;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.springframework.test.context.ContextConfiguration;

import java.util.NoSuchElementException;

import static com.automation.ui.configuration.constants.GlobalConstants.TIMEOUT_5000;
import static com.codeborne.selenide.Selenide.$;

@ContextConfiguration(classes = {TestConfig.class})
public abstract class BasePage {

    public void waitUntilPageOpened() {
        if (!$(getPageIdentifier()).waitUntil(Condition.visible, TIMEOUT_5000).isDisplayed()) {
            throw new NoSuchElementException(getPageIdentifier() + " is not found");
        }
    }

    protected abstract By getPageIdentifier();
}