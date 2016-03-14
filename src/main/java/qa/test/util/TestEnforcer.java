package qa.test.util;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.SkipException;

import java.lang.annotation.Annotation;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;

public class TestEnforcer
{
    public static void thereCanBeOnlyOneTestMethod(Class<?> klass, Class<?> annotation, ExtentTest extentTest)
    {
        int count = 0;
        for (Method m : klass.getMethods()) {
            if (m.isAnnotationPresent((Class<? extends Annotation>) annotation)) {
                count++;
            }
        }
        if ( count != 1 )
        {
            try {
                throw new IllegalClassFormatException("Test class must have only one method.");
            } catch (IllegalClassFormatException e) {
                extentTest.log(LogStatus.SKIP, "Skipping because class contains more than one test method.", e);
                throw new SkipException("Skipping because class contains more than one test method.");
            }
        }
    }

}