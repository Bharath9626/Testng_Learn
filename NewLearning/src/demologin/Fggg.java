package demologin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fggg {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:/Seleniumjava/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		WebElement username = driver.findElement(By.cssSelector("input[placeholder='Username']"));
		username.sendKeys("Admin");

		WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
		password.sendKeys("admin123");

		WebElement loginbutton = driver.findElement(By.cssSelector("button[type='submit']"));
		loginbutton.click();

		driver.quit();
		
		
	}

}
