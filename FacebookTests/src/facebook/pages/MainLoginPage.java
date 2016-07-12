package facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainLoginPage extends FacebookPage {
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
	private By regFemale = By.xpath("//*[@name='sex'][@value='1']");
	private By regMale = By.xpath("//*[@name='sex'][@value='2']");
	private By regButton = By.name("websubmit");
	private By processingRegRequest = By.xpath("//button[@name='websubmit']/following-sibling::span/img");
	
	public MainLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void load() {
		driver.get("https://www.facebook.com");
	}
	
	public boolean isLoaded() {
		return getPageTitle().equals("Facebook - Log In or Sign Up");
	}
	
	public void setEmailLogin(String text) {
		setText(this.loginEmail, text);
	}
	
	public void setPasswordLogin(String text) {
		setText(this.loginPassword, text);
	}
	
	public void logIn() {
		click(this.loginButton);
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
		click(this.regButton);
	}
	
	public boolean isProcessingRegistrationRequest() {
		return this.isElementVisible(processingRegRequest, 2l, 200l);
	}
}
