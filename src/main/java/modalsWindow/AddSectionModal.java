package modalsWindow;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.TestSuitePage;

@Log4j2
public class AddSectionModal extends BaseModal {

    public static final By ADD_SECTION_BUTTON = By.id("editSectionSubmit");
    public static final By NAME_FIELD = By.id("editSectionName");
    public static final By DESCRIPTION_FIELD = By.id("editSectionDescription_display");

    public AddSectionModal(WebDriver driver) {
        super(driver);
    }

    public AddSectionModal isModalOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_SECTION_BUTTON));
        return this;
    }

    @Step("Set '{name}' into field Name")
    public AddSectionModal setNameSection(String name) {
        log.info("Set '{name}': " + name);
        driver.findElement(NAME_FIELD).sendKeys(name);
        return this;
    }

    @Step("Set '{Description}' into field Description")
    public AddSectionModal setDescriptionSection(String Description) {
        log.info("Set '{Description}': " + Description);
        driver.findElement(DESCRIPTION_FIELD).sendKeys(Description);
        return this;
    }

    @Step("Click add new section button")
    public TestSuitePage clickAddTestSuiteButton() {
        log.info("Click add new section button");
        driver.findElement(ADD_SECTION_BUTTON).click();
        return new TestSuitePage(driver);
    }
}
