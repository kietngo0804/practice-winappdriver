package kietngo.UFS.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;

public class BasePage {

    WindowsDriver<WebElement> driver;

	public BasePage(WindowsDriver<WebElement> driver) {
		this.driver=driver;
	}

    public void clickButtonByName(String buttonName) {
    	WebElement buttonElement = driver.findElementByName(buttonName);
        buttonElement.click();
    }
	
	public void clickButtonByAccessibilityId(String id) {
    	WebElement buttonElement = driver.findElementByAccessibilityId(id);
        buttonElement.click();
    }

    public void clickButtonByXPath(String buttonXpath) {
    	WebElement buttonElement = driver.findElementByXPath(buttonXpath);
        buttonElement.click();
    }
	
	public void inputTextByName(String ele_name, String text_value) {
    	WebElement ele = driver.findElementByName(ele_name);
        ele.sendKeys(text_value);
    }
	
    public void inputTextByXPath(String ele_xpath, String text_value) {
    	WebElement ele = driver.findElementByXPath(ele_xpath);
        ele.sendKeys(text_value);
    }

	public void clearText(String ele_name) {
    	WebElement ele = driver.findElementByName(ele_name);
        ele.clear();
    }
	
	public String getAttribute(String ele_name, String text_value) {
    	WebElement ele = driver.findElementByName(ele_name);
        String val = ele.getAttribute(text_value);
        return val;
    }

    public void verifyElementIsVisibleByXPath(String locator) {
        if(driver.findElementByXPath(locator).isDisplayed()){
            System.out.println("Element is Visible");
        } else {
            System.out.println("Element is Invisible");
        }
    }
}
