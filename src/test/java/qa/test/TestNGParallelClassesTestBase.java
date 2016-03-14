package qa.test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Test base for TestNG tests.
 */
public abstract class TestNGParallelClassesTestBase implements ITest
{
    private String annotatedTestName;
    private String annotatedDescription;
    private String testMethodName;
    private ExtentReports extentReport;
    private final String reportLocation = "build" + File.separator + "extent-report" + File.separator + "index.html";
    private long threadId;

    public ExtentTest extentTest;
    public final Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

    @BeforeClass
    public void setupBeforeClass()
    {
        createReportInstance();
    }

    @BeforeMethod
    public void setupBeforeMethod(Method method)
    {
        threadId = Thread.currentThread().getId();
        testMethodName = method.getName();
        annotatedTestName = method.getAnnotation(Test.class).testName();
        annotatedDescription = method.getAnnotation(Test.class).description();
        setTestName("[t" + threadId + ":" + testMethodName + "] " + annotatedTestName);
        setTestDescription(annotatedDescription);
        startTestReport();
        setTestDescriptionOnReport(annotatedDescription);
        extentTest.log(LogStatus.UNKNOWN, "Initialized test class <i>" + this.getClass().getCanonicalName() + "</i>");
        extentTest.log(LogStatus.INFO, "Starting test with name <b>" + getTestName() + "</b>");
    }

    public void startTestReport()
    {
        extentTest = extentReport.startTest(getTestName());
        extentTest.setStartedTime(new Date());
    }

    public void setTestDescriptionOnReport(String desc)
    {
        extentTest.setDescription(desc);
    }

    public void setTestDescription(String desc)
    {
        this.annotatedDescription = desc;
    }

    @AfterMethod
    public void teardownAfterMethod(ITestResult iTestResult)
    {
        int testngStatus = iTestResult.getStatus();
        if ( testngStatus == ITestResult.SUCCESS ) {
            extentTest.log(LogStatus.PASS, "Test Passed.");
        } else if ( testngStatus == ITestResult.FAILURE ) {
            extentTest.log(LogStatus.FAIL, "Test Failed.");
        } else if ( testngStatus == ITestResult.SKIP ) {
            extentTest.log(LogStatus.SKIP, "Test Skipped.");
        } else {
            extentTest.log(LogStatus.ERROR, "Test problem.");
        }
        flushTestToReport(extentReport, extentTest);
    }

    @AfterClass
    public void teardownAfterClass()
    {
        extentReport.close(); // report html wont show up until this is called
        logger.info("Closed test thread " + threadId);
    }

    public String getTestName()
    {
        return this.annotatedTestName;
    }

    public String getTestDescription()
    {
        return this.annotatedDescription;
    }

    public void setTestName(String name)
    {
        this.annotatedTestName = name;
    }

    private ExtentReports createReportInstance() {
        extentReport = new ExtentReports(reportLocation, false, NetworkMode.OFFLINE);
        extentReport.addSystemInfo("Report Creation Date", getDateTime());
        return extentReport;
    }

    private void flushTestToReport(ExtentReports extent, ExtentTest test)
    {
        test.setEndedTime(new Date());
        extent.endTest(test);
        extent.flush();

    }

    private String getDateTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String today = formatter.format(date);
        return today;
    }

}
