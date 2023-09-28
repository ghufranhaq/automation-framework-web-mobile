package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driverThread.get() == null) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
            driverThread.set(new ChromeDriver());
        }
        return driverThread.get();
    }
}
