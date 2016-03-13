package qa.test.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import qa.test.ExtentTestBase;

public class Whatever1ExtentTest extends ExtentTestBase
{
    @Test(testName="assertPass1")
    public void assertPass1()
    {
        Assert.assertTrue(true, "True message 1.");
    }

    @Test(testName="assertSkip1")
    public void assertSkip1()
    {
        throw new SkipException("Skip exception.");
    }

}
