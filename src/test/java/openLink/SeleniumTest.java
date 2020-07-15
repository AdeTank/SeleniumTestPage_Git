package openLink;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.NahlaPage;
import pages.SeleniumPage;




public class SeleniumTest {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//executable//chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://amina-pez.github.io/automation/");

	

	}

		@Test(priority = 1)
			public void SeleniumAutomationTestPage() throws Exception {

			SeleniumPage selenium = new SeleniumPage(driver);
			
			
			//1. Click on Hide button
			
			selenium.clickHideBtn();
			
			
			//2. Verify that "Tekst koji treba biti sakriven" is hidden
			
			selenium.hideText();
			
			
			
			//3. Check that Emu checkbox is disabled ???
			
			selenium.disabledCheckBtn();	
			
			
			//4. Verify that total number of checkboxes is 6
			
			int number = selenium.getAllCheckBoxes("checkbox");
			Assert.assertEquals(number, 6, "Number of checkboxes is not 6"); 
	
			
			//5. Select Radio button Jezeva kucica
			
			selenium.selectRadioBtn();
			
			
			//6. From Nahla Courses select Turski 
			
			selenium.selectDropdown();
	
			
			//7. Click on prompt box button, enter your name and click on OK ???
			
			selenium.clickPromptBtn();
			
			
			//8. Check that under "Prompt box!" button following text: "Hello <name>" is displayed
			
			selenium.getPromptText();
			
			
	 WebElement element = driver.findElement(By.id("clickAndHold"));
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	 Thread.sleep(500); 
			
			
			//9. Get total number of rows for table "Podaci o studentima". Note: exclude title row
			
			selenium.getTableNumberRows();
			
			
/** 10. Get First and Last Name for students which are in English course from the table
			selenium.getNamesEnglish();
*/ 
			 
			//11. Click on "Click to open a new browser window!" button 
			
			selenium.clickNewBrowserButton();
			
			
			// 12. Verify that Nahla.ba is open in another browser
			
			String SeleniumPage = driver.getWindowHandle();
			Set<String> allHandles= driver.getWindowHandles();
			for(String NahlaPage : allHandles){
			    driver.switchTo().window(NahlaPage);
			}
			    NahlaPage nahla = getDriver();
			
			Assert.assertEquals(selenium.getCurrentUrl(),"https://nahla.ba/", "User is on correct page");
			
			    
			 // 13. When on Nahla page click on "O NAMA" menu and click on "Nahlin tim"  
			    
			 nahla.clickONamaMenu();	
			 
			 
			 // 14. Verify that user is on "Nahla tim" page
			 
			Assert.assertEquals(selenium.getCurrentUrl(),"https://nahla.ba/o-nama/#tim", "User is on correct page");
			 
			 
			 // 15. Close nahla browser and continue to work on automation page
			 
			 driver.close(); 
			 
			 driver.switchTo().window(SeleniumPage);
			 
			 
			//16. Re-order elements by using drag and drop - "Click and hold" move to the top of list
			
			selenium.dragAndDrop();
			
			
			// 17. Move mouse over "Mouse over me"
			
		//	Thread.sleep(3000);
			selenium.mouseOver();
		//	Thread.sleep(3000);
			
			
			// 18. Take a screenshot and save it in folder: screenshot inside the maven project. Title of screenshot is "TestPage.png"
			
			selenium.takeScreenshot();
			
			
			// 19. Click on "Volontiraj" link inside the frame and verify that user is on Volontiraj page
			
			selenium.clickOnVolontirajLink();
			
			
			//20. Verify that user is on: "https://amina-pez.github.io/automation/"
			
			selenium.getCurrentUrl();
			Assert.assertEquals(selenium.getCurrentUrl(),"https://amina-pez.github.io/automation/", "User is on correct page");
			
		}
		
		private NahlaPage getDriver() {
			return new NahlaPage(driver);
			
		}	
		
		
		/*
@AfterClass
	public void TearDown() {

	driver.quit();
	
}	
	
	*/
}	
	

