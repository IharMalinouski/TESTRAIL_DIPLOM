package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TestCasePage extends BasePage {

    public static final By RETURN_TO_DASHBOARD_BUTTON = By.id("navigation-suites-add");
    public static final By NAME_FIELD = By.id("name");
    public static final By DESCRIPTION_FIELD = By.id("description_display");

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting for an element to load '{LOGIN_BUTTON}'")
    public TestCasePage waitIsPageOpened() {
        waitForElementLocated(RETURN_TO_DASHBOARD_BUTTON, 20);
        return this;
    }

    @Step("Click add test suite button")
    public TestCasePage ClickNewSuiteButton() {
        driver.findElement(RETURN_TO_DASHBOARD_BUTTON).click();
        return this;
    }

    @Step("Set '{name}' into field Name")
    public TestCasePage setNameProject(String name) {
        log.info("Set '{name}': " + name);
        driver.findElement(NAME_FIELD).sendKeys(name);
        return this;
    }

    @Step("Set '{Description}' into field Description")
    public TestCasePage setDescription(String Description) {
        log.info("Set '{Description}': " + Description);
        driver.findElement(DESCRIPTION_FIELD).sendKeys(Description);
        return this;
    }
}
