package qa.test.tests.methods;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import qa.test.TestNGParallelClassesTestBase;

public class ParallelMethodsTest2 extends TestNGParallelClassesTestBase
{
    @Test(testName="ParallelClassesTest2.assertPass21", description = "Tests a passing assertion.")
    public void assertPass21()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        Assert.assertTrue(true, "Pass message 1.");
        extentTest.log(LogStatus.INFO, "Last line of test.");
    }

    @Test(testName="ParallelClassesTest2.assertSkip21", description = "Tests a skip condition.")
    public void assertSkip21()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        throw new SkipException("Skip exception 1.");
    }

}