package proyect.pom;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class SignIn_Test {
	
	private WebDriver driver;
	SignInPage signinPage;

	@BeforeEach
	void setUp() throws Exception {
		signinPage = new SignInPage(driver);
		driver =  signinPage.chromeDriverConnection();
		signinPage.visit("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		//driver.Quit();
	}

	@Test
	void test() throws InterruptedException {
		signinPage.login();
		Thread.sleep(2000);
		assertTrue(signinPage.isHomePage());
	}

}
