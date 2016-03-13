package qa.test.listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.testng.*;
import java.io.File;
import java.util.Date;

public class ExtentNGSuiteReporter implements ITestListener, ISuiteListener, IExecutionListener, IInvokedMethodListener
{
    private ExtentReports extentReports;
    private ExtentTest extentTest;

    private final String reportLocation = "build" + File.separator + "reports" + File.separator + "extent"
            + File.separator + "index.html";

    @Override
    public void onExecutionStart()
    {
        //Invoked before the TestNG run starts.
        extentReports = new ExtentReports(reportLocation, true, NetworkMode.OFFLINE);
    }

    @Override
    public void onStart(ISuite suite)
    {
        //This method is invoked before the SuiteRunner starts.
    }

    @Override
    public void onStart(ITestContext context)
    {
        //Invoked after the test class is instantiated and before any configuration method is called.
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
    {
        // invoked right before test method
    }


    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult)
    {
        // invoked right after test method
        ITestNGMethod iTestNGMethod = method.getTestMethod();
        ITestClass iTestClass = iTestNGMethod.getTestClass();
        String annotatedTestName = iTestClass.getTestName();
        testResult.setAttribute("annotatedTestName", annotatedTestName);
        String testName = (String)testResult.getAttribute("annotatedTestName");
        extentTest = extentReports.startTest(testName, "Description: -------");
        extentTest.log(LogStatus.INFO, "Starting test " + testName + " ...");
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        //Invoked each time before a test will be invoked
        extentTest.setStartedTime(new Date());
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        //Invoked each time a test succeeds.
        extentTest.log(LogStatus.PASS, "Test Passed.");
        extentTest.setEndedTime(new Date());
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        //Invoked each time a test fails.
        extentTest.log(LogStatus.FAIL, "Test Failed.");
        extentTest.setEndedTime(new Date());
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        //Invoked each time a test is skipped.
        extentTest.log(LogStatus.SKIP, "Test Skipped.");
        extentTest.setEndedTime(new Date());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        //Invoked each time a method fails but has been annotated with successPercentage and this failure still keeps it within the success percentage requested.
        extentTest.log(LogStatus.FAIL, "Test Failed By Test Percentage.");
        extentTest.setEndedTime(new Date());
        extentReports.endTest(extentTest);  // ???
        extentReports.flush();
    }

    @Override
    public void onFinish(ITestContext context)
    {
         //Invoked after all the tests have run and all their Configuration methods have been called.
        // if you run from a testng.xml file, then context will not be null
    }

    @Override
    public void onFinish(ISuite suite)
    {
        //This method is invoked after the SuiteRunner has run all the test suites.
    }

    @Override
    public void onExecutionFinish()
    {
        //Invoked once all the suites have been run.

        extentReports.close();
    }

}
