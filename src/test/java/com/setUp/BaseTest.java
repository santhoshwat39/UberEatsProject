package com.setUp;

import com.driver.factory.DriverFactory;
import com.pages.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static com.driver.factory.DriverManager.getDriver;

public class BaseTest {
    protected WelcomePage welcomePage;
    protected SignInPage signInPage;
    protected AuthenticationPage authenticationPage;
    protected PasswordPage passwordPage;
    protected HomePage homePage;
    protected  RestaurantPage restaurantPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected AddTipPage addTipPage ;


    @Parameters({"platformName", "udid", "deviceName", "emulator"})
    @BeforeMethod
    protected void setUp(String platformName, String udid, String deviceName, String emulator) {
        DriverFactory.initializeDriver(platformName.toUpperCase(), deviceName, udid, emulator);
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {
        if(!result.isSuccess()){
            takeScreenshot();
        }

        DriverFactory.quitDriver();
    }

    public void takeScreenshot() {
        String filename = UUID.randomUUID().toString();
        File file  = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(filename + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
