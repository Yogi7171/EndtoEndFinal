package RahulShettyAcademy.stepDefination;

import java.io.IOException;

import org.testng.Assert;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.ChceckoutPage;
import RahulShettyAcademy.pageobjects.ConformationPage;
import RahulShettyAcademy.pageobjects.LandingPage;
import RahulShettyAcademy.pageobjects.ProductCatalogue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalogue ProductCatalogue;
	public ConformationPage confirmationPage;


@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage=launchApplication();
	}
	
	@Given ("^Logged in with username(.+) and password(.+)$")
	public void logged_in_username_and_password(String username,String password)
	{
		 ProductCatalogue = LandingPage.loginApplicatio(username,password);
	}
	
	@When ("^I add product(.+)from cart$")
	public void I_add_product_from_cart(String productName)
	{
		ProductCatalogue.getProductList();
		ProductCatalogue.getProductByName(productName);
		ProductCatalogue.addProductToCart(productName);
	}
	 @When ("^Checkout(.+)and submit the order$")
	 public void Checkout_and_submit_the_order(String productName)
	 {
		 	CartPage cartPage = ProductCatalogue.goToCartPage();
			
			Boolean match=cartPage.VerifyProductDisplay(productName);
			Assert.assertTrue(match);
			ChceckoutPage checkoutPage = cartPage.goToCheckout();
			checkoutPage.selectCountry("India");
			confirmationPage = checkoutPage.submitorder();
	 }
	
	@Then("{string} message is displayed on ConfirmationPage")
	 public void message_is_displayed_on_ConfirmationPage(String string)
	 {
		String confirmationMessage=confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase(string));
	 }
	@Then("{string} message is displayed ")
	 public void message_is_displayed(String string)
	 {
		Assert.assertEquals( "Login Successfully" , LandingPage.getErrorMessage());
		driver.close();
	 }
}
