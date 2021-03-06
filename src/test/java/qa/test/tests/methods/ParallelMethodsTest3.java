package qa.test.tests.methods;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelMethodsTest3 extends TestNGParallelMethodsTestBase
{
    @Test(testName="Parallel Methods Test 3 assertPass31", description = "Tests a passing assertion.", timeOut = 10)
    public void assertPass31()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        Assert.assertTrue(true, "True message 1.");
        extentTest.log(LogStatus.INFO, "Last line of test.");
    }

    @Test(testName="Parallel Methods Test 3 assertPass32", description = "Tests a passing assertion.", timeOut = 10)
    public void assertPass32()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        Assert.assertTrue(true, "True message 2.");
        extentTest.log(LogStatus.INFO, "Last line of test.");
    }

    @Test(testName="Parallel Methods Test 3 assertFail31", description = "Tests a failing assertion.", timeOut = 10)
    public void assertFail31()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        Assert.assertTrue(false, "Fail message.");
        extentTest.log(LogStatus.INFO, "Last line of test.");
    }

}