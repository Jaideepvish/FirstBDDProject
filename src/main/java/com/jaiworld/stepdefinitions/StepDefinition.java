/**
 * 
 */
package com.jaiworld.stepdefinitions;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jaiworld.utility.PropertyReader;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author jaideepvish
 *
 */
public class StepDefinition {

	WebDriver driver;
	PropertyReader propReader;
	WebDriverWait wait;

	@Before
	public void setUp() {

		propReader = new PropertyReader();
		driver = propReader.getDriver();
		wait = new WebDriverWait(driver, 30);

	}

	@Given("^the user is on home page and clicks login$")
	public void the_user_is_on_home_page_and_clicks_login() {

		driver.get(propReader.getUrl());
		driver.manage().window().maximize();

		// Uncomment these lines if your site is asking not secure and browser is asks
		// to proceed anyway
		// driver.findElement(By.id("details-button")).click();
		// driver.findElement(By.id("proceed-link")).click();

		driver.findElement(By.cssSelector("input[id='buttonlogin']")).click();

	}

	@When("^user enter valid valid credentials and login$")
	public void user_enter_valid_valid_credentials_and_login() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='j_username']")));
		driver.findElement(By.cssSelector("input[name='j_username']")).sendKeys(propReader.getUserName());
		driver.findElement(By.cssSelector("input[name='j_password']")).sendKeys(propReader.getPassword());
		driver.findElement(By.id("buttonlogin")).click();
	}

	@When("^user enters the search cretieria for getawys$")
	public void user_enters_the_search_cretieria_for_getawys() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchCriteria")));
		driver.findElement(By.id("searchCriteria")).sendKeys(propReader.getDestination());
		driver.findElement(By.id("fromDate")).sendKeys(propReader.getCheckInFromDate());
		driver.findElement(By.id("toDate")).sendKeys(propReader.getCheckInToDate());
		driver.findElement(By.cssSelector("input[value='Find Getaway']")).click();

	}

	@Then("^find the number of resorts avialble$")
	public void find_the_number_of_resorts_avialble() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gw-availabilities-content")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		String count = driver.findElement(By.cssSelector("div[class='menu_page_result'] ul li:nth-of-type(1)"))
				.getText();		
		// String count =
		// driver.findElement(By.xpath("//*[@id=\"gw-availabilities-content\"]/div[14]/ul/li[1]")).getText();
		if (StringUtils.isNotBlank(count)) {
			count = count.substring(0, count.indexOf('|'));
		}
		System.out.println("Total " + count);
	}

}
