package com.automation.ui;

import com.automation.ui.configuration.properties.TestProperty;
import com.automation.ui.configuration.springConfig.TestConfig;
import com.automation.ui.steps.DashboardPageSteps;
import com.automation.ui.steps.LoginPageSteps;
import com.automation.ui.steps.ProfilePageSteps;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

@ContextConfiguration(classes = {TestConfig.class})
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    public WebDriver driver;

    @Autowired
    protected TestProperty property;

    @Autowired
    public LoginPageSteps loginPageSteps;

    @Autowired
    public DashboardPageSteps dashboardPageSteps;

    @Autowired
    public ProfilePageSteps profilePageSteps;

    @BeforeTest
    public void listenerSetUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(true));
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        this.springTestContextPrepareTestInstance();
        testContext.setAttribute("WebDriver", this.driver);
        driver.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}