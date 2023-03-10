package RahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	 By products1=By.cssSelector(".mb-3");
	 
	 @FindBy(css=".card-body button:last-of-type")
	 WebElement addProductToCart1;
	 
	 @FindBy(css=".ng-animating")
	 WebElement spinner;
	 
	By toastMessage=By.cssSelector("#toast-container");
	 
	
	public List<WebElement> getProductList()
	{
		waitForElementToapper(products1);
		return products;
	}
	
	public  WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).
				getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String productName )
	{
		addProductToCart1.click();
		waitForElementToapper(toastMessage);
		waitForElementToDisappear(spinner);
	}
	        
}



		