package com.automation.api.controllers.user;

import io.qameta.allure.Allure;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Method;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.PrintStream;
import java.util.function.Function;

@RequiredArgsConstructor
public abstract class AbstractApi {

    @Autowired
    protected RestAssuredConfig config;

    @Value("${rest.config.accessToken}")
    private String token;

    @Value("${rest.config.baseUrl}")
    private String baseUrl;

    public abstract class AbstractOperation {

        private static final String APPLICATION_JSON = "application/json";
        protected RequestSpecBuilder reqSpec;
        protected ResponseSpecBuilder respSpec;

        public AbstractOperation() {
            this.reqSpec = new RequestSpecBuilder();
            reqSpec.setAccept(APPLICATION_JSON);
            reqSpec.setContentType(APPLICATION_JSON);
            reqSpec.addHeader("Authorization", "Bearer " + token);
            reqSpec.setConfig(config);
            reqSpec.setBaseUri(baseUrl);
            reqSpec.addFilter(new AllureRestAssured());
            reqSpec.addFilter(new RequestLoggingFilter());
            reqSpec.addFilter(new ResponseLoggingFilter());
            this.respSpec = new ResponseSpecBuilder();
        }

        protected abstract Method getMethod();

        protected abstract String getRequestUri();

        @SneakyThrows
        public <T> T execute(Function<Response, T> handler) {
            PrintStream printStream = new PrintStream("RestAssuredErrorStream_"
                    + Allure.getLifecycle().getCurrentTestCase());
            LogConfig logConfig = LogConfig.logConfig().defaultStream(printStream);
            RestAssuredConfig config = RestAssured.config().logConfig(logConfig);
            return handler.apply(RestAssured.given()
                    .config(config)
                    .spec(reqSpec.build())
                    .expect()
                    .spec(respSpec.build())
                    .when()
                    .request(getMethod(), getRequestUri()));
        }
    }
}