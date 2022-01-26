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

    @Test(description = "Open new project", retryAnalyzer = Retry.class)
    @Description("Open new project")
    public void openNewProject() {
        loginStep
                .authorization();
        projectsStep
                .openNewProject();
    }

    @Test(description = "Delete project", retryAnalyzer = Retry.class)
    @Description("Delete project")
    public void deleteNewProject() {
        loginStep
                .authorization();
        projectsStep
                .deleteNewProject();
        deleteModal
                .isModalOpened()
                .activateCheckbox()
                .clickButtonOk();


    }


}