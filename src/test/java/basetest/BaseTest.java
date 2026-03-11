package test;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import util.Config;
import util.ConfigLoader;

public abstract class BaseTest {

    protected WebDriver driver;
    protected Config config;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(@Optional("") String browserFromTestNg) {
        config = ConfigLoader.getConfig();

        String browserToUse = (browserFromTestNg == null || browserFromTestNg.isBlank())
                ? config.getBrowser()
                : browserFromTestNg;

        DriverFactory.initDriver(browserToUse);
        driver = DriverFactory.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected Config getConfig() {
        return config;
    }
}

