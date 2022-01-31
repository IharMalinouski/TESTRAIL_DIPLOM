package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilites.PropertyReader;
import utilites.Retry;

@Log4j2
public class TestRailTests extends BaseTest {

    @Test(description = "Creating a new project with value 'Use multiple test suites to manage cases'", retryAnalyzer = Retry.class, groups = {"Smoke"}, priority = 0)
    @Description("Create a new project from Dashboard")
    public void createFirstNewProjectTest() {
        loginStep
                .authorization(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        dashboardPage
                .openPageNewProject()
                .waitIsNewProjectPageOpened()
                .setNameProject("New project 1")
                .setAnnouncementOfProject("New project 1")
                .activateCheckBox()
                .chooseRadioButton("Use multiple test suites to manage cases")
                .clickAddProjectButton();
        Assert.assertEquals(ProjectsPage.getNameProject(), "New project 1");
    }

    @Test(description = "Delete project", retryAnalyzer = Retry.class, groups = {"Smoke"})
    @Description("Delete project")
    public void deleteNewProjectTest() {
        loginStep
                .authorization(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        projectsStep
                .deleteNewProject("New project 1");
        modalStep
                .deleteNewProject();
        Assert.assertEquals(dashboardPage.getValidationTextProject(), "Successfully deleted the project.");
    }

    @Test(description = "Open project", retryAnalyzer = Retry.class, groups = {"Smoke"})
    @Description("Open project")
    public void openNewProjectOnProjectPageTest() {
        loginStep
                .authorization(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        dashboardStep
                .openNewProject("New project 1");
        Assert.assertEquals(projectPage.getNameProject(), "New project 1");
    }

    @Test(description = "Create test suite", retryAnalyzer = Retry.class, groups = {"Smoke"})
    @Description("Create test suite")
    public void createTestSuiteTest() {
        loginStep
                .authorization(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        dashboardStep
                .openNewProject("New project 1");
        testSuiteStep
                .createTestSuite("Test Suite 1", "New test suite");
        Assert.assertEquals(testSuitePage.getNameTestSuite(), "Test Suite 1");
    }

    @Test(description = "Add section on test suite", retryAnalyzer = Retry.class, groups = {"Smoke"})
    @Description("Add section on test suite")
    public void addSectionTestSuiteTest() {

        loginStep
                .authorization(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        dashboardStep
                .openNewProject("New project 1");
        testSuiteStep
                .addTestCase("Test Suite 1", "New test suite", "New section", "New section on test suite");
        // Assert.assertEquals(testSuitePage.getNumberSection(), "Contains 2 test suites, 0 active test runs and 0 active milestones");
    }

    @Test(description = "Add test case", retryAnalyzer = Retry.class, groups = {"Smoke"})
    @Description("Add test case")
    public void addTestCaseTest() {
        loginStep
                .authorization(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        dashboardStep
                .openNewProject("New project 1");
        testSuiteStep
                .createTestSuite("Test Suite 1", "New test suite");
        testSuiteStep
                .addNewTestCase();
        testCaseStep
                .addNewTestCase("New test case", "Other", "Low", "125 hours", "1", "None", "Added new test suite", "Add test suite", "Added test case");
        Assert.assertEquals(testCasePage.getTitleTestCase(), "New test case");
    }

    @Test(description = "Edit test case", retryAnalyzer = Retry.class, groups = {"Smoke"})
    @Description("Edit test case")
    public void editTestCaseTest() {
        loginStep
                .authorization(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        dashboardStep
                .openNewProject("New project 1");
        testSuiteStep
                .addNewTestCases("Test Suite 1", "New test suite");
        testCaseStep
                .addTestCase("Update test case", "Other", "Low", "125 hours", "1", "None", "Added new test suite", "Add test suite", "Added test case");
        testCaseStep
                .editTestCase("Update test case", "22 hours", "2", "Update new test suite", "Update test suite", "Update test case");
        Assert.assertEquals(testCasePage.getTitleTestCase(), "Update test case");
    }

    @Test(description = "Create test runs", retryAnalyzer = Retry.class, groups = {"Smoke"})
    @Description("Create test runs")
    public void createTestRun() {
        loginStep
                .authorization(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        dashboardStep
                .openNewProject("New project 1");
        testRunsStep
                .createTestRun("Run 1", "New test run", "New test run");
        Assert.assertEquals(testRunsPage.getNameTestRun(), "Run 1");
    }

    @Test(description = "Close test runs", retryAnalyzer = Retry.class, groups = {"Smoke"})
    @Description("Create test runs")
    public void closeTestRun() {
        loginStep
                .authorization(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        dashboardStep
                .openNewProject("New project 1");
        testRunsStep
                .closeTestRun("Run 1", "New test run", "New test run");
        Assert.assertEquals(testRunsPage.getValidationText(), "Successfully closed the test run.");
    }
}