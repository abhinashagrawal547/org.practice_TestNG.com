package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	// ThreadLocal to ensure each thread has its own WebDriver instance
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Initialize the WebDriver only if it's not already set for this thread
    public static void initDriver() {
    	if(driver.get()==null) {
    		WebDriverManager.chromedriver().setup();
    		driver.set(new ChromeDriver());
    		driver.get().manage().window().maximize();
    	}
    }
    
    // Get the current thread's driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Quit and remove the driver for the current thread
    public static void quitDriver() {
        driver.get().quit();
    }
}
