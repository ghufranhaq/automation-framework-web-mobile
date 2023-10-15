package base;

import config.DataConfig;
import webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver (you can choose Chrome, Firefox, etc.)
        driver = DriverManager.getDriver();
        driver.get(DataConfig.baseUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
