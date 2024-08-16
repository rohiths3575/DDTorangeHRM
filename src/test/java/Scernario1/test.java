package Scernario1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



@Test
public class test {

	
	public void y() throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		//HomePageFactory hp=new HomePageFactory(driver);
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]")).click();
	WebElement click=	driver.findElement(By.xpath("(//p[contains(@class,'MuiTypography-root MuiTy')])[8]"));
	WebElement slider2=	driver.findElement(By.xpath("//input[contains(@type,'number')]"));
	Actions action=new Actions(driver);
	action.moveToElement(slider2).build().perform();

   String s= click.getText();
System.out.println(s);
	Thread.sleep(20000);
	driver.close();
	}}
