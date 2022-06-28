package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;


import driverfactory.TestContext;
import hooks.BeforeAndAfterhook;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;


public class Cart {

	private final WebDriver driver;
	
	
	public Cart(TestContext context) {
		driver = context.driver;
	}
	
	
	

	@Given("user is on the homepage")
	public void user_is_on_the_homepage() {
		
		
		
		Assert.assertEquals("SM web app", driver.getTitle());


	}

	@When("user clicks on Get it done button")
	public void user_clicks_on_get_it_done_button() {

		new HomePage(driver).getItDoneBtn();
		
		
		

	}

	@Then("user should get Cart pop-up with referenced items in it")
	public void user_should_get_Cart_popup_with_referenced_items_in_it() {
		
		Assert.assertEquals("Review your replenishments", new CartPage(driver).actualreplenishmentText());


	}
	
	@And("user clicks on SelectAll button")
	public void user_clicks_on_select_all_button() {
	
		new CartPage(driver).selectAllbtn();
	}

	@Then("View my selections button should be enabled")
	public void view_my_selections_button_should_be_enabled() {
		
		Assert.assertEquals("View my selections", new CartPage(driver).actualViewMySelectionsBtn());
	   
	}
	
	
	@Then("Deselect All button should be enabled")
	public void Deselect_All_button_should_be_enabled() {
		
		new CartPage(driver).DeslectAllbtn();
	}
}
