package com.Reporting;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//here i am using Singleton Design Pattern
public class ExtendReportManager {
    public static ExtendReportManager extendReportManager;

    private ExtendReportManager() {
    }

    public static ExtendReportManager getInstance() {
        if (extendReportManager == null) {
            synchronized (ExtendReportManager.class) {
                if (extendReportManager == null) {
                    extendReportManager = new ExtendReportManager();
                }
            }
        }
        return extendReportManager;
    }

    public ExtentReports initializeExtendReport() {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/ExtentReport/ExtentSparkReport.html");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

}
