package com.automation.api.tests;

import com.automation.api.BaseTest;
import com.automation.api.models.enums.AccountType;
import com.automation.api.models.enums.UserRole;
import com.automation.api.models.user.UserDTO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.ResponseBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("QA Automation task")
@Feature("Login api test")
public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Get user information from profile")
    public void test() {
        UserDTO response = userApi.getUserApi()
                .execute(ResponseBody::prettyPeek)
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .as(UserDTO.class);
        assertThat(response.getAccountType()).isEqualTo(AccountType.INTERNAL);
        assertThat(response.getUserRole()).isEqualTo(UserRole.ADMINISTRATOR);
    }
}