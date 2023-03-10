package RahulShettyAcademy.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.ChceckoutPage;
import RahulShettyAcademy.pageobjects.ConformationPage;
import RahulShettyAcademy.pageobjects.ProductCatalogue;











public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void loginerrorvalidation() throws IOException
	{
	String productName="zara coat 3";
	LandingPage.loginApplicatio("disha72@yahoo.com", "lily71@LILY");
	Assert.assertEquals( "Login Successfully" , LandingPage.getErrorMessage());
	
	}
	@Test
	public void productErrorvalidation() throws IOException
	{
	String productName="zara coat 3";
	ProductCatalogue ProductCatalogue = LandingPage.loginApplicatio("disha72@yahoo.com", "lily71@LILY");
	ProductCatalogue.getProductList();
	ProductCatalogue.getProductByName(productName);
	ProductCatalogue.addProductToCart(productName);
	CartPage cartPage = ProductCatalogue.goToCartPage();
	
	Boolean match=cartPage.VerifyProductDisplay("zara coat 3");
	Assert.assertTrue(match);
	
	
	
	}
	
}


