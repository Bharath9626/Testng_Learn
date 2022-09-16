package demologin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Login {

	String[][] data = null;
	WebDriver driver;

	@DataProvider(name = "LoginData")
	public String[][] loginDataProvider() throws BiffException, IOException {

		data = getExcelData();
		return data;
	}

	public String[][] getExcelData() throws BiffException, IOException {

		FileInputStream excel = new FileInputStream("D:\\Excel\\Login.xls");

		Workbook workbook = Workbook.getWorkbook(excel);

		Sheet sheet = workbook.getSheet(0);

		int rowcount = sheet.getRows();
		int columncount = sheet.getColumns();

		String testdata[][] = new String[rowcount - 1][columncount];

		for (int i = 1; i < rowcount; i++) {
			for (int j = 0; j < columncount; j++) {
				testdata[i - 1][j] = sheet.getCell(j, i).getContents();
			}
		}
		return testdata;
	}

	@Test(dataProvider = "LoginData")
	public void loginwithbothcorrect(String uname, String pword) {

		System.setProperty("webdriver.chrome.driver", "D:/Seleniumjava/chromedriver.exe");
		driver = new ChromeDriver();

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
