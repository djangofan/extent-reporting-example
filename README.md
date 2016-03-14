# extent-reporting-example

Example of using Extent reports with TestNG with Java.

### TestNG configuration

In `build.gradle`, set the location of the suite file:

    test {
        useTestNG() {
            suiteXmlFiles << new File(rootDir, "src/test/resources/testng_by_classes.xml")
        }
    }

### Execution of tests

Run build with gradle, using these goals: `clean test`

## Notes

Someone elses implemenation: https://github.com/virenv/ExtentReportUsage/tree/master/ParallelUsage/src/Factory
