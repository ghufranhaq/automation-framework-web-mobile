package pages;

import config.DataConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForVisibility(WebElement webElement){
        Duration timeout = Duration.ofSeconds(DataConfig.WAIT_DEFAULT_TIMEOUT);
        WebDriverWait driverWait = new WebDriverWait(driver, timeout);
        driverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void click(WebElement webElement){
        waitForVisibility(webElement);
        webElement.click();
    }
}
