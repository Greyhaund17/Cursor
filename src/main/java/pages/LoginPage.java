package pages;

import base.BasePage;
import org.openqa.selenium.By;
import util.ConfigLoader;

public class LoginPage extends BasePage {

    private static final By USERNAME_INPUT = By.xpath("//input[@placeholder='Username']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@placeholder='Password']");
    private static final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");

    public void open() {
        String baseUrl = ConfigLoader.getConfig().getBaseUrl();
        driver.get(baseUrl);
    }

    public void login(String username, String password) {
        type(USERNAME_INPUT, username);
        type(PASSWORD_INPUT, password);
        click(LOGIN_BUTTON);
    }
}

