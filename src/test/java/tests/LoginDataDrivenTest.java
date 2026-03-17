package tests;

import lab_9framework.base.BaseTest;
import framework.pages.LoginPage;
import framework.pages.InventoryPage;
import framework.utils.TestName;
import framework.utils.TestNameListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginDataDrivenTest extends BaseTest {

	@Test(dataProvider = "smokeData", groups = "smoke")
	public void testLogin(String user, String pass, String expected, String desc) {

	    ((TestName) this).setTestName(desc);

	    System.out.println("Running: " + desc);
	}
    public void testLoginSmoke(String user, String pass, String expectedUrl, String desc) {

        TestNameListener.setTestName(desc);

        LoginPage page = new LoginPage(getDriver());

        // login thành công → sang InventoryPage
        InventoryPage inventoryPage = page.login(user, pass);

        // lấy URL thật từ driver
        String currentUrl = getDriver().getCurrentUrl();

        Assert.assertTrue(currentUrl.contains(expectedUrl),
                "URL không đúng. Actual: " + currentUrl);
    }

    @Test(
        dataProvider = "negativeData",
        dataProviderClass = LoginDataProvider.class,
        groups = "regression"
    )
    public void testLoginNegative(String user, String pass, String expectedError, String desc) {

        TestNameListener.setTestName(desc);

        LoginPage page = new LoginPage(getDriver());
        page.loginExpectingFailure(user, pass);

        String actualError = page.getErrorMessage();

        Assert.assertTrue(actualError.contains(expectedError),
                "Error message sai. Actual: " + actualError);
    }

    @Test(
        dataProvider = "boundaryData",
        dataProviderClass = LoginDataProvider.class,
        groups = "regression"
    )
    public void testLoginBoundary(String user, String pass, String expectedError, String desc) {

        TestNameListener.setTestName(desc);

        LoginPage page = new LoginPage(getDriver());
        page.loginExpectingFailure(user, pass);

        String actualError = page.getErrorMessage();

        Assert.assertTrue(actualError.contains(expectedError),
                "Error message sai. Actual: " + actualError);
    }
    @Test
    public void testDebug() {
        System.out.println("RUN OK");
    }
    
}