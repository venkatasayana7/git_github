package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;
import pageObjects.LoginPage;


public class Steps {
	public WebDriver driver;
	public LoginPage lp;

	@Given("User Launch Chrome Browser")
	public void user_Launch_Chrome_Browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium-webdriver\\chromedriver.exe");
		//driver = new InternetExplorerDriver();
		driver = new ChromeDriver();
		lp = new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) throws Exception{
		driver.get(url);
		Thread.sleep(4000);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String pwd) throws Exception{
		lp.setUserName(email);
		Thread.sleep(4000);
		lp.setPassword(pwd);
		Thread.sleep(4000);
	}

	@When("Click on Login")
	public void click_on_Login() {
		lp.clickLogin();

	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws Exception{
		lp.clickLogout();
		Thread.sleep(2000);

	}

	@Then("close browser")
	public void close_browser() {
		driver.close();

	}

}
