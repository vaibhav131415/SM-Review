package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);

	}


	@FindBy(xpath  = "//h5[@id='exampleModalLabel']") private WebElement actualreplenishmentText;
	@FindBy(xpath = "//button[normalize-space()='Select All']") private WebElement selectAllBtn;
	@FindBy(xpath = "//button[normalize-space()='View my selections']") private WebElement actualViewmMySelectionsBtn;
	@FindBy(xpath = "//button[normalize-space()='Deselect All']") private WebElement DeselectAllbtn;



	public String actualreplenishmentText() {

		return wait.until(ExpectedConditions.visibilityOf(actualreplenishmentText)).getText();

	}

	public void selectAllbtn() {

		wait.until(ExpectedConditions.visibilityOf(selectAllBtn)).click();

	}

	public String actualViewMySelectionsBtn () {

		return wait.until(ExpectedConditions.visibilityOf(actualViewmMySelectionsBtn)).getText();

	}

	public void DeslectAllbtn() {

		wait.until(ExpectedConditions.visibilityOf(DeselectAllbtn)).isEnabled();

	}


}
