package com.driver;

import com.exceptions.DriverInitializationException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import static com.constants.FrameworkConstants.*;

public class Drivers {

    public static AppiumDriver<MobileElement> createAndroidDriverForNativeApp(String deviceName, String udid, String emulator) {
        try {
            var capability = new DesiredCapabilities();
            capability.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
            capability.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2); // Specific to Android and for Ios -XCUItest
            capability.setCapability(MobileCapabilityType.UDID, udid); // To uniquely identify device
            capability.setCapability(MobileCapabilityType.NO_RESET, false); // false - delete the data
            // capability.setCapability(MobileCapabilityType.FULL_RESET, false); // true - will uninstall the app
            capability.setCapability(MobileCapabilityType.APP, ANDROID_APK_PATH);
            capability.setCapability("autoGrantPermissions", true); // this will allow the permissions automatically
            if (emulator.equalsIgnoreCase("yes")) {
                capability.setCapability(AndroidMobileCapabilityType.AVD, deviceName);
                capability.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, AVD_LAUNCH_TIMEOUT);
            }
            return new AndroidDriver<>(new URL(APPIUM_URL), capability);
        } catch (Exception e) {
            throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
        }
    }
}
