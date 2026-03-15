package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import util.PasswordUtils;

public class LoginTest extends test.BaseTest {

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();

        String decodedPassword = PasswordUtils.decode(getConfig().getPassword());
        loginPage.login(getConfig().getUsername(), decodedPassword);

        String currentUrl = getDriver().getCurrentUrl();
        String expectedUrl = getConfig().getBaseUrl() + "web/index.php/dashboard/index";
        Assert.assertEquals(currentUrl, expectedUrl, "Unexpected dashboard URL after login");
    }
}

