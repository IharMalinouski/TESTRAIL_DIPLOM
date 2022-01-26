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
                .clickTabTestCases();
        testSuitePage
                .waitIsPageOpened()
                .ClickNewSuiteButton()
                .setNameProject("Test Suite 1")
                .setDescription("New test suite")
                .clickAddTestSuiteButton();
    }

    @Step("Create Test Suite")
    public void open() {

        projectPage
                .clickTabTestCases();
        testSuitePage
                .waitIsPageOpened()
                .ClickNewSuiteButton()
                .setNameProject("Test Suite 1")
                .setDescription("New test suite")
                .clickAddTestSuiteButton();
    }

    @Step("Added new section")
    public void addNewSelection() {
        testSuitePage
                .clickAddSectionButton();


    }

}
