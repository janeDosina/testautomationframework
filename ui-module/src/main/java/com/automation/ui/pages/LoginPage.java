package com.automation.ui.pages;

import com.automation.ui.components.Header;
import com.automation.ui.components.LoginMessage;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Component
public class LoginPage extends BasePage implements LoginMessage, Header {

    private static final By LOGIN_FORM = By.className("loginPage__background--yCqFw");
    private static final By LOGIN_FIELD = By.xpath("//input[@placeholder='Login']");
    private static final By PASSWORD_FIELD = By.xpath("//input[@type='password']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[@type='submit']");
    private static final By FIELD_ERROR_HINT = By.xpath("//div[contains(@class,'fieldErrorHint__visible')]");

    public LoginPage openPage(String url) {
        open(url);
        return this;
    }

    public LoginPage setUserName(String userName) {
        $(LOGIN_FIELD).setValue(userName);
        if ($(FIELD_ERROR_HINT).isDisplayed()) {
            $(LOGIN_FORM).click();
        }
        return this;
    }

    public LoginPage setPassword(String password) {
        $(PASSWORD_FIELD).setValue(password);
        return this;
    }

    public LoginPage clickSubmitBtn() {
        $(SUBMIT_BUTTON).click();
        return this;
    }

    @Override
    protected By getPageIdentifier() {
        return LOGIN_FORM;
    }
}