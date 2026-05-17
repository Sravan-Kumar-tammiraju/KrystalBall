package KrystalBall.app.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getReportInstance() {

        if (extentReports == null) {

            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

            String reportPath = System.getProperty("user.dir")
                    + "/build/reports/extent-report/ExtentReport_"
                    + timestamp
                    + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            sparkReporter.config().setDocumentTitle("KrystalBall Automation Report");
            sparkReporter.config().setReportName("KrystalBall Regression Test Report");

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo("Project", "KrystalBall / SmartPad Customer Feedback");
            extentReports.setSystemInfo("Tester", "Tammiraju Sravan Kumar");
            extentReports.setSystemInfo("Automation Tool", "Selenium WebDriver");
            extentReports.setSystemInfo("Language", "Java");
            extentReports.setSystemInfo("Framework", "TestNG");
            extentReports.setSystemInfo("Build Tool", "Gradle");
            extentReports.setSystemInfo("Browser", "Chrome");
        }

        return extentReports;
    }
}