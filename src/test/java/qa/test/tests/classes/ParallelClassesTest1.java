package qa.test.tests.classes;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelClassesTest1 extends TestNGParallelClassesTestBase
{
    @Test(testName="Parallel Classes Test assertPass", description = "Tests a passing assertion.", timeOut = 10)
    public void assertPass()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        Assert.assertTrue(true, "Passed assertion.");
        extentTest.log(LogStatus.INFO, "Last line of test.");
    }

}
