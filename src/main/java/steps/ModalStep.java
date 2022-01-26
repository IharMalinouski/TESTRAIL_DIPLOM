package steps;

import org.openqa.selenium.WebDriver;

public class ModalStep extends BaseStep {
    public ModalStep(WebDriver driver) {
        super(driver);
    }

    public void deleteNewProject() {
        deleteModal
                .isModalOpened()
                .activateCheckbox()
                .clickButtonOk();
    }
}
