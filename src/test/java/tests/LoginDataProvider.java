package tests;

import framework.utils.ExcelReader;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    private static final String FILE = "src/test/resources/login_data.xlsx";

    @DataProvider(name = "smokeData")
    public static Object[][] smokeData() {
        return ExcelReader.readSheet(FILE, "SmokeCases");
    }

    @DataProvider(name = "negativeData")
    public static Object[][] negativeData() {
        return ExcelReader.readSheet(FILE, "NegativeCases");
    }

    @DataProvider(name = "boundaryData")
    public static Object[][] boundaryData() {
        return ExcelReader.readSheet(FILE, "BoundaryCases");
    }
    @DataProvider(name = "smokeData")
    public Object[][] smokeData() {
        return ExcelReader.readSheet("login_data.xlsx", "Smoke");
    }

    @DataProvider(name = "regressionData")
    public Object[][] regressionData() {
        return ExcelReader.mergeSheets("login_data.xlsx",
                new String[]{"Smoke", "Negative", "Boundary"});
    }
}