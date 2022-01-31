package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TestRunsStep extends BaseStep {
    public TestRunsStep(WebDriver driver) {
        super(driver);
    }

    @Step("Create test run")
    public void createTestRun(String nameRun, String runReferences, String runDescription) {
        testRunsPage
                .openPage()
                .waitIsPageOpened()
                .clickNewSuiteButton();
        addTestRunsModal
                .waitForModalOpened()
                .clickAddTestRunButton();
        testRunsPage
                .setTitle(nameRun)
                .setReferences(runReferences)
                .setDescription(runDescription)
                .addTestRunButton();
    }

    @Step("Closr test run")
    public void closeTestRun(String nameRun, String runReferences, String runDescription) {
        testRunsPage
                .openPage()
                .waitIsPageOpened()
                .clickNewSuiteButton();
        addTestRunsModal
                .waitForModalOpened()
                .clickAddTestRunButton();
        testRunsPage
                .setTitle(nameRun)
                .setReferences(runReferences)
                .setDescription(runDescription)
                .addTestRunButton()
                .closeTestRunButton()
                .clickCloseTestRun()
                .waitIsValidationTextOpened();
    }
}
