package hooks;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import driverfactory.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import saucelabsconnection.SaucelabsConnection;
import utilities.ConfigLoader;



public class BeforeAndAfterhook {

	private  RemoteWebDriver driver;
	public final TestContext context;
	
    public BeforeAndAfterhook(TestContext context) {
    	
		this.context = context;

	}

    @Parameters("browser")
	@Before
	public void setUp(Scenario scenario) throws MalformedURLException  {
        
    	//Setting Up saucelabs Connection and Browser capabilities
        SaucelabsConnection connection = new SaucelabsConnection();

		MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("username", connection.sauceUserName);
		sauceOpts.setCapability("accessKey",connection.sauceAccessKey);
		sauceOpts.setCapability("name", scenario.getName());
		sauceOpts.setCapability("build", "Service Modernization");

		MutableCapabilities browserOptions = new MutableCapabilities();

		if(ConfigLoader.property.get().getProperty("BrowserType").equalsIgnoreCase("chrome")) {

			browserOptions = new ChromeOptions();
			browserOptions.setCapability("sauce:options", sauceOpts);
			browserOptions.setCapability("browserName", "chrome");
			browserOptions.setCapability("browserVersion", "latest");
			browserOptions.setCapability("platformName", "Windows 10");

		}else if(ConfigLoader.property.get().getProperty("BrowserType").equalsIgnoreCase("firefox")) {

			browserOptions = new FirefoxOptions();
			browserOptions.setCapability("sauce:options", sauceOpts);
			browserOptions.setCapability("browserName", "firefox");
			browserOptions.setCapability("browserVersion", "latest");
			browserOptions.setCapability("platformName", "Windows 10");

		}else if(ConfigLoader.property.get().getProperty("BrowserType").equalsIgnoreCase("safari")) {

			browserOptions = new SafariOptions();
			browserOptions.setCapability("sauce:options", sauceOpts);
			browserOptions.setCapability("browserName", "safari");
			browserOptions.setCapability("browserVersion", "15");
			browserOptions.setCapability("platformName", "macOS 12");

		}

    	URL url = new URL(connection.sauceURL);
		driver = new RemoteWebDriver(url, browserOptions);
		context.driver = (RemoteWebDriver) driver;
        
		//Adding Browsername to the respective Scenarios on Extent report
		String BrowserName = browserOptions.getBrowserName().toLowerCase();
		scenario.log("BrowserName: "+BrowserName);
        
		//Adding 
		ExtentCucumberAdapter.getCurrentScenario().assignCategory(BrowserName);
 
		//Navigating to the Application URL
		driver.navigate().to(ConfigLoader.property.get().getProperty("baseUrl"));

       
	}


	@After(order = 0)
	public  void tearDown() {

		driver.quit();

	}

}
