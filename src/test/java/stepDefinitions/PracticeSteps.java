package stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import pageObjects.PracticePage;

public class PracticeSteps {
	
	WebDriver driver;
	PracticePage practicePage;
	
	public PracticeSteps()
	{
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
		driver.get("https://www.google.com");
		int numberOfGoogleImages = practicePage.FindCountOfGoogleImage();
		
		Thread.sleep(10000);
		Assert.assertTrue(numberOfGoogleImages > 0, "Login page not populated correctly. ");
		System.out.println("User is in User open it. Number of elements with google image = "+ numberOfGoogleImages);
		
		driver.quit();
	}
}
