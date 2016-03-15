package qa.test.tests.methods;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelMethodsTest1 extends TestNGParallelMethodsTestBase
{
    @Test(testName="ParallelClassesTest1.assertPass11", description = "Tests a passing assertion.")
    public void assertPass11()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        Assert.assertTrue(true, "True message 1.");
        extentTest.log(LogStatus.INFO, "Last line of test.");
    }

}
