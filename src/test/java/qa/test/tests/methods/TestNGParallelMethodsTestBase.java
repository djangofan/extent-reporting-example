package qa.test.tests.methods;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import qa.test.util.ExtentReportsManager;
import qa.test.util.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Test base for TestNG tests.
 */
public abstract class TestNGParallelMethodsTestBase implements ITest
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

    private String annotatedTestName;
    private String annotatedDescription;
    private String testMethodName;

    private ExtentReports extentReport;
    protected ExtentTest extentTest;

    @BeforeClass
    public void setupBeforeClass()
    {
        extentReport = ExtentReportsManager.getReporter();
    }

    @BeforeMethod
    public void setupBeforeMethod(Method method)
    {
        testMethodName = method.getName();
        annotatedTestName = method.getAnnotation(Test.class).testName();
        annotatedDescription = method.getAnnotation(Test.class).description();
        setTestName("[t" + ExtentTestManager.getThreadId() + ":" + testMethodName + "] " + annotatedTestName);
        setTestDescription(annotatedDescription);
        extentTest = ExtentTestManager.startTest(getTestName(), getTestDescription());
        extentTest.setStartedTime(new Date());
        setTestDescriptionOnReport(getTestDescription());
        extentTest.log(LogStatus.UNKNOWN, "Initialized test class <i>" + this.getClass().getCanonicalName() + "</i>");
        extentTest.log(LogStatus.INFO, "Starting test with name <b>" + getTestName() + "</b>");
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
        logger.info("Closed test thread " + ExtentTestManager.getThreadId());
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

    private void flushTestToReport(ExtentReports extent, ExtentTest test)
    {
        test.setEndedTime(new Date());
        extent.endTest(test);
        extent.flush();

    }

}
