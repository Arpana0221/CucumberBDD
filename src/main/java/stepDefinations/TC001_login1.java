package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC001_login1 {
	WebDriver driver;
	@Given("user is on home page")
	public void user_is_on_home_page() {
		System.out.println("Launch browser and enter");
		driver=new ChromeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
	}
	@When("user clicks on Signin")
	public void user_clicks_on_signin() {
		System.out.println("Click on Signin link");
		driver.findElement(By.linkText("Sign in")).click();
	}
	@Then("Verify title in next page as Rediffmail")

	public void verify_title_in_next_page_as_rediffmail() {
		System.out.println("Verify title");  
		SoftAssert assertion=new SoftAssert();
		System.out.println("Logging in...");
		String title=driver.getTitle();
		assertion.assertEquals(title, "Rediffmail");
		System.out.println("Assert Executed...");
		assertion.assertAll();
	}
	@When("user enters user name password clicks on Submit button")
	public void user_enters_user_name_password_clicks_on_submit_button() throws InterruptedException {
		System.out.println("Enter user name and password");
		driver.findElement(By.id("login1")).sendKeys("m.arpana1234");
		driver.findElement(By.id("password")).sendKeys("arpana123");
		driver.findElement(By.name("remember")).click();
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(5000);
	}
	@Then("verify user and display message as Login Successful")
	public void verify_user_and_display_message_as_login_successful() {
		// System.out.println("Login Successful"); 
		String userName=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/span/cite/a")).getText();
		System.out.println("User Name="+userName);
		if(userName.equals("arpana"))
		{
			//System.out.println("Login Successful...");
			Reporter.log("Login Successful..");
		}
		else
		{
			//System.out.println("Login Unsuccessful...");
			Reporter.log("Login UnSuccessful..");
		}

	}
	@Then("Logout")
	public void logout() {
		System.out.println("Logout");
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();
	}
	@When("user enters invalid user name or password clicks on Submit button")
	public void user_enters_invalid_user_name_or_password_clicks_on_submit_button() {
		System.out.println("Enter invalid user name or password");
	}
	@Then("verify error message")
	public void verify_error_message() {
		System.out.println("Error message is displayed");
	}
	@Then("close")
	public void close() {
		System.out.println("Close");
		driver.quit();
	}







}
