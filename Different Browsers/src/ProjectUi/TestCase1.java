package ProjectUi;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase1 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().to("https://www.getcalley.com/page-sitemap.xml");
		WebElement sitemap = driver.findElement(By.id("sitemap"));
		List<WebElement> rows = sitemap.findElements(By.xpath("//tr/td/a"));
		for(int i=0;i<5;i++) {
		rows.get(i).click();
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File  trgfile = new File("s:\\screenshot1\\img"+i+".png");
		FileUtils.copyFile(srcfile, trgfile);
		driver.navigate().back();
		Thread.sleep(4000);
		 sitemap = driver.findElement(By.id("sitemap"));
		 rows = sitemap.findElements(By.xpath("//tr/td/a"));
		}
		driver.quit();
	}


}
