
package RahulShettyAcademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;

public class ChceckoutPage extends AbstractComponent {
WebDriver driver;
	public ChceckoutPage(WebDriver driver) 
		{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results =By.cssSelector(".ta-results");
	
	
	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country,countryName ).build().perform();
		waitForElementToapper(results);
		selectCountry.click();
	}
	public ConformationPage submitorder() {
		submit.click();
		
		return new ConformationPage(driver);
	}

}


//driver.findElement(By.cssSelector(".action__submit")).click();