package SeleniumTestJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testTable {

	public WebDriver driver;
	String logInURL = "http://the-internet.herokuapp.com/login";
	String hoversURL = "http://the-internet.herokuapp.com/hovers";
	String tablesURL = "http://the-internet.herokuapp.com/tables";
	
	@BeforeClass
	public void setUpDriver(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	
}
	@Test
	
	public void checkHovers(){
		
		driver.navigate().to(hoversURL);
		Actions action = new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='content']/div/div[1]/img"));
		action.moveToElement(element).build().perform();
		
		WebElement toolTip = driver.findElement(By.xpath(".//*[@id='content']/div/div[1]/div/h5"));
		String toolTipText = toolTip.getText();
		
		Assert.assertEquals("name: user1", toolTipText);
		
		
		WebElement element2 = driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/img"));
		action.moveToElement(element2).build().perform();
		
		WebElement toolTip2 = driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/div/h5"));
		String toolTipText2 = toolTip2.getText();
		
		Assert.assertEquals("name: user2", toolTipText2);
		
		
		
		WebElement element3 = driver.findElement(By.xpath(".//*[@id='content']/div/div[3]/img"));
		action.moveToElement(element3).build().perform();
		
		WebElement toolTip3 = driver.findElement(By.xpath(".//*[@id='content']/div/div[3]/div/h5"));
		String toolTipText3 = toolTip3.getText();
		
		Assert.assertEquals("name: user3", toolTipText3);
		
		
	}
	

	@AfterClass
	public void tearDown(){
		
		if (driver != null){
			driver.quit();
		}
	}
}
