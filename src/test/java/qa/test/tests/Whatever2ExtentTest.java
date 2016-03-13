package qa.test.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import qa.test.ExtentTestBase;

public class Whatever2ExtentTest extends ExtentTestBase
{
    @Test(testName="assertPass21")
    public void assertPass21()
    {
        Assert.assertTrue(true, "Pass message 1.");
    }

    @Test(testName="assertSkip21")
    public void assertSkip21()
    {
        throw new SkipException("Skip exception 1.");
    }

}