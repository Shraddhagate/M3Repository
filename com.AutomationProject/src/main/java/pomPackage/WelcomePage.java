package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	//declaration
	@FindBy(linkText= "Register")private WebElement registerLink;
	@FindBy(linkText= "Log in")private WebElement loginLink;
	@FindBy(xpath="//span[text()='Shopping cart']")private WebElement shoppingCartLink;
	@FindBy(xpath="//span[text()='Wishlist']")private WebElement wishlistLink;
	@FindBy(partialLinkText= "BOOKS")private WebElement booksLink;
	@FindBy(linkText= "COMPUTERS")private WebElement computerLink;
	@FindBy(partialLinkText="ELECTRONICS")private WebElement electronicsLink;
	@FindBy(linkText= "Log out")private WebElement logoutLink;
	
	//initialization
	public WelcomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getRegisterLink() {
		return registerLink;
	}
	public WebElement getLoginLink() {
		return loginLink;
	}
	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}
	public WebElement getWishlistLink() {
		return wishlistLink;
	}
	public WebElement getBooksLink() {
		return booksLink;
	}
	public WebElement getComputerLink() {
		return computerLink;
	}
	public WebElement getElectronicsLink() {
		return electronicsLink;
     }
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public void logOut() 
	{
		logoutLink.click();
	}
}
