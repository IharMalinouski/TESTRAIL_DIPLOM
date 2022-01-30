package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TestCaseStep extends BaseStep {
    public TestCaseStep(WebDriver driver) {
        super(driver);
    }

    @Step("Added new test case")
    public void addNewTestCase(String name, String type, String priority, String estimate, String references,String automationType,String preconditions, String steps, String expectedResult) {
        testCasePage
                .setTitle(name)
                .setType(type)
                .setPriority(priority)
                .setEstimate(estimate)
                .setReferences(references)
                .setAutomationType(automationType)
                .setPreconditions(preconditions)
                .setSteps(steps)
                .setExpectedResult(expectedResult)
                .clickButtonAddTestCase();
    }

    @Step("Added new test case")
    public void addTestCase(String name, String type, String priority, String estimate, String references,String automationType,String preconditions, String steps, String expectedResult) {
        testCasePage
                .setTitle(name)
                .setType(type)
                .setPriority(priority)
                .setEstimate(estimate)
                .setReferences(references)
                .setAutomationType(automationType)
                .setPreconditions(preconditions)
                .setSteps(steps)
                .setExpectedResult(expectedResult)
                .clickButtonAddTestCase();
    }

    @Step("Added edit test case")
    public void editTestCase(String name,String estimate,String references,String preconditions,String steps,String expectedResult ) {
        testCasePage
                .editTestCaseButton()
                .setUpdateTitle(name)
                .setUpdateEstimate(estimate)
                .setUpdateReferences(references)
                .setUpdatePreconditions(preconditions)
                .setUpdateSteps(steps)
                .setUpdateExpectedResult(expectedResult)
                .clickButtonAddTestCase();
    }
}
