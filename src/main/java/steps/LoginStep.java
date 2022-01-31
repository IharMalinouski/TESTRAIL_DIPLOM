package steps;

import org.openqa.selenium.WebDriver;

public class LoginStep extends BaseStep {
    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public void authorization(String email, String password) {
        loginPage
                .openPage()
                .waitIsAuthorizationPageOpened()
                .inputEmail(email)
                .inputPassword(password)
                .clickLogInBitton()
                .waitIsDashboardPageOpened();
    }
}
