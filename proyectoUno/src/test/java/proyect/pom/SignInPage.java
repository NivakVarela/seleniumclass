package proyect.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage  extends Base{

	//login
    By usernameLocator = By.name("username");
    By passLoginLocator = By.name("password");
    By logInButtonLocator = By.xpath("//input[@class='button' and @type='submit' and @value='Log In']");
    By CheckLogin = By.id("accountTable");
    //constructor
	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//clase login
	public void login() throws InterruptedException {
		if(isDisplayed(usernameLocator)) {
			type("nivak10",usernameLocator);
			type("123",passLoginLocator);
			click(logInButtonLocator);
			
		}else {
			System.out.println("no logro entrar");
		}
	}
	public boolean isHomePage() {
		return isDisplayed(CheckLogin);
	}

}
