package com.automation.ui.listeners;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test finished successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test failed, screenshot is saved");
        screenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("Test is skipped, screenshot is saved");
        screenshot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("Test failed but within success percentage");
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("Test started");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("Test finished");
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    @SneakyThrows
    public static byte[] screenshot() {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }
}