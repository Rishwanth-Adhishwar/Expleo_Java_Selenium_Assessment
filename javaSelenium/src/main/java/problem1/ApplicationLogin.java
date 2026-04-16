package problem1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationLogin {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://demoblaze.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#login2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logInModalLabel")));
		WebElement un = driver.findElement(By.cssSelector("#loginusername"));
		un.click();
		un.sendKeys("rishwanth");
		WebElement up = driver.findElement(By.cssSelector("#loginpassword"));
		up.click();
		up.sendKeys("rishwa123");

		WebElement login = driver.findElement(By.xpath("//button[text()='Log in']"));
		login.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logout2")));
		String validate = driver.findElement(By.cssSelector("#logout2")).getText();
		if (validate.equals("Log out")) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Login Unsuccessful");
		}

		WebElement laptop = driver.findElement(By.xpath("//a[text()='Laptops']"));
		act.moveToElement(laptop).click().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='MacBook Pro']")));

		List<WebElement> lapNames = driver.findElements(By.cssSelector(".hrefch"));
		List<String> sortLap = new ArrayList<>();
		for (WebElement s : lapNames) {
			String names = s.getText();
			sortLap.add(names);
		}
		Collections.sort(sortLap);
		Set<String> sortedSet = new LinkedHashSet<>(sortLap);
		System.out.println("Sorted laptop Names:");
		for (String all : sortedSet) {
			System.out.println(all);
		}
		WebElement mac = driver.findElement(By.xpath("//a[text()='MacBook Pro']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", mac);//js query  for chatgpt
		String validateTitle = mac.getText();
		System.out.println("Found Laptop: " + validateTitle);
		mac.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add to cart']")));
		String productTitle = driver.findElement(By.cssSelector(".name")).getText();
		String productPrice = driver.findElement(By.cssSelector(".price-container")).getText();
		WebElement addCart = driver.findElement(By.xpath("//a[text()='Add to cart']"));
		addCart.click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		System.out.println("Product added to cart");
		System.out.println(productTitle + " added to cart.");

		driver.findElement(By.id("cartur")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='MacBook Pro']")));
		String cartTitle = driver.findElement(By.xpath("//td[text()='MacBook Pro']")).getText();
		String cartPrice = driver.findElement(By.xpath("//td[text()='MacBook Pro']/following-sibling::td")).getText();
		
		System.out.println("Product Title: " + cartTitle);
		System.out.println("Product Price: " + cartPrice);

		driver.close();
	}
}
