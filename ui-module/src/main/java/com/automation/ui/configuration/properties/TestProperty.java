package com.automation.ui.configuration.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TestProperty {

    @Value("${base.url}")
    private String baseUrl;

    @Value("${valid.userName}")
    private String userName;

    @Value("${valid.password}")
    private String password;
}