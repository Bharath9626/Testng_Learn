package demologin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothCorrect {
	@Test
	@Parameters({"username","password"})
	public void loginwithbothcorrect(String uname,String pword) {
		System.setProperty("webdriver.chrome.driver", "D:/Seleniumjava/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys(uname);

		WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
		password.sendKeys(pword);

		WebElement loginbutton = driver.findElement(By.cssSelector("button[type='submit']"));
		loginbutton.click();

		driver.quit();
}
}
