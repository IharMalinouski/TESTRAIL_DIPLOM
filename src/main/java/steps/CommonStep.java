package steps;

import org.openqa.selenium.WebDriver;

public class CommonStep extends BaseStep {
    public CommonStep(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        commonPage
                .openDropDawnLogout()
                .clickLogoutButton();
    }
}
