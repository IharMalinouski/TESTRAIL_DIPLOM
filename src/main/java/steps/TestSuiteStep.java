package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TestSuiteStep extends BaseStep {
    public TestSuiteStep(WebDriver driver) {
        super(driver);
    }

    @Step("Create Test Suite")
    public void createTestSuite() {
        projectPage
                .clickTabTestCases()
                .waitIsPageOpened()
                .clickNewSuiteButton()
                .setNameProject("Test Suite 1")
                .setDescription("New test suite")
                .clickAddTestSuiteButton();
    }

    @Step("Added new section")
    public TestSuiteStep addNewSelection() {
        testSuitePage
                .clickAddSectionButton();
        return this;
    }

    @Step("Added new test case")
    public TestSuiteStep addTestCase() {
        projectPage
                .clickTabTestCases()
                .waitIsPageOpened()
                .clickNewSuiteButton()
                .setNameProject("Test Suite 1")
                .setDescription("New test suite")
                .clickAddTestSuiteButton();
        testSuitePage
                .clickAddSectionButton();
        addSectionModal
                .setNameSection("New section")
                .setDescriptionSection("New section on test suite")
                .clickAddTestSuiteButton();
        return this;
    }

    @Step("Added new test case")
    public TestSuiteStep addNewTestCase() {
        testSuitePage
                .clickAddTestCaseButton();
        return this;

    }

    @Step("Added new test cases")
    public TestSuiteStep addNewTestCases() {
        projectPage
                .clickTabTestCases()
                .waitIsPageOpened()
                .clickNewSuiteButton()
                .setNameProject("Test Suite 1")
                .setDescription("New test suite")
                .clickAddTestSuiteButton();
        testSuitePage
                .clickAddTestCaseButton();
        return this;

    }

}
