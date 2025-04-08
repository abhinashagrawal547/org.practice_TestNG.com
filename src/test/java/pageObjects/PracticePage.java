package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import driverManager.DriverFactory;

public class PracticePage {
	
	WebDriver driver;

	public PracticePage() {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	private By googleImage = By.xpath("//img[@alt='Google']");
	
	public int FindCountOfGoogleImage(){
		List<WebElement> googleImages = driver.findElements(googleImage);
		return googleImages.size();
	}
	
}
