package proyectoUno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Shope_Celphone {

	
	
	private WebDriver driver;
	int num=0;
	
	//registro
	By registerLinkLocator = By.xpath("//a[contains(@href, 'register.htm')]");

	
	By registerPageLocator = By.id("customerForm");
	
	By nameRegister = By.id("customer.firstName");
	
	By lastnameRegister = By.id("customer.lastName");
	
	By AdressLocator = By.id("customer.address.street");
	
	By cityLocator = By.id("customer.address.city");
	By StateLocator = By.id("customer.address.state");
	By codeLocator = By.id("customer.address.zipCode");
	By NumberLocator = By.id("customer.phoneNumber");
	
	By ssnLocator = By.id("customer.ssn");
	
	By userNameLocator = By.id("customer.username");
    By passlocator = By.id("customer.password");
    By passrepeatLocator = By.id("repeatedPassword");
    By registerButtonLocator = By.cssSelector("input.button[type='submit'][value='Register']");
    By singupCheck =By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]");
    
    By logOutLinkLocator = By.xpath("//a[@href='/parabank/logout.htm' and contains(text(),'Log Out')]");
    
    
    //login
    By usernameLocator = By.name("username");
    By passLoginLocator = By.name("password");
    
    By logInButtonLocator = By.xpath("//input[@class='button' and @type='submit' and @value='Log In']");
    
    By CheckLogin = By.id("accountTable");




	
	@BeforeEach
	void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
	}

	@AfterEach
	void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();;
		Thread.sleep(2000);
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			
			driver.findElement(nameRegister).sendKeys("nicolas");
			driver.findElement(lastnameRegister).sendKeys("varela");
			driver.findElement(AdressLocator).sendKeys("calle 13");
			driver.findElement(cityLocator).sendKeys("bogota");
			driver.findElement(StateLocator).sendKeys("cundinarmaca");
			driver.findElement(codeLocator).sendKeys("110711");
			driver.findElement(NumberLocator).sendKeys("1234");
			driver.findElement(ssnLocator).sendKeys("ni idea");
			driver.findElement(userNameLocator).sendKeys("nivak7");
			driver.findElement(passlocator).sendKeys("123");
			driver.findElement(passrepeatLocator).sendKeys("123");
			
			driver.findElement(registerButtonLocator).click();
			
		}else {
			System.out.print("register pages was not found");
			
		}
		if(driver.findElement(singupCheck).isDisplayed()) {
			num=1;
		}
		assertEquals(num,1);
		
	}
	
	@Test
	public void sigIn () throws InterruptedException {
		if(driver.findElement(usernameLocator).isDisplayed()) {
			driver.findElement(usernameLocator).sendKeys("nivak7");
			driver.findElement(passLoginLocator).sendKeys("123");
			driver.findElement(logInButtonLocator).click();
			Thread.sleep(2000);
			assertTrue(driver.findElement(CheckLogin).isDisplayed());
			System.out.print(" existe el logeo");
		}else {
			System.out.print("no existe el logeo");
		}
		
	}

}
