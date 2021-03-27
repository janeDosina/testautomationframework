package com.automation.ui.configuration.springConfig;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.automation.ui", "com.codeborne.selenide", "io.qameta.allure"})
@PropertySource("classpath:app.properties")
public class TestConfig {

    @Bean
    public WebDriver getDriver() {
        return WebDriverRunner.getAndCheckWebDriver();
    }
}