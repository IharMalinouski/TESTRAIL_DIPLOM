package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TestCaseStep extends BaseStep {
    public TestCaseStep(WebDriver driver) {
        super(driver);
    }

    @Step("Added new test case")
    public void addNewTestCase() {
        testCasePage
                .setTitle("New test case")
                .setType("Other")
                .setPriority("Low")
                .setEstimate("125 hours")
                .setReferences("1")
                .setAutomationType("None")
                .setPreconditions("Added new test suite")
                .setSteps("Add test suite")
                .setExpectedResult("Added test case")
                .clickButtonAddTestCase();
    }

    @Step("Added new test case")
    public void addTestCase() {
        testCasePage
                .setTitle("Update test case")
                .setType("Other")
                .setPriority("Low")
                .setEstimate("125 hours")
                .setReferences("1")
                .setAutomationType("None")
                .setPreconditions("Added new test suite")
                .setSteps("Add test suite")
                .setExpectedResult("Added test case")
                .clickButtonAddTestCase();
    }

    @Step("Added edit test case")
    public void editTestCase() {
        testCasePage
                .editTestCaseButton()
                .setUpdateTitle("Update test case")
                .setUpdateEstimate("22 hours")
                .setUpdateReferences("2")
                .setUpdatePreconditions("Update new test suite")
                .setUpdateSteps("Update test suite")
                .setUpdateExpectedResult("Update test case")
                .clickButtonAddTestCase();
    }
}
