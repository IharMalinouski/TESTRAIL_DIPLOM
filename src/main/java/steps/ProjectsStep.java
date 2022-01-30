package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProjectsStep extends BaseStep {
    public ProjectsStep(WebDriver driver) {
        super(driver);
    }

    @Step("Opening a new project")
    public void openNewProject() {
        projectsPage
                .openPage()
                .waitIsProjectsPageOpened()
                .clickDasboardTab();
    }

    @Step("Delete project")
    public void deleteNewProject(String nameProject) {
        projectsPage
                .openPage()
                .waitIsProjectsPageOpened()
                .clickDelete(nameProject);
    }
}
