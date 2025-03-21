package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    //declaration
	@FindBy(xpath = "//h1[text()='Shopping cart']/../..//img")
	private WebElement smartPhoneCartProduct;

	@FindBy(xpath = "//h1[text()='Shopping cart']/../..//img[@alt='Picture of Smartphone']/../..//input[@type='checkbox']")
	private WebElement smartPhoneRemoveCartButton;

	@FindBy(xpath = "//input[@value='Update shopping cart']")
	private WebElement updateShoppingCartButton;

	@FindBy(xpath = "//input[@value='Continue shopping']")
	private WebElement continueShoppingButton;

	@FindBy(id = "termsofservice")
	private WebElement termsOfServiceCheckBox;

	@FindBy(id = "checkout")
	private WebElement checkOutButton;

	// initialization
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getContinueShoppingButton() {
		return continueShoppingButton;
	}

	public WebElement getTermsOfServiceCheckBox() {
		return termsOfServiceCheckBox;
	}

	public WebElement getCheckOutButton() {
		return checkOutButton;
	}

	public WebElement getSmartPhoneCartProduct() {
		return smartPhoneCartProduct;
	}

	public WebElement getSmartPhoneRemoveCartButton() {
		return smartPhoneRemoveCartButton;
	}

	public WebElement getUpdateShoppingCartButton() {
		return updateShoppingCartButton;
	}

}
