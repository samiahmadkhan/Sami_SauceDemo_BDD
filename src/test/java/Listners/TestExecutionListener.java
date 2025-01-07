package Listners;

import com.Reporting.ExtendReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.*;

public class TestExecutionListener implements ITestListener, ISuiteListener {
    ExtendReportManager extendReportManager;
    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onStart(ISuite suite) {
        extendReportManager = ExtendReportManager.getInstance();
        extentReports = extendReportManager.initializeExtendReport();

    }

    @Override
    public void onFinish(ISuite suite) {
        extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest=extentReports.createTest("Test Case Name: "+result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.pass("Test Case Passed "+result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.fail("Test Case Failed "+result.getTestName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}