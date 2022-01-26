package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DashboardPage extends BasePage {

    public static final By ADMINISTRATOR_ELEMENT = By.id("navigation-admin");
    public static final By ADD_PROJECT_BUTTON = By.id("sidebar-projects-add");
    
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage waitIsDashboardPageOpened() {
        waitForElementLocated(ADMINISTRATOR_ELEMENT, 20);
        return this;
    }

    @Step("Открытие формы создания нового проекта по кнопке 'ADD_PROJECT_BUTTON'")
    public NewProjectPage openPageNewProject(){
        driver.findElement(ADD_PROJECT_BUTTON).click();
        return new NewProjectPage(driver);
    }
}
