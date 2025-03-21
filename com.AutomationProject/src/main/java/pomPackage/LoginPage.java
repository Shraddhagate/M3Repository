package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//declaration
	@FindBy(id="Email")private WebElement emailTb;
	@FindBy(id="Password")private WebElement passwordTb;
	@FindBy(xpath ="//input[@value='Log in']")private WebElement loginButton;
	@FindBy(id="RememberMe")private WebElement rememberMeCheckbox;
	@FindBy(linkText= "Forgot Password")private WebElement forgotPasswordLink;
	
	//initialization
	public LoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getEmailTb() {
		return emailTb;
	}
	public WebElement getPassword() {
		return passwordTb;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getRememberMeCheckbox() {
		return rememberMeCheckbox;
	}
	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}
	
	//Operational method or business logic
	public void validLoginMethod(String email , String password) {
		emailTb.sendKeys(email);
		passwordTb.sendKeys(password);
	    loginButton.click();
	}
	
	
	public void invalidLoginMethod(String email, String password) throws InterruptedException {
		emailTb.sendKeys(email);
		passwordTb.sendKeys(password);
	    loginButton.click();
	    Thread.sleep(1000);
	    emailTb.clear();
	    passwordTb.clear();
		
		
	}
	
	
	

}
