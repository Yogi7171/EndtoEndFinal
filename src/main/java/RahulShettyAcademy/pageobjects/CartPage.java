package RahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent 
	{

		

		@FindBy(css=".totalRow button")
		WebElement checkoutEle;
		
		@FindBy(css=".cartSection h3")
		List<WebElement> productsTitles;
		
		public CartPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		public Boolean VerifyProductDisplay(String productName) {
			boolean match = productsTitles.stream().anyMatch(cartProduct->cartProduct.getText().
					equalsIgnoreCase(productName));
			return match;
		}
		
		public ChceckoutPage goToCheckout() {
			checkoutEle.click();
			return new ChceckoutPage(driver);
		}
	}



//driver.findElement(By.cssSelector(".totalRow button")).click();

