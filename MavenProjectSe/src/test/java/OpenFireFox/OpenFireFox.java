package OpenFireFox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenFireFox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriver driver;
		
		System.setProperty("webdriver.gecko.driver", "D:\\librerias\\drivers\\drivers\\geckodriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.youtube.com/");
		
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox")).sendKeys("A Tester Mate");
		driver.findElement(By.id("search-icon-legacy")).click();
		Thread.sleep(2000);
		
		WebElement El2= driver.findElement(By.xpath("*//*[text()='Tengo que saber de todos los tipos de Pruebas de Software?']"));
		WebElement El1= driver.findElement(By.xpath("*//*[text()='Es importante saber de SQL cómo Tester?']"));
		
		js.executeScript("arguments[0].scrollIntoView();", El1);
		
		El2.click();
		Thread.sleep(5000);
		
		
		driver.quit();
	}

}
