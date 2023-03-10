package RahulShettyAcademy.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.ChceckoutPage;
import RahulShettyAcademy.pageobjects.ConformationPage;
import RahulShettyAcademy.pageobjects.OrderPage2;
import RahulShettyAcademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	String productName="zara coat 3";
	@Test(dataProvider="getdata",groups= {"purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException
	{
	
	ProductCatalogue ProductCatalogue = LandingPage.loginApplicatio(input.get("email"), input.get("password"));
	ProductCatalogue.getProductList();
	ProductCatalogue.getProductByName(input.get("productName"));
	ProductCatalogue.addProductToCart(input.get("productName"));
	CartPage cartPage = ProductCatalogue.goToCartPage();
	
	Boolean match=cartPage.VerifyProductDisplay(input.get("product"));
	Assert.assertTrue(match);
	ChceckoutPage checkoutPage = cartPage.goToCheckout();
	checkoutPage.selectCountry("India");
	ConformationPage confirmationPage = checkoutPage.submitorder();
	String confirmationMessage=confirmationPage.getConfirmationMessage();
	Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
	}
	
	//To verify ZARA COAT 3 is displaying in orders page
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest()
	{
		//ZARA COAT 3
		ProductCatalogue ProductCatalogue = LandingPage.loginApplicatio("disha72@yahoo.com", "lily71@LILY");
		OrderPage2 OrderPage2 = ProductCatalogue.goToOrderPage();
		Assert.assertFalse(OrderPage2.VerifyOrderDisplay(("productName")));
		
	}
	
	
	//Extent Reports -
	
	@DataProvider
	public Object[][] getdata() throws IOException 
	{
		
		
		
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//RahulShettyAcademy//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	//@DataProvider
	//public Object[][] getData()
	//{
	//	return return new Object[][] {{"disha72@yahoo.com","lily71@LILY","zara coat 3"},{"anshika@gmail.com","Iamking@000","zara coat 3"}};
	//}
	
	//HashMap<String,String> map=new HashMap<String,String>();
			//map.put("email", "disha72@yahoo.com");
			//map.put("password", "lily71@LILY");
			//map.put("productName", "zara coat 3");
			
			//HashMap<String,String> map2=new HashMap<String,String>();
			
			//map2.put("email", "anshika@gmail.com");
			//map2.put("password", "Iamking@000");
			//map2.put("productName", "zara coat 3");
	
}
