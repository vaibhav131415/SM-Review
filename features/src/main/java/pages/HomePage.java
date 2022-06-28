package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {

		super(driver);

	}

	@FindBy(xpath  = "//button[normalize-space()='Get it done']") private WebElement getITDonebtn;

	public void getItDoneBtn() {

		wait.until(ExpectedConditions.visibilityOf(getITDonebtn)).click();

	}



}
