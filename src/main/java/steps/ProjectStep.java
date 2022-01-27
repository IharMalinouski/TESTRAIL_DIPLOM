package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ProjectStep extends BaseStep {
    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    @Step("Get project name")
    public void getProjectName() {
        projectPage
                .waitIsAuthorizationPageOpened()
                .getNameProject();
    }
}
