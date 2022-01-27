package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import modalsWindow.AddSectionModal;
import modalsWindow.DeleteModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.*;
import utilites.TestListener;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    LoginStep loginStep;
    DashboardPage dashboardPage;
    DashboardStep dashboardStep;
    NewProjectPage newProjectPage;
    ProjectsPage ProjectsPage;
    ProjectsStep projectsStep;
    CommonPage commonPage;
    CommonStep commonStep;
    ProjectPage projectPage;
    ProjectStep projectStep;
    DeleteModal deleteModal;
    ModalStep modalStep;
    TestSuitePage testSuitePage;
    TestSuiteStep testSuiteStep;
    AddSectionModal addSectionModal;
    TestCaseStep testCaseStep;
    TestCasePage testCasePage;


    @BeforeMethod
    public void initTest(ITestContext context) {
        if (System.getProperty("browser") != null) {
            if (System.getProperty("browser").equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (System.getProperty("browser").equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        log.debug("Browser is started in fullscreen mode.");
        driver.manage().window().maximize();
        String driverVariable = "driver";
        context.setAttribute(driverVariable, driver);
        loginPage = new LoginPage(driver);
        loginStep = new LoginStep(driver);
        dashboardPage = new DashboardPage(driver);
        dashboardStep = new DashboardStep(driver);
        newProjectPage = new NewProjectPage(driver);
        ProjectsPage = new ProjectsPage(driver);
        commonPage = new CommonPage(driver);
        commonStep = new CommonStep(driver);
        projectPage = new ProjectPage(driver);
        projectStep = new ProjectStep(driver);
        projectsStep = new ProjectsStep(driver);
        deleteModal = new DeleteModal(driver);
        modalStep = new ModalStep(driver);
        testSuitePage = new TestSuitePage(driver);
        testSuiteStep = new TestSuiteStep(driver);
        addSectionModal = new AddSectionModal(driver);
        testSuiteStep = new TestSuiteStep(driver);
        testCasePage = new TestCasePage(driver);
        testCaseStep = new TestCaseStep(driver);
    }

    @AfterMethod
    public void close() {
        log.info("Close browser");
        if (driver != null) {
            driver.quit();
        }
    }
}
