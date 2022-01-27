package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilites.Retry;

@Log4j2
public class TestRailTests extends BaseTest {

    @Test(description = "Creating a new project with value 'Use multiple test suites to manage cases'", retryAnalyzer = Retry.class)
    @Description("Create a new project from Dashboard")
    public void createFirstNewProjectTest() {
        loginStep
                .authorization();
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

    @Test(description = "Delete project", retryAnalyzer = Retry.class)
    @Description("Delete project")
    public void deleteNewProjectTest() {
        loginStep
                .authorization();
        projectsStep
                .deleteNewProject();
        modalStep
                .deleteNewProject();
    }

    @Test(description = "Open project", retryAnalyzer = Retry.class)
    @Description("Open project")
    public void openNewProjectOnProjectPageTest() {
        loginStep
                .authorization();
        dashboardStep
                .openNewProject();
        Assert.assertEquals(projectPage.getNameProject(), "New project 1");
    }

    @Test(description = "Create test suite", retryAnalyzer = Retry.class)
    @Description("Create test suite")
    public void createTestSuiteTest() {
        loginStep
                .authorization();
        dashboardStep
                .openNewProject();
        testSuiteStep
                .createTestSuite();
        Assert.assertEquals(testSuitePage.getNameTestSuite(), "Test Suite 1");
    }

    @Test(description = "Add section on test suite", retryAnalyzer = Retry.class)
    @Description("Add section on test suite")
    public void addSectionTestSuiteTest() {
        loginStep
                .authorization();
        dashboardStep
                .openNewProject();
        testSuiteStep
                .addTestCase();
        Assert.assertEquals(testSuitePage.getNameSection(), "1111111");
    }

    @Test(description = "Add test case", retryAnalyzer = Retry.class)
    @Description("Add test case")
    public void addTestCaseTest() {
        loginStep
                .authorization();
        dashboardStep
                .openNewProject();
        testSuiteStep
                .createTestSuite();
        testSuiteStep
                .addNewTestCase();
        testCaseStep
                .addNewTestCase();
        Assert.assertEquals(testCasePage.getTitleTestCase(), "New test case");
    }

    @Test(description = "Edit test case", retryAnalyzer = Retry.class)
    @Description("Add test case")
    public void editTestCaseTest() {
        loginStep
                .authorization();
        dashboardStep
                .openNewProject();
        testSuiteStep
                .addNewTestCases();
        testCaseStep
                .addTestCase();
        testCaseStep
                .editTestCase();
        Assert.assertEquals(testCasePage.getTitleTestCase(), "Update test case");
    }
}