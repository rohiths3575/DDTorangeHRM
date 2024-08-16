package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageFactory {

	WebDriver driver;
	@FindBy(xpath = "//input[@name='username']")
	WebElement un;
	@FindBy(xpath = "//input[@name='password']")
	WebElement pw;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement sub;
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	WebElement profile;
	@FindBy(xpath = "(//a[@class='oxd-userdropdown-link'])[4]")
	WebElement logout;
	public loginPageFactory(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void username(String uname) {
		un.sendKeys(uname);
	}
	
	public void password(String pword) {
		pw.sendKeys(pword);
	}
	public void submit() {
		sub.click();
	}
	public void logout() {
		profile.click();
		logout.click();
	}
}
