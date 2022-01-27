package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {

    public static final By PROJECT_TAB = By.id("projects-tabs-project");
    public static final By TEST_CASES_TAB = By.id("navigation-suites");
    public static final By PROJECT_NAME = By.id("navigation-project");
    public static final By TEST_RUNS_TAB = By.id("navigation-runs");
    public static final By RETURN_TO_DASHBOARD_BUTTON = By.id("navigation-dashboard-top");
    public static final By DASHBOARD_TAB = By.id("navigation-dashboard");

    public ProjectPage(WebDriver driver) {
        super(driver);
    }


    @Step("Waiting for an element to load '{LOGIN_BUTTON}'")
    public ProjectPage waitIsAuthorizationPageOpened() {
        waitForElementLocated(RETURN_TO_DASHBOARD_BUTTON, 20);
        return this;
    }

    @Step("Get name project")
    public String getNameProject() {
        return driver.findElement(PROJECT_NAME).getText();
    }

    @Step("Click tab TEST CASES")
    public TestSuitePage clickTabTestCases() {
        driver.findElement(TEST_CASES_TAB).click();
        return new TestSuitePage(driver);
    }

    @Step("Click tab TEST RUNS")
    public TestCasePage clickTabTestRuns() {
        driver.findElement(TEST_RUNS_TAB).click();
        return new TestCasePage(driver);
    }

    public DashboardPage returnToDashboardPage() {
        driver.findElement(DASHBOARD_TAB).click();
        return new DashboardPage(driver);
    }
}

