package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilites.PropertyReader;

@Log4j2
public class LoginPage extends BasePage {

    public static final By EMAIL_INPUT = By.id("name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("button_primary");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening a browser via a link 'BASE_URL'")
    public LoginPage openPage() {
        driver.get(System.getenv().getOrDefault("url", PropertyReader.getProperty("url")));
        return this;
    }

    @Step("Waiting for an element to load '{LOGIN_BUTTON}'")
    public LoginPage waitIsAuthorizationPageOpened() {
        waitForElementLocated(LOGIN_BUTTON, 20);
        return this;
    }

    @Step("Input '{email}'")
    public LoginPage inputEmail(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        return this;
    }

    @Step("Input '{password}'")
    public LoginPage inputPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    @Step("Click button 'LogIn'")
    public DashboardPage clickLogInBitton(){
        driver.findElement(LOGIN_BUTTON).click();
        return new DashboardPage(driver);
    }
}
