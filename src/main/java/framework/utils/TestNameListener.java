package framework.utils;

import org.testng.ITest;
import org.testng.ITestResult;

public class TestNameListener implements ITest {

    private static ThreadLocal<String> testName = new ThreadLocal<>();

    public static void setTestName(String name) {
        testName.set(name);
    }

    @Override
    public String getTestName() {
        return testName.get();
    }
}