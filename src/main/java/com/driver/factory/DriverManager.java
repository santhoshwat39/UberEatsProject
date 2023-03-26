package com.driver.factory;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverManager {

    private static final ThreadLocal<AppiumDriver<MobileElement>> threadLocalDriver = new ThreadLocal<>();
    // We use thread local to run testcases parallely on multiple device/platforms
    // use ThreadLocal for thread safety and run the tests in parallel using Maven

    public static AppiumDriver<MobileElement> getDriver() {
        return threadLocalDriver.get();
    }

    public static void setAppiumDriver(AppiumDriver<MobileElement> driver) {
        if (Objects.nonNull(driver))
            threadLocalDriver.set(driver); // to execute parallel in both ios and android
    }

    public static void unload() {
        threadLocalDriver.remove();
    }
}