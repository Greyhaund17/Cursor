package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class LeavePage extends BasePage {

    private static final By LEAVE_MENU = By.xpath("//button[contains(@title,'Assign')]");
   // private static final By APPLY_MENU = By.xpath("//a[contains(@href,'applyLeave')]");

    public void openLeavePage() {
        click(LEAVE_MENU);
   //     click(APPLY_MENU);
    }
}


