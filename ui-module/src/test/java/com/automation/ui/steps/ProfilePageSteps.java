package com.automation.ui.steps;

import com.automation.ui.pages.ProfilePage;
import com.automation.ui.utils.enums.Language;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.automation.ui.utils.enums.MenuItem.PROFILE;

@Component
public class ProfilePageSteps {

    @Autowired
    public ProfilePage profilePage;

    @Step("Go to user profile page")
    public ProfilePageSteps goToUserProfile() {
        profilePage.clickMenuIcon();
        profilePage.clickMenuFormItem(PROFILE);
        profilePage.waitUntilPageOpened();
        return this;
    }

    @Step("Change language to {language}")
    public ProfilePageSteps changeLanguage(Language language) {
        profilePage.changeLanguage(language.getType());
        return this;
    }

    @Step("Change language to default")
    public ProfilePageSteps changeLanguageToDefault() {
        profilePage.changeToDefaultLanguage();
        return this;
    }

    @Step("Verify that language is changed")
    public ProfilePageSteps verifyLanguageChanged(Language language) {
        Assertions.assertThat(profilePage.isLanguageChanged(language.getValue())).isTrue();
        return this;
    }
}