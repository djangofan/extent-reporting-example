package qa.test.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.test.ExtentTestBase;

public class Whatever3ExtentTest extends ExtentTestBase
{
    @Test(testName="Whatever3ExtentTest.assertPass31")
    public void assertPass31()
    {
        Assert.assertTrue(true, "True message 1.");
    }

    @Test(testName="Whatever3ExtentTest.assertPass32")
    public void assertPass32()
    {
        Assert.assertTrue(true, "True message 2.");
    }

    @Test(testName="Whatever3ExtentTest.assertFail31")
    public void assertFail31()
    {
        Assert.assertTrue(false, "Fail message.");
    }

}