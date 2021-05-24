package com.automation.api.configuration;

import io.restassured.config.RestAssuredConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.automation.api", "io.qameta.allure"})
public class TestConfig {

    @Bean
    public RestAssuredConfig getRestAssuredConfig() {
        return RestAssuredConfig.config();
    }
}