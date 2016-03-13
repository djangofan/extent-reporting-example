package qa.test;

import org.apache.commons.lang3.StringUtils;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

public abstract class ExtentTestBase implements ITest
{
    private String testName;

    public String getTestName()
    {
        if (StringUtils.isBlank(this.testName))
        {
            this.testName = "undefined";
        }
        return this.testName;
    }

    public void setTestName(String name)
    {
        this.testName = name;
    }

    @BeforeMethod
    public void setupBeforeTestMethod(ITestResult iTestResult)
    {
        setTestName((String)iTestResult.getAttribute("annotatedTestName"));
    }

}
