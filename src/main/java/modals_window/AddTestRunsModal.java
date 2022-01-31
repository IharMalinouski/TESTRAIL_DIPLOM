package modals_window;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.TestRunsPage;

@Log4j2
public class AddTestRunsModal extends BaseModal {

    public static final By ADD_TEST_RUNS_BUTTON = By.xpath("//button[contains(@class,'button button-left')]");

    public AddTestRunsModal(WebDriver driver) {
        super(driver);
    }

    public AddTestRunsModal waitForModalOpened() {
        waitForElementLocated(ADD_TEST_RUNS_BUTTON, 20);
        return this;
    }

    @Step("Click add test runs button")
    public TestRunsPage clickAddTestRunButton() {
        log.info("Click add test runs button");
        driver.findElement(ADD_TEST_RUNS_BUTTON).click();
        return new TestRunsPage(driver);
    }
}
