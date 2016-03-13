# extent-reporting-example

Example of using Extent reports with TestNG.

### TestNG configuration

In `build.gradle`, set the location of the suite file:

    test {
        useTestNG() {
            suiteXmlFiles << new File(rootDir, "src/test/resources/testng_run1.xml")
        }
    }

### Execution of tests

Run build with gradle, using these goals: `clean test`
