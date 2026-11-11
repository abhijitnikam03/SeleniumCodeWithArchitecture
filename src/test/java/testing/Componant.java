package testing;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Componant {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//waits
		WebElement dropdown = driver.findElement(By.id("fruit-select"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(dropdown));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.stepcampus.in/playground");
		
		//scroll down
		WebElement scroll = driver.findElement(By.xpath("(//div[@dir='ltr'])[4]")); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scroll);
		Thread.sleep(2000);
		
		
		driver.findElement(By.cssSelector("button[value=\"option-two\"]")).click();
		driver.findElement(By.xpath("(//button[@role='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//button[@role='switch'])")).click();
		
		js.executeScript("arguments[0].scrollIntoView(true);",dropdown);
		Select fruit = new Select(dropdown);
		fruit.selectByIndex(1);
		WebElement alt =driver.findElement(By.xpath("//button[contains(text(),'Show Alert')]"));
		alt.click();
		WebElement ok =driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		ok.click();
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\abhij\\OneDrive\\Desktop\\SDET_Automation_Jobs_Last24h.xlsx");
	//	driver.findElement(By.xpath("//a[@href='/sample.txt']//button")).click();
		Thread.sleep(2000);
		
		//Action class
		Actions act =new Actions(driver);
		driver.findElement(By.xpath("(//div[@class='p-6 pt-0 space-y-4'])[3]//button[1]")).click();
		WebElement doublebtn =  driver.findElement(By.xpath("(//div[@class='p-6 pt-0 space-y-4'])[3]//button[2]"));
		WebElement contextbtn =  driver.findElement(By.xpath("(//div[@class='p-6 pt-0 space-y-4'])[3]//button[3]"));
		WebElement hover =  driver.findElement(By.xpath("//button[contains(text(),'Hover over me')]"));
		act.moveToElement(hover);
		act.doubleClick(doublebtn);
		act.contextClick(contextbtn);
		act.dragAndDrop(contextbtn, hover);
		
		//web Table
		String name = driver.findElement(By.xpath("//table//tr/td[contains(text(),'john.doe@stepcampus.in')]/ancestor::tr/td[1]")).getText();
		System.out.println(name);
		
		//frame locator
		WebElement frames = driver.findElement(By.xpath("//iframe[@title='Outer Frame']"));
		driver.switchTo().frame(frames);
		
		//Keyboard event
		WebElement key =  driver.findElement(By.xpath("//input[@placeholder='Type here...']"));
		js.executeScript("arguments[0].scrollIntoView(true);",key);
		Thread.sleep(2000);
		key.click();
		act.keyDown(Keys.CONTROL).sendKeys("abhijit");
		
		//Screen shot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:/path/to/your/folder/screenshot.png");
		srcFile.renameTo(destFile);
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
	}
}