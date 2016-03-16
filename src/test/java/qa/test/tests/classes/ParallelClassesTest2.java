package qa.test.tests.classes;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ParallelClassesTest2 extends TestNGParallelClassesTestBase
{
    @Test(testName="Parallel Classes Test assertSkip", description = "Tests a skip condition.", timeOut = 10)
    public void assertSkip()
    {
        extentTest.log(LogStatus.INFO, "First line of test.");
        throw new SkipException("Skip exception.");
    }
}