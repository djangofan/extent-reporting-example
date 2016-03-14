package qa.test.tests.methods;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import qa.test.TestNGParallelClassesTestBase;

public class ParallelMethodsTest3 extends TestNGParallelClassesTestBase
{
    @Test(testName="ParallelClassesTest3.assertPass31", description = "Tests a passing assertion.")
    public void assertPass31()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        Assert.assertTrue(true, "True message 1.");
        extentTest.log(LogStatus.INFO, "Last line of test.");
    }

    @Test(testName="ParallelClassesTest3.assertPass32", description = "Tests a passing assertion.")
    public void assertPass32()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        Assert.assertTrue(true, "True message 2.");
        extentTest.log(LogStatus.INFO, "Last line of test.");
    }

    @Test(testName="ParallelClassesTest3.assertFail31", description = "Tests a failing assertion.")
    public void assertFail31()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        Assert.assertTrue(false, "Fail message.");
        extentTest.log(LogStatus.INFO, "Last line of test.");
    }

}