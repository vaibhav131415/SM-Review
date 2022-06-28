package runners;




import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigLoader;

@CucumberOptions(

		features = {"features/src/test/resources/features/"},
		glue = {"hooks","stepdefinitions"},
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true

                )

public class RunnerTest extends AbstractTestNGCucumberTests  {

	public final static ThreadLocal<String> BROWSER = new ThreadLocal<>();
	
	@Parameters("browserType")
	@BeforeClass
	public void beforeClass(@Optional String browser) {


		ConfigLoader.initializePropertyfile();
		
		RunnerTest.BROWSER.set(browser);

		if(!browser.equals("value not found")) {
			ConfigLoader.property.get().setProperty("BrowserType", browser);
		}

	}


    @AfterClass
	public void afterClass() {
    	
    }


}


