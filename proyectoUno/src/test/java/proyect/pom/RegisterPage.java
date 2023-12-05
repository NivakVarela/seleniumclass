package proyect.pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Base {
	
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
    
  

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void registerUser() throws InterruptedException {
		click(registerLinkLocator);
		Thread.sleep(2000);
		if(isDisplayed(registerPageLocator)) {
			type("nivak",nameRegister);
			type("varela",lastnameRegister);
			type("calle 13",AdressLocator);
			type("bogota",cityLocator);
			type("Bogota",StateLocator);
			type("110711",codeLocator);
			type("1234455",NumberLocator);
			type("no se",ssnLocator);
			type("nivak10",userNameLocator);
			type("123",passlocator);
			type("123",passrepeatLocator);
			click(registerButtonLocator);
		}else {
			System.out.println("register page as not fund");
		}
	}
	
	
	public String RegisterMessage() {
		
		return "";
	}
		
}
