# extent-reporting-example

Example of using Extent reports with TestNG with Java.

    STATUS: Project still in beta phase until I work out the kinks.

### TestNG configuration

In `build.gradle`, set the location of the suite file:

    test {
        useTestNG() {
            suiteXmlFiles << new File(rootDir, "src/test/resources/testng.xml")
        }
    }

### Execution of tests

Run build with gradle, using these goals: `clean test`

## Notes

Loosely based of this example: https://github.com/virenv/ExtentReportUsage/tree/master/ParallelUsage/src/Factory

Supports both testing by parallel methods and also by parallel classes.

Generates a separate html test report for each suite file.  You can merge them using Extent Server.
