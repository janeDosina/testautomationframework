package com.automation.ui.pages;

import com.automation.ui.components.Header;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Component
public class ProfilePage extends BasePage implements Header {

    private static final By PROFILE_TITLE = By.xpath("//*[@title='User profile']");
    private static final By DROPDOWN_BTN = By.xpath("//*[contains(@class,'inputDropdown__dropdown-container')]");
    private static final By DROPDOWN_LIST = By.xpath("//*[contains(@class,'inputDropdown__select-list')]");
    private static final By DROPDOWN_OPTION = By.xpath("//*[contains(@class,'single-option')]");
    private static final By PROJECT_ROLE_HEADER = By.xpath("//*[contains(@class,'blockContainer__block-header')]/div[contains(@class,'assignedProjectsBlock__role')]");

    public void changeLanguage(String language) {
        clickOnDropDownLanguage();
        SelenideElement langElement = $$(DROPDOWN_OPTION).stream()
                .filter(elem -> language.equals(elem.getText()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(language + " is not found"));
        langElement.click();
    }

    public void clickOnDropDownLanguage() {
        $(DROPDOWN_BTN).click();
        if (!$(DROPDOWN_LIST).isDisplayed()) {
            throw new NoSuchElementException(DROPDOWN_LIST + " is not found");
        }
    }

    public void changeToDefaultLanguage() {
        clickOnDropDownLanguage();
        SelenideElement langElement = $$(DROPDOWN_OPTION).stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Default language is not found"));
        langElement.click();
    }

    public boolean isLanguageChanged(String fieldName) {
        return fieldName.toUpperCase().equals($(PROJECT_ROLE_HEADER).getText());
    }

    @Override
    public By getPageIdentifier() {
        return PROFILE_TITLE;
    }
}