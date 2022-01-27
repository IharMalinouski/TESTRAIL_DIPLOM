package pages;

import element.DropDown;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TestCasePage extends BasePage {

    public static final By TITLE_INPUT = By.id("title");
    public static final By ESTIMATE_INPUT = By.id("estimate");
    public static final By REFERENCES_INPUT = By.id("refs");
    public static final By PRECONDITIONS_TEXTAREA = By.id("custom_preconds_display");
    public static final By STEPS_TEXTAREA = By.id("custom_steps_display");
    public static final By EXPECTED_RESULT_TEXTAREA = By.id("custom_expected_display");
    public static final By ADD_TEST_CASE_BUTTON = By.id("accept");
    public static final String NAME_TITLE_TEST_CASE = "//div[contains(@class,'content-header-title')]";
    public static final String EDIT_TEST_CASE = "//a[contains(@class,'toolbar-button')]";

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Set '{name}' into field Title")
    public TestCasePage setTitle(String name) {
        driver.findElement(TITLE_INPUT).sendKeys(name);
        return this;
    }

    @Step("Set '{type}' into dropdown Type")
    public TestCasePage setType(String type) {
        new DropDown(driver, "Type").select(type);
        return this;
    }

    @Step("Set '{priority}' into dropdown Priority")
    public TestCasePage setPriority(String priority) {
        new DropDown(driver, "Priority").select(priority);
        return this;
    }

    @Step("Set '{estimate}' into field Estimate")
    public TestCasePage setEstimate(String estimate) {
        driver.findElement(ESTIMATE_INPUT).sendKeys(estimate);
        return this;
    }

    @Step("Set '{references}' into field References")
    public TestCasePage setReferences(String references) {
        driver.findElement(REFERENCES_INPUT).sendKeys(references);
        return this;
    }

    @Step("Set '{automationType}' into dropdown Automation Type")
    public TestCasePage setAutomationType(String automationType) {
        new DropDown(driver, "Automation Type").select(automationType);
        return this;
    }

    @Step("Set '{preconditions}' into field Preconditions")
    public TestCasePage setPreconditions(String preconditions) {
        driver.findElement(PRECONDITIONS_TEXTAREA).sendKeys(preconditions);
        return this;
    }

    @Step("Set '{steps}' into field Steps")
    public TestCasePage setSteps(String steps) {
        driver.findElement(STEPS_TEXTAREA).sendKeys(steps);
        return this;
    }

    @Step("Set '{expectedResult}' into field Expected Result")
    public TestCasePage setExpectedResult(String expectedResult) {
        driver.findElement(EXPECTED_RESULT_TEXTAREA).sendKeys(expectedResult);
        return this;
    }

    @Step("Click button 'Add Test Case'")
    public TestCasePage clickButtonAddTestCase() {
        driver.findElement(ADD_TEST_CASE_BUTTON).click();
        return this;
    }

    @Step("Get text title")
    public String getTitleTestCase() {
        log.info("Get text title");
        return driver.findElement(By.xpath(String.format(NAME_TITLE_TEST_CASE))).getText();
    }

    @Step("Click edit test case button")
    public TestCasePage editTestCaseButton() {
        log.info("Click edit test case button");
        driver.findElement(By.xpath(String.format(EDIT_TEST_CASE))).click();
        return this;
    }


    @Step("Set '{name}' into field Title")
    public TestCasePage setUpdateTitle(String name) {
        driver.findElement(TITLE_INPUT).clear();
        driver.findElement(TITLE_INPUT).sendKeys(name);
        return this;
    }

    @Step("Set '{estimate}' into field Estimate")
    public TestCasePage setUpdateEstimate(String estimate) {
        driver.findElement(ESTIMATE_INPUT).clear();
        driver.findElement(ESTIMATE_INPUT).sendKeys(estimate);
        return this;
    }

    @Step("Set '{references}' into field References")
    public TestCasePage setUpdateReferences(String references) {
        driver.findElement(REFERENCES_INPUT).clear();
        driver.findElement(REFERENCES_INPUT).sendKeys(references);
        return this;
    }

    @Step("Set '{preconditions}' into field Preconditions")
    public TestCasePage setUpdatePreconditions(String preconditions) {
        driver.findElement(PRECONDITIONS_TEXTAREA).clear();
        driver.findElement(PRECONDITIONS_TEXTAREA).sendKeys(preconditions);
        return this;
    }

    @Step("Set '{steps}' into field Steps")
    public TestCasePage setUpdateSteps(String steps) {
        driver.findElement(STEPS_TEXTAREA).clear();
        driver.findElement(STEPS_TEXTAREA).sendKeys(steps);
        return this;
    }

    @Step("Set '{expectedResult}' into field Expected Result")
    public TestCasePage setUpdateExpectedResult(String expectedResult) {
        driver.findElement(EXPECTED_RESULT_TEXTAREA).clear();
        driver.findElement(EXPECTED_RESULT_TEXTAREA).sendKeys(expectedResult);
        return this;
    }
}
