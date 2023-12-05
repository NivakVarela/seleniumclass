package proyectoUno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;


public class proyectouno {

	private WebDriver driver;
	By linkLocator = By.cssSelector("a[href='https://www.instagram.com/instagram/']");
	
	@BeforeEach
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
	}
	
	@Test
	public void testgooglePage() {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("instagram");
		searchbox.submit();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//explicit wait
		//@SuppressWarnings("deprecation")
		//WebDriverWait ewait = new WebDriverWait(driver,10);
		//ewait.until(ExpectedConditions.titleContains("instagram"));
		
		//fluent wait
		//Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
				//.withTimeout(10,TimeUnit.SECONDS)
				//.pollingEvery(2,TimeUnit.SECONDS)
				//.ignoring(NoSuchElementException.class);
		
		//WebElement titulo = fwait.until(new Function<WebDriver,WebElement>(){
			//public WebElement apply(WebDriver driver) {
				//return driver.findElement(linkLocator);
			//}
	//	});
		
		assertTrue(driver.findElement(linkLocator).isDisplayed());
		assertEquals("instagram",driver.getTitle());
		
		
		
	}
	@AfterEach
	public void tearDown() {
		driver.quit();
	}
	
	
}
