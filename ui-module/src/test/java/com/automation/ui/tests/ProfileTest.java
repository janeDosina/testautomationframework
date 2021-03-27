package com.automation.ui.tests;

import com.automation.ui.BaseTest;
import com.automation.ui.utils.enums.Language;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.automation.ui.utils.enums.Language.ENGLISH;

@Epic("Report portal regression tests")
@Feature("Profile test")
public class ProfileTest extends BaseTest {

    @BeforeClass
    public void login() {
        loginPageSteps.openPage(property.getBaseUrl())
                .fillForm(property.getUserName(), property.getPassword())
                .submitForm()
                .verifyLoginIsSuccessful();
    }

    @Test(dataProvider = "languages", dataProviderClass = Language.class,
            description = "Check that user can change language in Profile page")
    public void changeProfileLanguage(Language language) {
        profilePageSteps.goToUserProfile()
                .changeLanguage(language)
                .verifyLanguageChanged(language);
    }

    @AfterClass
    public void setLanguageToDefault() {
        profilePageSteps.changeLanguageToDefault()
                .verifyLanguageChanged(ENGLISH);
        loginPageSteps.logOut();
    }
}