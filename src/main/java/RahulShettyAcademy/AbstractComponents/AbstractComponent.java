package RahulShettyAcademy.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.OrderPage2;

public class AbstractComponent {

	protected WebDriver driver;

	
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".btn.btn-custom[routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitForElementToapper(By findBy)
	{
		

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	public CartPage goToCartPage()
	{
		//driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();
		cartHeader.click();
		CartPage cartPage =new CartPage(driver);
		return cartPage;
		
	}
	public OrderPage2 goToOrderPage()
	{
		//driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();
		orderHeader.click();
		OrderPage2 OrderPage =new OrderPage2(driver);
		return OrderPage;
		
	}
	public void waitForWebElementToapper(WebElement findBy)
	{
		

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	
	public void waitForElementToDisappear(WebElement ele) 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
}
