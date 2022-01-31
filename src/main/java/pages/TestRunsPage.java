package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TestRunsPage extends BasePage {

    public static final String TEST_RUNS_PROJECTS_URI = "index.php?/runs/overview/105";
    public static final By ADD_TEST_RUNS_BUTTON = By.id("navigation-runs-add");
    public static final By TEST_RUNS_NAME_INPUT = By.id("name");
    public static final By TEST_RUNS_REFERENCES_INPUT = By.id("refs");
    public static final By DESCRIPTION_TEXTAREA = By.id("description_display");
    public static final By ADD_TEST_RUN_BUTTON = By.id("accept");
    public static final String GET_NAME_TEST_RUN = "//div[contains(@class,'content-header-title')]";
    public static final String CLOSE_RUN_BUTTON = "//div[contains(@class,'icon-close')]";
    public static final String OK_CLOSE_BUTTON = "//div[contains(@class,'button-group dialog-buttons-highlighted')]//a[contains(text(), 'Yes')]";
    public static final String ERROR_MESSAGE = "//div[contains(@class,'message message-success')]";

    public TestRunsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening page")
    public TestRunsPage openPage() {
        openPage(BASE_URL + TEST_RUNS_PROJECTS_URI);
        return this;
    }

    @Step("Waiting for an element to load 'ADD_TEST_RUNS_BUTTON'")
    public TestRunsPage waitIsPageOpened() {
        waitForElementLocated(TEST_RUNS_NAME_INPUT, 20);
        return this;
    }

    @Step("Click create test runs button")
    public TestRunsPage clickNewSuiteButton() {
        driver.findElement(ADD_TEST_RUNS_BUTTON).click();
        return this;
    }

    @Step("Set '{nameRun}' into field name")
    public TestRunsPage setTitle(String nameRun) {
        driver.findElement(TEST_RUNS_NAME_INPUT).clear();
        driver.findElement(TEST_RUNS_NAME_INPUT).sendKeys(nameRun);
        return this;
    }

    @Step("Set '{runReferences}' into field References")
    public TestRunsPage setReferences(String runReferences) {
        driver.findElement(TEST_RUNS_REFERENCES_INPUT).clear();
        driver.findElement(TEST_RUNS_REFERENCES_INPUT).click();
        driver.findElement(TEST_RUNS_REFERENCES_INPUT).sendKeys(runReferences);
        return this;
    }

    @Step("Set '{runDescription}' into field Description")
    public TestRunsPage setDescription(String runDescription) {
        driver.findElement(DESCRIPTION_TEXTAREA).sendKeys(runDescription);
        return this;
    }

    @Step("Click add test run button")
    public TestRunsPage addTestRunButton() {
        log.info("Click add test run button");
        driver.findElement(ADD_TEST_RUN_BUTTON).click();
        return this;
    }

    @Step("Get name test run")
    public String getNameTestRun() {
        log.info("Get name test run");
        return driver.findElement(By.xpath(String.format(GET_NAME_TEST_RUN))).getText();
    }

    @Step("Click close test run button")
    public TestRunsPage closeTestRunButton() {
        log.info("Click close test run button");
        driver.findElement(By.xpath(String.format(CLOSE_RUN_BUTTON))).click();
        return this;
    }

    @Step("Click close test run button")
    public TestRunsPage clickCloseTestRun() {
        log.info("Click close test run button");
        driver.findElement(By.xpath(String.format(OK_CLOSE_BUTTON))).click();
        return this;
    }

        @Step("Get validation message text")
        public String getValidationText() {
            log.info("Get validation message text");
            return driver.findElement(By.xpath(String.format(ERROR_MESSAGE))).getText();
        }

    @Step("Waiting for an element to load validation text")
    public TestRunsPage waitIsValidationTextOpened() {
        waitForElementLocated(By.xpath(String.format(ERROR_MESSAGE)), 20);
        return this;
    }
}
