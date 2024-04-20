package utils;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class GlobalTestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.createMethod(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            ExtentTestManager.getTest(result).pass("pass",
                    MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(result, "pass")).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentTestManager.getTest(result).fail("fail",
                    MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(result, "fail")).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest(result).skip("skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.TEST);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentService.getInstance().flush();
    }
    public String captureScreenShot(ITestResult result, String status) {
        String destDir = "";
        String passfailMethod = result
                .getMethod()
                .getRealClass()
                .getSimpleName() + "." + result.getMethod().getMethodName();
        File scrFile = ((TakesScreenshot) DriverUtils.getDriver()).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        if (status.equalsIgnoreCase("fail")) {
            destDir = "test-outputs/screenshots/Failures";
        }
        else if (status.equalsIgnoreCase("pass")) {
            destDir = "test-outputs/screenshots/Success";
        }
        new File(destDir).mkdirs();
        String destFile = passfailMethod + " - " + dateFormat.format(new Date()) + ".png";
        File finalFile = new File(destDir + "/" + destFile);
        try {
            FileHandler.copy(scrFile, finalFile);
        }catch (IOException e){
            e.printStackTrace();
        }
        return finalFile.getAbsolutePath();
    }
}
