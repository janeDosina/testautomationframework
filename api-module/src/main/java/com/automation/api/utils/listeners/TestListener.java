package com.automation.api.utils.listeners;

import io.qameta.allure.Attachment;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;
import lombok.extern.log4j.Log4j2;

import java.io.ByteArrayOutputStream;

@Log4j2
public class TestListener implements TestLifecycleListener {

    private final ByteArrayOutputStream request = new ByteArrayOutputStream();
    private final ByteArrayOutputStream response = new ByteArrayOutputStream();

    @Override
    public void afterTestStart(TestResult result) {
        log.info("Test started");
    }

    @Override
    public void afterTestWrite(TestResult result) {
        log.info("Show test request and response");
        logRequest(request);
        logResponse(response);
    }

    @Override
    public void beforeTestStop(TestResult result) {
        log.info("Test finished");
    }

    @Attachment(value = "request", type = "text/plain")
    public byte[] logRequest(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    @Attachment(value = "response", type = "text/plain")
    public byte[] logResponse(ByteArrayOutputStream stream) {
        return attach(stream);
    }

    public byte[] attach(ByteArrayOutputStream log) {
        byte[] array = log.toByteArray();
        log.reset();
        return array;
    }
}