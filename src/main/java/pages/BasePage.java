package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public abstract class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void waitForElementLocated(By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        log.debug("Waiter timeout is: " + timeout + " for element: " + element);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
