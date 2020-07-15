package pages;

import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;




public class NahlaPage {

	private WebDriver driver;
	
	// locators
		private By clickONamaMenu = By.xpath("//*[@id=\"menu-item-22\"]/a");
	
	
	
		
	//constructor
	public NahlaPage(WebDriver driver) {
		this.driver = driver;
		
		
	}

	public void clickONamaMenu() {
		Actions action = new Actions(driver);
		WebElement nahla = driver.findElement(clickONamaMenu);
		action.moveToElement(nahla).perform();
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-1464\"]/a")).click();
		
	}

	public static boolean  verifyLink() {
		Assert.assertEquals(NahlaPage.verifyLink(),"https://nahla.ba/", "User is on correct page");
		return true;
		
	}
	
}
