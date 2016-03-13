package qa.test.listeners;

import org.testng.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DebugTestNGListenerOrder implements ITestListener, ISuiteListener, IExecutionListener, IInvokedMethodListener
{
    private static final Logger LOGGER = LoggerFactory.getLogger("qa.test.listeners.DebugTestNGListenerOrder");

    @Override
    public void onExecutionStart()
    {
        LOGGER.info("IExecutionListener.onExecutionStart: Invoked before the TestNG run starts.");
    }

    @Override
    public void onStart(ISuite suite)
    {
        LOGGER.info("ISuiteListener.onStart: This method is invoked before the SuiteRunner starts.");
    }

    @Override
    public void onStart(ITestContext context)
    {
        LOGGER.info("ITestListener.onStart: Invoked after the test class is instantiated and before any configuration method is called.");
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
    {
        LOGGER.info("IInvokedMethodListener.beforeInvocation: Invoked right before test method.");
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        LOGGER.info("ITestListener.onTestStart: Invoked each time before a test will be invoked.");
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        LOGGER.info("ITestListener.onTestSuccess: Invoked each time a test succeeds.");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        LOGGER.info("ITestListener.onTestFailure: Invoked each time a test fails.");
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        LOGGER.info("ITestListener.onTestSkipped: Invoked each time a test is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        LOGGER.info("ITestListener.onTestFailedButWithinSuccessPercentage : Invoked each time a method fails but has been annotated with successPercentage and this failure still keeps it within the success percentage requested.");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult)
    {
        LOGGER.info("IInvokedMethodListener.afterInvocation: Invoked right after test method.");
    }

    @Override
    public void onFinish(ITestContext context)
    {
         LOGGER.info("ITestListener.onFinish: Invoked after all the tests have run and all their Configuration methods have been called.");
    }

    @Override
    public void onFinish(ISuite suite)
    {
        LOGGER.info("ISuiteListener.onFinish: This method is invoked after the SuiteRunner has run all the test suites.");
    }

    @Override
    public void onExecutionFinish()
    {
        LOGGER.info("IExecutionListener.onExecutionFinish: Invoked once all the suites have been run.");
    }

}
