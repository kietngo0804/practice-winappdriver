package kietngo.UFS.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;
import kietngo.UFS.testdata.*;

public class LoginPage extends BasePage{

    public LoginPage(WindowsDriver<WebElement> driver) {
        super(driver);
    }

    Login login = new Login();
    UFSWorkspace ufs = new UFSWorkspace();

    //Methods
    public void inputLoginData(String userID, String password, String language, String server) {
        
        this.inputTextByXPath(login.TXT_USERID, userID);
        this.inputTextByXPath(login.TXT_PASSWORD, password);
        this.inputTextByXPath(login.CBO_LANGUAGE, language);
        this.inputTextByXPath(login.TXT_SERVER, server);
	}

	public void clickOKButton() {
		this.clickButtonByName(login.BTN_OK);
	}

    public void verifyLoginSuccessfully() {
        this.verifyElementIsVisibleByXPath(ufs.TXT_AIRCUSTOMER);
    }

}
