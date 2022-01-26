package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TestCaseStep extends BaseStep {
    public TestCaseStep(WebDriver driver) {
        super(driver);
    }

    @Step("Create Test Suite")
    public void createTestSuite() {
        projectPage
                .clickTabTestCases();
        testCasePage
                .waitIsPageOpened()
                .ClickNewSuiteButton()
                .setNameProject("Test Suite 1")
                .setDescription("New test suite");
    }
}
