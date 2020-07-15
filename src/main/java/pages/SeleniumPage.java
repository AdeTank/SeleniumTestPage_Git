package pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;

public class SeleniumPage {
	
	private WebDriver driver;
	
	// locators
	private By hideBtn = By.xpath("//button[@id='hide-textbox']");
		
	private By disabledCheckBtn = By.id("emu-checkbox");
	
	private By selectRadioBtn = By.xpath("//div[@id='booksCheckboxes']//input[2]");
	
	private By selectDropdown = By.id("Nahla Course");
	
	private By selectDropdownTurski = By.xpath("//option[contains(text(),'Turski')]");
	
	private By clickPromptBtn = By.id("promptBox");
	
	private By getPromptText = By.id("demo");
	
	private By clickNewBrowserButton  = By.id("win1");
	
	private By nahlaPage = By.xpath("//a[@href=\"http://nahla.ba/\"]");
	
	private By clickOnVolontirajLink = By.xpath("//*[@id=\"page\"]/div[3]/div/section[1]/div/div/div[5]/div/div/div[2]/div/div/p[3]/a");
	
	private By volontiraj = By.xpath("//*[@id=\"post-2340\"]/div/div/div/div/section[2]/div/div/div/div/div/div/div/div");

	
	
	//constructor
	public SeleniumPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickHideBtn() {
		
		driver.findElement(hideBtn).click();
	
	}

	public void hideText() {
		
		  WebElement hideText = driver.findElement(By.xpath("//div[@id='displayed-text']"));

		    Assert.assertFalse(hideText.isDisplayed());
		
		    System.out.println("Tekst je skriven" );
		    
	}

	public void disabledCheckBtn() {
		
		driver.findElement(disabledCheckBtn).getAttribute("disabled");
		System.out.println("Checkbox Emu is disabled");
		
	}
	
	public int getAllCheckBoxes(String checkbox) {
		List<WebElement> checkBoxList = driver.findElements(By.cssSelector("[type=\"" + checkbox + "\"]"));
		System.out.println("Number of checkboxes is: " + checkBoxList.size());	
		return checkBoxList.size();
		
	}

	public void selectRadioBtn() {
		driver.findElement(selectRadioBtn).click();
	
	}

	public void selectDropdown() {
		driver.findElement(selectDropdown).click();
		driver.findElement(selectDropdownTurski).click();
	
	}

	public void selectDropdownTurski() {
	driver.findElement(selectDropdownTurski).click();
	//	return;
	}

	public void clickPromptBtn() {
	driver.findElement(clickPromptBtn).click();
	driver.switchTo().alert().sendKeys("Ade");
	driver.switchTo().alert().accept();
	
	}
	
	public void getPromptText() {
	String text = driver.findElement(getPromptText).getText();
	System.out.println("Text displayed is: "+ text);
	 
	}

	public void getTableNumberRows() {
		List<WebElement> row = driver.findElements(By.xpath("/html/body/form/div[7]/div/div/table/tbody/tr[position()>1]"));
		System.out.println("Total Number of Rows = " + row.size());
		
	}
	
	public void getNamesEnglish() {
		
		 String textFirstNameWilliam = driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]")).getText();  
		 String textLastNameBell = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();  
		 String textFirstNameMajda = driver.findElement(By.xpath("//table/tbody/tr[3]/td[1]")).getText();  
		 String textLastNameHusic = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText(); 
		 System.out.println("English course students: " +textFirstNameWilliam +" "+ textLastNameBell +", "+ textFirstNameMajda +" "+ textLastNameHusic);
	
		
/*
		 String textNameWilliam = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"
				 + "/table/tbody/tr[3]/td[1]"
					+ "/table/tbody/tr[3]/td[2]"))
				.getText();  
		 System.out.println("English course students: " + textNameWilliam); 
*/
		 
	}
	
	public void dragAndDrop() {
		
		driver.switchTo().defaultContent();
		Actions action = new Actions(driver);
		
		WebElement sourceElement = driver.findElement(By.id("clickAndHold")); 
		
		WebElement targetElement = driver.findElement(By.id("click")); 
				
		action.dragAndDrop(sourceElement, targetElement).perform();
		
	}

	public void mouseOver() {
		
		Actions action = new Actions(driver);
		WebElement selenium = driver.findElement(By.id("demo2"));
		action.moveToElement(selenium).perform();
		
	}
	
	public void takeScreenshot() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
			  
		File source = ts.getScreenshotAs(OutputType.FILE);
			
		String destination = System.getProperty("user.dir") + "//screenshot//" + "TestPage.png";
			  
			try  {
			  FileUtils.copyFile(source, new File(destination));
			  
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
		  
		}
	
	public void clickOnVolontirajLink()   {
		
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[2]/iframe")));
	
		driver.findElement(clickOnVolontirajLink).click();
		
		String text = driver.findElement(volontiraj).getText();
		System.out.println("Stranica: "+ text);
		 
		driver.switchTo().defaultContent();
		
	}

	public String getCurrentUrl() {
		
		return driver.getCurrentUrl();
		
	}


	public void clickNewBrowserButton() {
	driver.findElement(clickNewBrowserButton).click();
	  
	
	}
		    
		   
}	 
		
	

	
	








	


