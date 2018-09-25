package stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition{

	 WebDriver driver;
	 WebDriverWait wait;
	 WebElement element=null;

	 @Given("^visit Flipkart$")
	 public void visit_Flipkart()  {
		
			 System.setProperty("webdriver.chrome.driver","./driver//chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.get("https://corpapps.mindtree.com/ams");
	 }
	 @When("^sucessfully Login$")
	 public void sucessfully_Login() 
	 {
		 wait=new WebDriverWait(driver,10);
			//visiting ams page
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='category-cont-wrap purple']//p[contains(text(),'View your details, raise stay out and travel requests.')]")));
					element.click();
			//creating new page
					WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newReq")));
					element1.click();
					Date date = new Date();  
			//formating date
					SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
					String strDate= formatter.format(date);
			//adding date in from date
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtFromDate")));
					element.sendKeys(strDate);
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtToDate")));
					element.sendKeys(strDate);
	     
	 }
	 @Then("^search mobile$")
	 public void search_mobile() 
	 {
		// Write code here that turns the phrase above into concrete actions
		 
					//adding comments
							element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("requestorComments")));
							element.sendKeys("marketing");
					//selecting requesttime
							Select newelement =new Select( wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlRequestType"))));
							newelement.selectByVisibleText("Mon-Fri (5:30PM -10:30PM)");
					//selecting meal
							element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chkBoxNone")));
							element.click();
					//selecting from time
							newelement =new Select( wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drpFromTime"))));
							newelement.selectByVisibleText("5:30 PM");
							newelement =new Select( wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drpToTime"))));
							newelement.selectByVisibleText("10:30 PM");
					//submitting
							Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
								    .withTimeout(30, TimeUnit.SECONDS)
								    .pollingEvery(5,  TimeUnit.SECONDS)
								    .ignoring(NoSuchElementException.class);

								WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
								{
								  public WebElement apply(WebDriver driver) {
								  return driver.findElement(By.id("submit"));
								}
								});
							
							foo.click();
					//handeling alert
							Alert alert=driver.switchTo().alert();
							alert.accept();
							
	     
	 }
	
	 
	 @Then("^visit cart$")
	 public void visit_cart() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }

	 @Then("^logout$")
	 public void logout() throws Throwable {
	     // Write code here that turns the phrase above into concrete actions
	     throw new PendingException();
	 }
	
	
	 
	
	
	
	

}
