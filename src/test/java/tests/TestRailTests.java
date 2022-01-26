package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilites.Retry;

@Log4j2
public class TestRailTests extends BaseTest {

    @Test(description = "Создание новго проекта c Use multiple test suites to manage cases", retryAnalyzer = Retry.class)
    @Description("Создание нового проекта из Dashboard")
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

    @Test(description = "", retryAnalyzer = Retry.class)
    @Description("Открытие нового проекта")
    public void openNewProject(){
        loginStep
                .authorization();
        projectsStep
                .openNewProject();
    }

    @Test(description = "Delete project", retryAnalyzer = Retry.class)
    @Description("Delete project")
    public void deleteNewProject(){
        loginStep
                .authorization();
        projectsStep
                .deleteNewProject();
//        deleteModal
//                .isModalOpened()
//                .activateCheckbox()
//                .clickButtonOk();


    }


//    @Test(description = "Создание новго проекта c Use a single repository with baseline support", retryAnalyzer = Retry.class)
//    @Description("Создание нового проекта из Dashboard")
//    public void createSecondNewProjectTest() {
//        dashboardPage
//                .openPageNewProject()
//                .waitIsNewProjectPageOpened()
//                .setNameProject("New project 2")
//                .setAnnouncementOfProject("New project 2")
//                .activateCheckBox()
//                .chooseRadioButton("Use a single repository with baseline support")
//                .clickAddProjectButton();
//        Assert.assertEquals(scopeProjectsPage.getNameProject(), "New project 2");
//        commonPage
//                .openDropDawnLogout()
//                .clickLogoutButton();
//    }

}