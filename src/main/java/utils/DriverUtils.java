package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {

    private static AppiumDriver driver;

    public static void initializeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", System.getProperty("user.dir") + "/src/apps/android/v8.7.1_release.apk");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "R5CW9276LLW");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("uiautomator2ServerInstallTimeout", 40000);
        capabilities.setCapability("autoGrantPermissions", "true");

        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        }
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Please call initializeDriver first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
