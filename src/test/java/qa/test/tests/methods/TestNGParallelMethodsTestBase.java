package qa.test.tests.methods;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.*;
import qa.test.tests.TestNGParallelTestBase;
import qa.test.util.ExtentTestManager;
import java.lang.reflect.Method;

/**
 * Test base for TestNG tests.
 */
public abstract class TestNGParallelMethodsTestBase extends TestNGParallelTestBase
{
    @BeforeMethod
    public void setupBeforeMethod(Method method)
    {
        setTestName(generateTestNameByMethod(method));
        setTestDescription(method.getAnnotation(Test.class).description());
        extentTest = ExtentTestManager.startTest(getTestName(), getTestDescription());
        extentTest.log(LogStatus.UNKNOWN, "Initialized test class <i>" + canonicalClassName + "</i>");
        extentTest.log(LogStatus.INFO, "Starting test with name <b>" + getTestName() + "</b>");
    }

    @AfterMethod
    public void teardownAfterMethod(ITestResult testResult)
    {
        logTestResult(extentTest, testResult);
        ExtentTestManager.endTest();
    }

}
