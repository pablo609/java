package facebook.pages;

import org.openqa.selenium.By;

import facebook.util.WebDriverInterface;

public class MainLoginPage extends FacebookPage {
	private static final String PAGE_TITLE = "Facebook - Log In or Sign Up";
	private static final String PAGE_URL = "https://www.facebook.com";
	private By loginEmail = By.id("email");
	private By loginPassword = By.id("pass");
	private By loginButton = By.cssSelector("input[value='Log In']");
	private By regFirstName = By.name("firstname");
	private By regLastName = By.name("lastname");
	private By regEmail = By.name("reg_email__");
	private By regEmailConfirmation = By.name("reg_email_confirmation__");
	private By regPassword = By.name("reg_passwd__");
	private By regBirthdayDay = By.name("birthday_day");
	private By regBirthdayMonth = By.name("birthday_month");
	private By regBirthdayYear = By.name("birthday_year"); 
	private By regFemale = By.cssSelector("*[name='sex'][value='1']"); //By.xpath("//*[@name='sex'][@value='1']"); 
	private By regMale = By.cssSelector("*[name='sex'][value='2']"); //By.xpath("//*[@name='sex'][@value='2']");
	private By regButton = By.name("websubmit");
	private By regRequestProgressBar = By.xpath("//button[@name='websubmit']/following-sibling::span/img");
		
	public MainLoginPage(WebDriverInterface driverInterface) {
		super(driverInterface);
	}
	
	public void configureCookieAndLoad() {
		driverInterface.loadPage(PAGE_URL);
		clearLoginCookie();
		setLanguageCookietoUS();
		driverInterface.loadPage(PAGE_URL);
	}
	
	public void load() {
		driverInterface.loadPage(PAGE_URL);
	}
	
	public boolean isLoaded() {
		return getPageTitle().equals(PAGE_TITLE);
	}
	
	public void setEmailLogin(String text) {
		setText(loginEmail, text);
	}
	
	public void setPasswordLogin(String text) {
		setText(loginPassword, text);
	}
	
	public void logIn() {
		click(loginButton);
	}
	
	public void fillRegistrationForm(
			String regFirstName,
			String regLastName,
			String regEmail,
			String regEmailConfirmation,
			String regPassword,
			String regBirthdayDay,
			String regBirthdayMonth,
			String regBirthdayYear,
			String regSex) {
		
		setText(this.regFirstName, regFirstName);
		setText(this.regLastName, regLastName);
		setText(this.regEmail, regEmail);
		setText(this.regEmailConfirmation, regEmailConfirmation);
		setText(this.regPassword, regPassword);
		selectOption(this.regBirthdayDay, regBirthdayDay);
		selectOption(this.regBirthdayMonth, regBirthdayMonth);
		selectOption(this.regBirthdayYear, regBirthdayYear);
		if(regSex.equals("femal"))
			click(this.regFemale);
		else if(regSex.equals("male"))
			click(this.regMale);
	}
	
	public void submitRegistration() {
		click(regButton);
	}
	
	public boolean isProcessingRegistrationRequest() {
		final long WAIT_FOR_2SEC = 2l;
		final long CHECK_EVERY_200MS = 200l;
		
		return isElementVisible(regRequestProgressBar, WAIT_FOR_2SEC, CHECK_EVERY_200MS);
	}
}
