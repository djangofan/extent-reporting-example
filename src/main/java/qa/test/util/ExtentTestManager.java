package qa.test.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager
{
    static Map extentTestMap = new HashMap();
    private static ExtentReports extentReports = ExtentReportsManager.getReporter();

    public static synchronized ExtentTest getTest()
    {
        return getExtentTestByThreadId(getThreadId());
    }

    public static synchronized void endTest()
    {
        extentReports.endTest( getExtentTestByThreadId(getThreadId()) );
    }

    public static synchronized ExtentTest startTest(String testName)
    {
        return startTest(testName, "");
    }

    public static synchronized ExtentTest startTest(String testName, String desc)
    {
        ExtentTest test = extentReports.startTest(testName, desc);
        extentTestMap.put(getThreadId(), test);
        return test;
    }

    public static int getThreadId()
    {
        return (int)Thread.currentThread().getId();
    }

    public static ExtentTest getExtentTestByThreadId(int id)
    {
        return (ExtentTest)extentTestMap.get(id);
    }

    public static String getCurrentMethodName()
    {
        return Thread.currentThread().getStackTrace()[1].getMethodName();
    }



}
