package kietngo.SampleTest;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.windows.WindowsDriver;


public class Calculator {

    static WindowsDriver<WebElement> driver;

    @BeforeMethod
    public void startUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability("app", "C:\\Windows\\System32\\calc.exe");
        cap.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        cap.setCapability("platformName", "Windows");
        cap.setCapability("platformVersion", "1.0");
        driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723/"), cap);

    }

    @AfterMethod
    public void closeDown()
    {
        driver.quit();
    }
    
    @Test
    public void TestAddFunction() {
        driver.findElementByName("One").click();
        driver.findElementByName("Plus").click();
        driver.findElementByName("Two").click();
        driver.findElementByXPath("//Button[@Name='Equals']").click();

        String result = driver.findElementByAccessibilityId("CalculatorResults").getText().replace("Display is", "").trim();;
        Assert.assertEquals(result, "3", "Expected and actual is not correct");
    }

    @Test
    public void TestMultiplyFunction() {
        driver.findElementByName("One").click();
        driver.findElementByName("Multiply by").click();
        driver.findElementByName("Nine").click();
        driver.findElementByXPath("//Button[@Name='Equals']").click();

        String result = driver.findElementByAccessibilityId("CalculatorResults").getText().replace("Display is", "").trim();;
        Assert.assertEquals(result, "9", "Expected and actual is not correct");
    }
}
