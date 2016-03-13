package qa.test.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.test.ExtentTestBase;

public class Whatever2ExtentTest extends ExtentTestBase
{
    @Test(testName="assertPass1")
    public void assertPass1()
    {
        Assert.assertTrue(true, "True message 1.");
    }

    @Test(testName="assertPass2")
    public void assertPass2()
    {
        Assert.assertTrue(true, "True message 2.");
    }

    @Test(testName="assertFail1")
    public void assertFail1()
    {
        Assert.assertTrue(false, "Fail message.");
    }

}