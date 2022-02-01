package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import modals_window.AddSectionModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TestSuitePage extends BasePage {

    public static final By RETURN_TO_DASHBOARD_BUTTON = By.id("navigation-suites-add");
    public static final By NAME_FIELD = By.id("name");
    public static final By DESCRIPTION_FIELD = By.id("description_display");
    public static final By ADD_TEST_SUITE = By.id("accept");
    public static final String NAME_TEST_SUITE = "//div[contains(@class,'content-header-title')]";
    public static final By ADD_SECTION = By.id("addSectionInline");
    public static final By ADD_TEST_CASE = By.id("sidebar-cases-add");
    public static final String EDIT_TEST_CASE = "//div[contains(@class,'chart-legend-name text-ppp')]/a";
    public static final String TEST_SUITES_TAB = "//li[contains(@class,'header-menu')]/a[contains(text(),'Test Suites & Cases')]";
    public static final String TEST_SUITE_PROJECTS_URI = "index.php?/suites/overview/109";


    public TestSuitePage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting for an element to load '{LOGIN_BUTTON}'")
    public TestSuitePage waitIsPageOpened() {
        waitForElementLocated(RETURN_TO_DASHBOARD_BUTTON, 20);
        return this;
    }

    @Step("Click add test suite button")
    public TestSuitePage clickNewSuiteButton() {
        driver.findElement(RETURN_TO_DASHBOARD_BUTTON).click();
        return this;
    }

    @Step("Set '{name}' into field Name")
    public TestSuitePage setNameProject(String name) {
        log.info("Set '{name}': " + name);
        driver.findElement(NAME_FIELD).sendKeys(name);
        return this;
    }

    @Step("Set '{Description}' into field Description")
    public TestSuitePage setDescription(String description) {
        log.info("Set '{Description}': " + description);
        driver.findElement(DESCRIPTION_FIELD).sendKeys(description);
        return this;
    }

    @Step("Click add test suite button")
    public TestSuitePage clickAddTestSuiteButton() {
        log.info("Click add test suite button");
        driver.findElement(ADD_TEST_SUITE).click();
        return this;
    }

    @Step("Get name test suite")
    public String getNameTestSuite() {
        log.info("Get name test suite");
        return driver.findElement(By.xpath(String.format(NAME_TEST_SUITE))).getText();
    }

    @Step("Click add test section button")
    public AddSectionModal clickAddSectionButton() {
        log.info("Click add test section button");
        driver.findElement(ADD_SECTION).click();
        return new AddSectionModal(driver);
    }

    @Step("Click add test case button")
    public TestCasePage clickAddTestCaseButton() {
        log.info("Click add test case button");
        driver.findElement(ADD_TEST_CASE).click();
        return new TestCasePage(driver);
    }

    @Step("Click add test suite tab")
    public TestSuitePage clickTestSuiteTab() {
        driver.findElement(By.xpath(String.format(TEST_SUITES_TAB))).click();
        return this;
    }

    @Step("Get validation message text")
    public String getNumberSection() {
        log.info("Get validation message text");
        return driver.findElement(By.xpath(String.format(EDIT_TEST_CASE))).getText();
    }

    @Step("Opening Test Suite page")
    public TestSuitePage openPage() {
        openPage(BASE_URL + TEST_SUITE_PROJECTS_URI);
        return this;
    }
}
