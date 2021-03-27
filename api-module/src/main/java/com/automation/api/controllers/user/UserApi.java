package com.automation.api.controllers.user;

import io.restassured.http.Method;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import static io.restassured.http.Method.GET;

@Component
@Log4j2
public class UserApi extends AbstractApi{

    public GetUser getUserApi() {
        return new GetUser();
    }

    public class GetUser extends AbstractOperation {

        public static final String REQ_URI = "/user";

        @Override
        protected Method getMethod() {
            return GET;
        }

        @Override
        protected String getRequestUri() {
            return REQ_URI;
        }
    }
}