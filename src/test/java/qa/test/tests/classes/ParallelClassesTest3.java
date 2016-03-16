package qa.test.tests.classes;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelClassesTest3 extends TestNGParallelClassesTestBase
{
    @Test(testName="Parallel Classes Test assertFail", description = "Tests a failing assertion.")
    public void assertFail()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        Assert.assertTrue(false, "Failed assertion.");
        extentTest.log(LogStatus.INFO, "Last line of test.");
    }

}