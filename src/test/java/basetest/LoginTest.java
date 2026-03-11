package basetest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends test.BaseTest {

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(getConfig().getUsername(), getConfig().getPassword());

        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl = getConfig().getBaseUrl() + "web/index.php/dashboard/index";
        Assert.assertEquals(currentUrl, expectedUrl, "Unexpected dashboard URL after login");
    }
}

