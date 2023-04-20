package kietngo.UFS.pages;
import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;
import kietngo.UFS.testdata.*;

public class AirCustomerWaybillPage extends BasePage{

    public AirCustomerWaybillPage(WindowsDriver<WebElement> driver) {
        super(driver);
    }

    UFSWorkspace ufs = new UFSWorkspace();

    public void GoToAirCustomerWaybillPage() {
        this.doubleClickButtonByXPath(ufs.TXT_AIRCUSTOMER);
    }
}
