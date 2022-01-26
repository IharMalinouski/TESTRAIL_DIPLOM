package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewProjectPage extends BasePage {

    public static final By INPUT_NAME = By.id("name");
    public static final By ANNOUNCEMENT_NAME = By.id("announcement");
    public static final By ADD_PROJECT_BUTTON = By.id("accept");
    public static final By CHECKBOX_ELEMENT = By.id("show_announcement");
    public static final String RADIO_BUTTONS = "//div[contains(@class,'add-project-row')]//descendant::strong[contains(text(),'%s')]";


    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидание загрузки элемента 'LOGIN_BUTTON'")
    public NewProjectPage waitIsNewProjectPageOpened() {
        waitForElementLocated(ADD_PROJECT_BUTTON, 20);
        return this;
    }

    @Step("Ввод 'name' в поле Name ")
    public NewProjectPage setNameProject(String name) {
        log.info("Ввод текста в поле 'INPUT_NAME':" + name);
        driver.findElement(INPUT_NAME).sendKeys(name);
        return this;
    }

    @Step("Ввод 'announcement' в поле Announcement")
    public NewProjectPage setAnnouncementOfProject(String Announcement) {
        log.info("Ввод текста в поле 'ANNOUNCEMENT_NAME':" + Announcement);
        driver.findElement(ANNOUNCEMENT_NAME).sendKeys(Announcement);
        return this;
    }

    @Step("Активация чек-бокса 'Show announcement'")
    public NewProjectPage activateCheckBox() {

        if (driver.findElement(CHECKBOX_ELEMENT).isSelected()) {
            log.info("Клик по чек-боксу");
            driver.findElement(CHECKBOX_ELEMENT).click();
        } else if (!driver.findElement(CHECKBOX_ELEMENT).isSelected()) {
            log.info("Клик по чек-боксу");
            driver.findElement(CHECKBOX_ELEMENT).click();
        }
        return this;
    }
    @Step("Выбор чек-бокса 'radioButton'")
    public NewProjectPage chooseRadioButton (String radioButton) {
        log.info("Выбор radio button c наименованием:" + radioButton);
        driver.findElement(By.xpath(String.format(RADIO_BUTTONS, radioButton))).click();
        return this;
    }

    @Step("Добавление нового проекта")
    public ProjectsPage clickAddProjectButton () {
        log.info("Добавление нового проекта");
        driver.findElement(ADD_PROJECT_BUTTON).click();
        return new ProjectsPage(driver);
    }
}
