package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage {
	//declaration
	@FindBy(partialLinkText= "Cell phones")private WebElement cellPhoneLink;
	@FindBy(xpath="//a[text()='Smartphone']/../..//input[@value='Add to cart']") private WebElement smartPhoneAddToCartButtonLink;
	
	//initialization
	public ElectronicsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public WebElement getCellPhoneLink() {
		return cellPhoneLink;
	}
	public WebElement getSmartPhoneAddToCartButtonLink() {
		return smartPhoneAddToCartButtonLink;
	}
	

}
