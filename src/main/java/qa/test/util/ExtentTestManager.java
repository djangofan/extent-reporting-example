package qa.test.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExtentTestManager
{
    static Map extentTestMap = new ConcurrentHashMap();
    private static ExtentReports extentReports = ExtentReportsManager.getReporter();

    public static synchronized ExtentTest getTest()
    {
        return getExtentTestByThreadId(getThreadId());
    }

    public static synchronized void endTest()
    {
        extentReports.endTest(getExtentTestByThreadId(getThreadId()));
        extentReports.flush();
        extentTestMap.remove(getThreadId());
    }

    public static synchronized ExtentTest startTest(String testName)
    {
        return startTest(testName, "Empty test description.");
    }

    public static synchronized ExtentTest startTest(String testName, String desc)
    {
        ExtentTest test = extentReports.startTest(testName, desc);
        extentTestMap.put(getThreadId(), test);
        return test;
    }

    public static int getThreadId()
    {
        return (int) Thread.currentThread().getId();
    }

    public static ExtentTest getExtentTestByThreadId(int id)
    {
        return (ExtentTest) extentTestMap.get(id);
    }

    public static String getCurrentMethodName()
    {
        return Thread.currentThread().getStackTrace()[1].getMethodName();
    }

}
