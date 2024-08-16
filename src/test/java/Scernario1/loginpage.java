package Scernario1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import Testdata.DataDrivenTesting;
import pages.loginPageFactory;

public class loginpage {
	
WebDriver driver;
	int i=0;
	ExtentReports extent;
	ExtentTest test;
	public class OrangeHRM {
		WebDriver driver;
		ExtentSparkReporter htmlreporter;
		ExtentReports reports;
		ExtentTest test;

		@BeforeTest
		public void StartReport() {
			htmlreporter = new ExtentSparkReporter("OrangeHrmExtentProjectReport.html");
			reports = new ExtentReports();
			reports.attachReporter(htmlreporter);
			test = reports.createTest("ExtentTest");

			// Environment details if required

			reports.setSystemInfo("User", "Rohith");
			reports.setSystemInfo("Browser", "Chrome");
			reports.setSystemInfo("OS", "Window 10+");

			// // //conf.to change theme & feel //
			htmlreporter.config().setDocumentTitle("ExtendsReportProject"); //
			htmlreporter.config().setReportName("Test Report"); //
			htmlreporter.config().setTheme(Theme.DARK); //
		}

	
	@Test(dataProvider = "excelfile", dataProviderClass = DataDrivenTesting.class)//giving data to method
	public void Execution(String userString, String pwString)  {

		driver=new ChromeDriver();
		loginPageFactory lp=new loginPageFactory(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		lp.username(userString);
		lp.password(pwString);
		lp.submit();
		String s=Integer.toString(++i);
		String name="test".concat(s);
		System.out.println(name);
		Screenshot(name);
		boolean verification=driver.getCurrentUrl().contains("dashboard");
		System.out.println(verification);
		SoftAssert assert1=new SoftAssert();
		assert1.assertTrue(verification,"login failed");
//		Assert.assertTrue(verification, "login failed" );
		if(verification==true)
		lp.logout();
		driver.close(); 
	}
	
	
	public void Screenshot(String filename) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
try {
	System.out.println("screen shot taken");
			Files.copy(src, new File(System.getProperty("user.dir")+"\\ScreenShots\\"+filename+".png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	} 
	@AfterMethod

	public void extendReport(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "TestCase Pass Sucessfully");

		} else {
			test.log(Status.FAIL, "TestCase get Fail");
		}
	}

	@AfterClass
	public void tearDown() {
		reports.flush();
		driver.quit();
	}
}
	}
	