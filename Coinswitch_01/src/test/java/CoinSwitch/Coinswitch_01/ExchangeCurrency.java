package CoinSwitch.Coinswitch_01;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExchangeCurrency {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://pro.coinswitch.co/");
		System.out.println("Webpage opened successfully");
		WebElement element = driver.findElement(By.xpath("//*[@id=\"dialogContent_2\"]/div[3]/button"));
		WebDriverWait wait = new WebDriverWait(driver, 40);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		element.click();
		System.out.println("clicked");
		WebElement From_currency = driver.findElement(By.xpath("//*[@id=\"cset__fromCurrencySelector\"]/i"));
		WebDriverWait waittime0 = new WebDriverWait(driver, 40);
		From_currency.click();
		System.out.println("Button clicked successfully");
		WebDriverWait waitTime1 = new WebDriverWait(driver, 40);
		driver.findElement(
				By.xpath("//*[@id=\"application__main\"]/div[1]/div[1]/cset/div/form/div[1]/div/div[3]/ul/li[13]"))
		.click();
		WebElement To_Currency = driver.findElement(By.id("cset__toCurrencySelector"));
		To_Currency.click();
		driver.findElement(
				By.xpath("//*[@id=\"application__main\"]/div[1]/div[1]/cset/div/form/div[3]/div/div[3]/ul[1]/li[3]"))
		.click();
		System.out.println("LTC selected");
		WebDriverWait waitTime = new WebDriverWait(driver, 60);
		WebElement cureency1 = driver.findElement(
				By.xpath("//*[@id=\"application__main\"]/div[1]/div[1]/cset/div/form/div[1]/div/div[2]/input"));
		cureency1.clear();
		cureency1.sendKeys("0.2");
		WebDriverWait waitTimeForAdress = new WebDriverWait(driver, 70);
		WebElement Address = driver.findElement(By.xpath("//*[@id=\"toCurrencyAutoComplete\"]"));
		Address.clear();
		Address.sendKeys("MGxNPPB7eBoWPUaprtX9v9CXJZoD2465zN");
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement exchange_Button = driver
				.findElement(By.xpath("//*[@id=\"application__main\"]/div[1]/div[5]/button/span[1]"));
		js.executeScript("arguments[0].scrollIntoView();", exchange_Button);
		exchange_Button.click();
		Thread.sleep(2000);
		System.out.println("Exchnage button clicked");
		WebDriverWait wait2 = new WebDriverWait(driver, 70);
		String deposit_adress = driver.findElement(By.xpath("//*[@id=\"recepientAddress\"]")).getText();
		System.out.println("Deposit adress is" + deposit_adress);
		driver.close();

	}
}
