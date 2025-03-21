package pomPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import genericLibrary.FileLibrary;
import genericLibrary.SelectUtility;

public class CheckOutPage extends BaseTest {
	@FindBy(xpath = "//select[@name='BillingNewAddress.CountryId']")
	private WebElement countryDropDown;
	@FindBy(xpath = "//input[@name='BillingNewAddress.City']")
	private WebElement cityTB;
	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement address1TB;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement pincodeTB;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phonenoTB;
	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	private WebElement billingAddressContinueButton;
	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	private WebElement shippingAddressContinueButton;
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	private WebElement shippingMethodContinueButton;
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	private WebElement paymentMethodContinueButton;
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
	private WebElement paymentInformationContinueButton;
	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
	private WebElement confirmOrderButton;
	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")
	private WebElement orderProcessText;
	@FindBy(id = "billing-address-select")
	private WebElement billingAddressDropdown;
	
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getCountryDropDown() {
		return countryDropDown;
	}

	public WebElement getCityTB() {
		return cityTB;
	}

	public WebElement getAddress1TB() {
		return address1TB;
	}

	public WebElement getPincodeTB() {
		return pincodeTB;
	}

	public WebElement getPhonenoTB() {
		return phonenoTB;
	}

	public WebElement getBillingAddressContinueButton() {
		return billingAddressContinueButton;
	}

	public WebElement getShippingAddressContinueButton() {
		return shippingAddressContinueButton;
	}

	public WebElement getShippingMethodContinueButton() {
		return shippingMethodContinueButton;
	}

	public WebElement getPaymentMethodContinueButton() {
		return paymentMethodContinueButton;
	}

	public WebElement getPaymentInformationContinueButton() {
		return paymentInformationContinueButton;
	}

	public WebElement getConfirmOrderButton() {
		return confirmOrderButton;
	}

	public WebElement getOrderProcessText() {
		return orderProcessText;
	}

	public WebElement getBillingAddressDropdown() {
		return billingAddressDropdown;
	}
	
	public void buyProduct() throws EncryptedDocumentException, IOException {
		SelectUtility su = new SelectUtility();
		try {
			if (billingAddressDropdown.isDisplayed()==true) {
				su.selectByVisibleTextMethod(billingAddressDropdown, "New Address");
			}
		}
		catch(Exception e) {
			su.selectByVisibleTextMethod(countryDropDown, "India");
		}
		su.selectByVisibleTextMethod(countryDropDown, "India");
		
		FileLibrary flib = new FileLibrary();
		int rn = flib.randomNumber();
		String city = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 0);
		String address1 = flib.readExcelData(EXCEL_PATH_MAIN, "buyproductdetails", 1, 1);
		long pin = flib.readExcelData1(EXCEL_PATH_MAIN, "buyproductdetails", 1,2);
		long phone = flib.readExcelData1(EXCEL_PATH_MAIN, "buyproductdetails", 1, 3);
		String phoneNo = phone+""+rn;
		cityTB.sendKeys(city);
		address1TB.sendKeys(address1);
		pincodeTB.sendKeys(String.valueOf(pin));
		phonenoTB.sendKeys(String.valueOf(phone));
		billingAddressContinueButton.click();
		shippingAddressContinueButton.click();
		shippingMethodContinueButton.click();
		paymentMethodContinueButton.click();
		paymentInformationContinueButton.click();
		confirmOrderButton.click();
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(orderProcessText.isDisplayed(), true,"order is not placed!");
		sa.assertAll();
	}

}
