package steps;

import org.openqa.selenium.WebDriver;
import utilites.PropertyReader;

public class LoginStep extends BaseStep {
    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public void authorization() {
        loginPage
                .openPage()
                .waitIsAuthorizationPageOpened()
                .inputEmail(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")))
                .inputPassword(System.getenv().getOrDefault("password", PropertyReader.getProperty("password")))
                .clickLogInBitton()
                .waitIsDashboardPageOpened();
    }

}
