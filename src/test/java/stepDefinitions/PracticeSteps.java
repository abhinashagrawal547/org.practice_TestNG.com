package stepDefinitions;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import pageObjects.PracticePage;

public class PracticeSteps {
	
	WebDriver driver;
	PracticePage practicePage;
	
	public PracticeSteps(){
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
		practicePage = new PracticePage(driver);
	}
	
	@Given("User have the url")
	public void user_have_the_url() {
		System.out.println("User is in User have the url. Number of elements with google image");
	}
	
	@Given("User open it")
	public void user_open_it() throws InterruptedException {
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		int numberOfGoogleImages = practicePage.FindCountOfGoogleImage();
		
		Thread.sleep(3000);
		Assert.assertTrue(numberOfGoogleImages > 0, "Login page not populated correctly. ");
		System.out.println("User is in User open it. Number of elements with google image = "+ numberOfGoogleImages);
		
		driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
		String OrigWindow = driver.getWindowHandle();
		Set<String> windowsSet = driver.getWindowHandles();
		
		for(String win :windowsSet)
		{
			driver.switchTo().window(win);
			System.out.println(driver.getCurrentUrl());
			if(driver.getCurrentUrl().contains("basic-controls.html"))
			{
				System.out.println("found the other window");
				driver.close();
				System.out.println("closed the other window");
			}
		}
		
		Thread.sleep(5000);
		driver.quit();
	}
}
