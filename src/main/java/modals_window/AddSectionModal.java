package modals_window;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.TestSuitePage;

@Log4j2
public class AddSectionModal extends BaseModal {

    public static final By ADD_SECTION_BUTTON = By.id("editSectionSubmit");
    public static final By NAME_FIELD = By.id("editSectionName");
    public static final By DESCRIPTION_FIELD = By.id("editSectionDescription_display");

    public AddSectionModal(WebDriver driver) {
        super(driver);
    }

    public AddSectionModal waitForModalOpened() {
        waitForElementLocated(ADD_SECTION_BUTTON, 20);
        return this;
    }

    @Step("Set '{nameModal}' into field Name")
    public AddSectionModal setNameSection(String nameModal) {
        log.info("Set '{nameModal}': " + nameModal);
        driver.findElement(NAME_FIELD).sendKeys(nameModal);
        return this;
    }

    @Step("Set '{descriptionModal}' into field descriptionModal")
    public AddSectionModal setDescriptionSection(String descriptionModal) {
        log.info("Set '{descriptionModal}': " + descriptionModal);
        driver.findElement(DESCRIPTION_FIELD).sendKeys(descriptionModal);
        return this;
    }

    @Step("Click add new section button")
    public TestSuitePage clickAddTestSuiteButton() {
        log.info("Click add new section button");
        driver.findElement(ADD_SECTION_BUTTON).click();
        return new TestSuitePage(driver);
    }
}
