package hooks;

import driverManager.DriverFactory;
import io.cucumber.java.*;

public class Hooks {
	
	@Before
	public void Before() {
		System.out.println("Inside Before hooks");
		DriverFactory.initDriver();
	}
	
	@After
	public void After() {
		System.out.println("Inside After hooks");
		DriverFactory.quitDriver();
	}
}
