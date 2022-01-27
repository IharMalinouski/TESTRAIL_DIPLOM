package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ModalStep extends BaseStep {
    public ModalStep(WebDriver driver) {
        super(driver);
    }

    @Step("Delete project")
    public void deleteNewProject() {
        deleteModal
                .isModalOpened()
                .activateCheckbox()
                .clickButtonOk();
    }
}
