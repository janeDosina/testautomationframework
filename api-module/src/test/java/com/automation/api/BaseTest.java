package com.automation.api;

import com.automation.api.controllers.user.UserApi;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class BaseTest {

    @Autowired
    public UserApi userApi;
}