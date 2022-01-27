package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CommonStep extends BaseStep {
    public CommonStep(WebDriver driver) {
        super(driver);
    }

    @Step("logout")
    public void logout() {
        commonPage
                .openDropDawnLogout()
                .clickLogoutButton();
    }
}
