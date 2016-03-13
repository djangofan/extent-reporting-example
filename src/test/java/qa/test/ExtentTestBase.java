package qa.test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class ExtentTestBase implements ITest
{
    private String testName;
    private ExtentReports extentReport;
    private ExtentTest extentTest;

    private final String reportLocation = "build" + File.separator + "extent-report" + File.separator + "index.html";
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

    @BeforeClass
    public void setupClass()
    {
        createReportInstance();
    }

    @BeforeMethod
    public void setupBeforeTestMethod(Method method, ITestResult iTestResult)
    {
        setTestName(method.getName());
        String description = method.getAnnotation(Test.class).description();
        extentTest = extentReport.startTest(getTestName());
        extentTest.setDescription(description);
        extentTest.setStartedTime(new Date());
        extentTest.log(LogStatus.INFO, "Starting test " + getTestName() + " ...");
    }

    @AfterMethod
    public void teardownAfterTestmethod(ITestResult iTestResult)
    {
        int testngStatus = iTestResult.getStatus();
        logger.info("TestNG test status after test: " + testngStatus);
        if ( testngStatus == ITestResult.SUCCESS ) {
            extentTest.log(LogStatus.PASS, "Test Passed.");
        } else if ( testngStatus == ITestResult.FAILURE ) {
            extentTest.log(LogStatus.FAIL, "Test Failed.");
        } else if ( testngStatus == ITestResult.SKIP ) {
            extentTest.log(LogStatus.SKIP, "Test Skipped.");
        } else {
            extentTest.log(LogStatus.ERROR, "Test problem.");
        }
        extentTest.setEndedTime(new Date());
        flushTestToReport(extentReport, extentTest);
    }

    public void teardownClass()
    {
        extentReport.close(); // report html wont show up until this is called
    }

    public String getTestName()
    {
        return this.testName;
    }

    public void setTestName(String name)
    {
        this.testName = name;
    }

    private ExtentReports createReportInstance() {
        extentReport = new ExtentReports(reportLocation, false, NetworkMode.OFFLINE);
        extentReport.addSystemInfo("systemOs", "Windows");
        return extentReport;
    }

    private void flushTestToReport(ExtentReports extent, ExtentTest test)
    {
        extent.endTest(test);
        extent.flush();
    }

    private String getDateTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
        String today = formatter.format(date);
        return today;
    }

}
