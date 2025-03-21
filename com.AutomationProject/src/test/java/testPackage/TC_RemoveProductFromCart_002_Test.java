package testPackage;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import pomPackage.ElectronicsPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;

@Listeners(genericLibrary.MyListener.class)

public class TC_RemoveProductFromCart_002_Test extends BaseTest {
  @Test
  public void removeProductFromCart() {
	  WelcomePage wp = new WelcomePage(driver);
		wp.getElectronicsLink().click();
		ElectronicsPage ep= new ElectronicsPage(driver);
		ep.getCellPhoneLink().click();
		ep.getSmartPhoneAddToCartButtonLink().click();
		wp.getShoppingCartLink().click();
		
		ShoppingCartPage sp = new ShoppingCartPage(driver);
		sp.getSmartPhoneRemoveCartButton().click();
		sp.getUpdateShoppingCartButton().click();
		 
		SoftAssert sa = new SoftAssert();
		try {
		sa.assertEquals(sp.getSmartPhoneCartProduct().isDisplayed(), false , "product is not removed from cart");
		}
		catch(Exception e){
			Reporter.log("product is removed from cart", true);
		}
		sa.assertAll();
		
	}
}
