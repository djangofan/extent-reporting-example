package qa.test.tests.classes;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import qa.test.TestNGParallelClassesTestBase;

public class ParallelClassesTest2 extends TestNGParallelClassesTestBase
{
    @Test(testName="ParallelClassesTest2.assertSkip", description = "Tests a skip condition.")
    public void assertSkip()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        throw new SkipException("Skip exception.");
    }
}