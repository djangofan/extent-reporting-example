package qa.test.tests;

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

public class TestNGParallelTestBase implements ITest
{
    protected String canonicalClassName = this.getClass().getCanonicalName();
    protected final Logger logger = LoggerFactory.getLogger(canonicalClassName);
    protected String className = this.getClass().getSimpleName();
    protected ExtentTest extentTest;
    private String annotatedTestName;
    private String annotatedDescription;

    @AfterSuite
    public void teardownAfterClass()
    {
        ExtentReportsManager.closeReporter();
    }

    public String getTestName()
    {
        return this.annotatedTestName;
    }

    public void setTestName(String name)
    {
        this.annotatedTestName = name;
    }

    public void setTestDescription(String desc)
    {
        this.annotatedDescription = desc;
    }

    public String getTestDescription()
    {
        return this.annotatedDescription;
    }

    public String getNameOfTestNGTest(Method method)
    {
        return method.getAnnotation(Test.class).testName();
    }

    public void logTestResult(ExtentTest extentTest, ITestResult testResult)
    {
        int testngStatus = testResult.getStatus();
        if ( testngStatus == ITestResult.SUCCESS ) {
            String passed = "Test passed.";
            extentTest.log(LogStatus.PASS, passed);
            logger.info(passed);
        } else if ( testngStatus == ITestResult.FAILURE ) {
            String failed = "Test failed.";
            extentTest.log(LogStatus.FAIL, failed);
            logger.error(failed);
        } else if ( testngStatus == ITestResult.SKIP ) {
            String skipped = "Test skipped.";
            extentTest.log(LogStatus.SKIP, skipped);
            logger.info(skipped);
        } else {
            String error = "Test error.";
            extentTest.log(LogStatus.ERROR, error);
            logger.error(error);
        }
    }

    public String generateTestNameByClass(Method method)
    {
        return "[t" + ExtentTestManager.getThreadId() + ":" + className + "." + method.getName() + "] " + getNameOfTestNGTest(method);
    }

    public String generateTestNameByMethod(Method method)
    {
        return "[t" + ExtentTestManager.getThreadId() + ":" + method.getName() + "] " + getNameOfTestNGTest(method);
    }

}
