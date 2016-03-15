package qa.test.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExtentReportsManager
{
    private static ExtentReports extentReports;
    private static final String reportLocation = "build" + File.separator + "extentReports-report" + File.separator + "index.html";

    public synchronized static ExtentReports getReporter()
    {
        if (extentReports == null)
        {
            extentReports = new ExtentReports(reportLocation, Boolean.TRUE, NetworkMode.OFFLINE);
            extentReports.addSystemInfo("Environment", "QA");
            extentReports.addSystemInfo("Creation Date", getFormattedDateTime());
        }
        return extentReports;
    }

    public static String getFormattedDateTime()
    {
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String today = formatter.format(date);
        return today;
    }

}
