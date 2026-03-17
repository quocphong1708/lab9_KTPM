package framework.utils;

import org.testng.ITest;
import org.testng.annotations.Test;

public class TestName implements ITest {

    private String testName = "";

    @Override
    public String getTestName() {
        return testName;
    }

    public void setTestName(String name) {
        this.testName = name;
    }
}