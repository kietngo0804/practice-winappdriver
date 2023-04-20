package kietngo.UFS.tests;

import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.windows.WindowsDriver;
import kietngo.UFS.pages.*;

public class CustomerWaybill {

    WindowsDriver<WebElement> driver;
    LoginPage login;
    AirCustomerWaybillPage airCustomerWaybillPage;

    @BeforeSuite
    public void startUp() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", "D:\\Users\\kngotuan\\Downloads\\UFS.7.01.034e.US.001.PBBuild\\ufs.exe");

        try {
			driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        login = new LoginPage(driver);
        airCustomerWaybillPage = new AirCustomerWaybillPage(driver);
    }

    @BeforeMethod
    public void Login() throws InterruptedException {

        login.inputLoginData("dev_kcr1", "password1", "EN", "UFS_Migration_AMDV");
        login.clickButtonByName("OK");
        Thread.sleep(18000);
        
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    @AfterMethod
    public void closeDown()
    {
        driver.quit();
    }
    
    @Test
    public void MakeCustomerWaybill() {

        airCustomerWaybillPage.GoToAirCustomerWaybillPage();

    }
}
