package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DashboardStep extends BaseStep {
    public DashboardStep(WebDriver driver) {
        super(driver);
    }

    public DashboardStep openNewProject(String name) {
        dashboardPage
                .waitIsDashboardPageOpened()
                .clickNameProject(name);
        return this;
    }
}
