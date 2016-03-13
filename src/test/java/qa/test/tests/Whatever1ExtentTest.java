package qa.test.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.test.ExtentTestBase;

public class Whatever1ExtentTest extends ExtentTestBase
{
    @Test(testName="assertPass11")
    public void assertPass11()
    {
        Assert.assertTrue(true, "True message 1.");
    }

}
