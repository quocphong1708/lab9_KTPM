package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import lab_9framework.base.BaseTest;

public class SampleTest extends BaseTest {

    @Test
    public void testFailToCheckScreenshot() {
        Assert.assertTrue(false); // cố tình fail
    }
}