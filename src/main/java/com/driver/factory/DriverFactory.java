package com.driver.factory;

import com.driver.Drivers;
import com.exceptions.DriverInitializationException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

    public static void initializeDriver(String mobilePlatformName, String deviceName, String udid, String emulator) {
        AppiumDriver<MobileElement> driver;
        switch (mobilePlatformName) {
            case "ANDROID":
                driver = Drivers.createAndroidDriverForNativeApp(deviceName, udid, emulator);
                break;
//            case "IOS":
//                driver = Drivers.createIosDriverForNativeApp(deviceName, udid, emulator);
//                break;
            default:
                throw new DriverInitializationException(
                        "Platform name " + mobilePlatformName + " is not found. Please check the platform name");
        }
        DriverManager.setAppiumDriver(driver);
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}