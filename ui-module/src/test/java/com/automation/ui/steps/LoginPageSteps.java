package com.automation.ui.steps;

import com.automation.ui.pages.LoginPage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.automation.ui.utils.enums.MenuItem.LOGOUT;
import static org.assertj.core.api.Assertions.assertThat;

@Component
public class LoginPageSteps {

    @Autowired
    public LoginPage loginPage;

    @Step("Verify login page opened")
    public LoginPageSteps openPage(String url) {
        loginPage.openPage(url)
                .waitUntilPageOpened();
        return this;
    }

    @Step("Fill login form")
    public LoginPageSteps fillForm(String userName, String password) {
        loginPage.setUserName(userName)
                .setPassword(password);
        return this;
    }

    @Step("Click Login button")
    public LoginPageSteps submitForm() {
        loginPage.clickSubmitBtn();
        return this;
    }

    @Step("Verify that success Login message displayed")
    public LoginPageSteps verifyLoginIsSuccessful() {
        assertThat(loginPage.isLoginSuccessMsgDisplayed()).isTrue();
        return this;
    }

    @Step("Logout")
    public LoginPageSteps logOut() {
        loginPage.clickMenuIcon();
        loginPage.clickMenuFormItem(LOGOUT);
        assertThat(loginPage.isLoginSuccessMsgDisplayed()).isTrue();
        return this;
    }
}