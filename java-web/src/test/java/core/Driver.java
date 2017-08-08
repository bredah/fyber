package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Start WebDriver object
 * 
 * @author bredah
 * @version 0.1
 * @since 20170807
 */
public class Driver {

	private WebDriver driver;

	/**
	 * Start driver
	 * 
	 * @param browser
	 *            Browser name
	 * @return driver initiated
	 */
	public WebDriver start(Browser browser) {
		String pathDriver = getDriverAbsolutePath(browser);
		this.driver = null;
		switch (browser) {
		case CHROME: // Enabled
			System.setProperty("webdriver.chrome.driver", pathDriver);
			this.driver = new ChromeDriver();
			break;
		case EDGE: // Not enabled
			// this.driver = new EdgeDriver();
			break;
		case FIREFOX: // Not enabled
			// this.driver = new FirefoxDriver();
			break;
		case HEADLESS: // Not enabled
			break;
		case IE:// Not enabled
			// this.driver = new InternetExplorerDriver();
			break;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return this.driver;
	}

	/**
	 * Get absolute path from driver
	 * 
	 * @return Full path
	 */
	private String getDriverAbsolutePath(Browser browser) {
		String os = null;
		String driver = null;
		// Retrieve OS name
		switch (Utils.getOS()) {
		case LINUX:
		case MAC:
		case WINDOWS:
			os = Utils.getOS().toString().toLowerCase();
			break;
		default: // Browser undefined always return null
		case UNDEFINED:
			return null;
		}
		// Set the driver
		switch (browser) {
		case CHROME:
			driver = "chromedriver";
			driver += Utils.getOS().equals(OperationSystem.WINDOWS) ? ".exe" : "";
			break;
		case EDGE:
			break;
		case FIREFOX:
			break;
		case HEADLESS:
			break;
		case IE:
			break;
		}
		return String.format("%s/drivers/%s/%s", Utils.getPathResourceTest(), os, driver);
	}
}
