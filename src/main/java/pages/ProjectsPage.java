package pages;

import io.qameta.allure.Step;
import modalsWindow.DeleteModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilites.PropertyReader;

public class ProjectsPage extends BasePage {

    public static final String PROJECTS_URI = "index.php?/admin/projects/overview";
    public static final By ADD_PROJECT_BUTTON = By.xpath("//a[contains(text(), 'Add Project')]");
    public static final String PROJECTS_NAME = "//*[contains(@class, 'action')]/ancestor::*/td/a";
    public static final By RETURN_DASHBOARD = By.id("navigation-dashboard");
    public static final String DELETE_ICON = "//a[contains(text(),'%s')]/ancestor::tr//div[contains(@class,'icon-small-delete')]";
    public static final String EDIT_ICON = "//a[contains(text(),'%s')]/ancestor::tr//div[contains(@class,'icon-small-edit')]";

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public String getNameProject() {
        return driver.findElements(By.xpath(PROJECTS_NAME)).get(0).getText();
    }

    public ProjectsPage openProjectsPage() {
        driver.get(System.getenv().getOrDefault("url", PropertyReader.getProperty("url")) + PROJECTS_URI);
        return this;
    }

    @Step("Waiting for an element to load '{LOGIN_BUTTON}'")
    public ProjectsPage waitIsProjectsPageOpened() {
        waitForElementLocated(ADD_PROJECT_BUTTON, 20);
        return this;
    }

    @Step("Click project '{nameProject}'")
    public ProjectPage openProjectPage(String nameProject) {
        driver.findElement(By.xpath(String.format(PROJECTS_NAME, nameProject))).click();
        return new ProjectPage(driver);
    }

    @Step("Click return dashboard")
    public DashboardPage clickDasboardTab() {
        driver.findElement(RETURN_DASHBOARD).click();
        return new DashboardPage(driver);
    }

    @Step("Click icon delete project '{nameProject}'")
    public DeleteModal clickDelete(String nameProject) {
        driver.findElement(By.xpath(String.format(DELETE_ICON, nameProject))).click();
        return new DeleteModal(driver);
    }

    @Step("Click icon edit project '{name}'")
    public NewProjectPage clickEdit(String name) {
        driver.findElement(By.xpath(String.format(EDIT_ICON, name))).click();
        return new NewProjectPage(driver);
    }
}
