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
    public static String DEFAULT_REPORT_LOCATION = "build" + File.separator + "reports" + File.separator + "extent" + File.separator + "index.html";
    private static String reportLocation;

    public synchronized static ExtentReports getReporter()
    {
        if (reportLocation == null)
        {
            reportLocation = DEFAULT_REPORT_LOCATION;
        }
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

    public synchronized static void closeReporter()
    {
        if (extentReports != null) {
            extentReports.close();
        }
    }

    /**
     * For use in a BeforeSuite call to alter report location on a per-suite basis.
     * @param suiteName
     */
    public static void alterReportLocation(String suiteName)
    {
        reportLocation = "build" + File.separator + "reports" + File.separator + "extent"
                + File.separator + suiteName + File.separator + "index.html";
    }

    public static void nullifyReportLocation()
    {
        reportLocation = null;
    }

}
