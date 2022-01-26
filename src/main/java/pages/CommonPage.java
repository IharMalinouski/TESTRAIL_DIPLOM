package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage extends BasePage{
    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public static final By NAVIGATOR_USER = By.id("navigation-user");
    public static final By LOGOUT_USER = By.id("navigation-user-logout");

    @Step("opening dropdown list LOGOUT ")
    public CommonPage openDropDawnLogout(){
        driver.findElement(NAVIGATOR_USER).click();
        return this;
    }

    @Step("Click on LOGOUT")
    public CommonPage clickLogoutButton(){
        driver.findElement(LOGOUT_USER).click();
        return this;
    }
}
