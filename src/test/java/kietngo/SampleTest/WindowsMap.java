package kietngo.SampleTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.windows.WindowsDriver;

public class WindowsMap {

	static WindowsDriver<WebElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
        DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability("app", "C:\\Windows\\System32\\calc.exe");
        cap.setCapability("app", "Microsoft.WindowsMaps_8wekyb3d8bbwe!App");
        cap.setCapability("platformName", "Windows");
        cap.setCapability("platformVersion", "1.0");
        
        driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723/"), cap);
        Search("England");
        
        Thread.sleep(5000);
        driver.quit();
        
	}
	
	public static void Search(String CountryName) {
        driver.findElementByAccessibilityId("TextBox").sendKeys(CountryName);
        driver.findElementByAccessibilityId("TextBox").sendKeys(Keys.ENTER);
	}
}
