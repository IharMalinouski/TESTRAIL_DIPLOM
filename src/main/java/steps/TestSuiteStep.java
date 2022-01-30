package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TestSuiteStep extends BaseStep {
    public TestSuiteStep(WebDriver driver) {
        super(driver);
    }

    @Step("Create Test Suite")
    public void createTestSuite(String name, String description) {
        projectPage
                .clickTabTestCases()
                .waitIsPageOpened()
                .clickNewSuiteButton()
                .setNameProject(name)
                .setDescription(description)
                .clickAddTestSuiteButton();
    }

    @Step("Added new section")
    public TestSuiteStep addNewSelection() {
        testSuitePage
                .clickAddSectionButton();
        return this;
    }

    @Step("Added new test case")
    public TestSuiteStep addTestCase(String name, String description, String nameModal,String descriptionModal) {
        projectPage
                .clickTabTestCases()
                .waitIsPageOpened()
                .clickNewSuiteButton()
                .setNameProject(name)
                .setDescription(description)
                .clickAddTestSuiteButton();
        testSuitePage
                .clickAddSectionButton();
        addSectionModal
                .waitForModalOpened()
                .setNameSection(nameModal)
                .setDescriptionSection(descriptionModal)
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
    public TestSuiteStep addNewTestCases(String name, String description) {
        projectPage
                .clickTabTestCases()
                .waitIsPageOpened()
                .clickNewSuiteButton()
                .setNameProject(name)
                .setDescription(description)
                .clickAddTestSuiteButton();
        testSuitePage
                .clickAddTestCaseButton();
        return this;

    }
}
