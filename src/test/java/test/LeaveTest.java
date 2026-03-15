package test;

import org.testng.annotations.Test;
import pages.LeavePage;

public class LeaveTest extends BaseTest {

    @Test
    public void openLeavePageAfterLogin() {
        loginAsDefaultUser();

        LeavePage leavePage = new LeavePage();
        leavePage.openLeavePage();


    }
}


