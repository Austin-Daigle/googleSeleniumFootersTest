package basicweb;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class FooterTest {
	
	
	public static String advertisingTitle = "Google Ads - Get More Customers & Generate Leads with Online Ads";
	
	public static String businessTitle = "Google for Small Business - Resources to get your small business online";
	
	public static String howSearchWorksTitle = "Google Search - Discover How Google Search Works";
	
	public static String privateTitle = "Privacy Policy – Privacy & Terms – Google";
	
	public static String termsTitle = "Google Terms of Service – Privacy & Terms – Google";
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		boolean allResults = true;
		

		//Testing settings pop-up menu
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Austin\\libs\\selenium-java-4.6.0\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		driver.manage().window().maximize();
		//Wait for 10 second if elements is not loaded
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//find the element by the parameter string
		

		
		//testing all options within settings menu
		driver.findElement(By.cssSelector(".ayzqOc")).click();
		driver.findElement(By.linkText("Search settings")).click();
		System.out.println("Testing 'Search Settings' settings menu option");
		printTestResult(driver.getTitle().contentEquals("Search Settings"));

		
		Thread.sleep(1000);

		driver.navigate().back();
		driver.findElement(By.cssSelector(".ayzqOc")).click();
		driver.findElement(By.linkText("Advanced search")).click();
		System.out.println("Testing 'Advanced Search' settings menu option");
		printTestResult(driver.getTitle().contentEquals("Google Advanced Search"));

		Thread.sleep(1000);

		driver.navigate().back();
		driver.findElement(By.cssSelector(".ayzqOc")).click();
		driver.findElement(By.linkText("Your data in Search")).click();
		System.out.println("Testing 'Your Data in Search' settings menu option");
		printTestResult(driver.getTitle().contentEquals("Your data in Search"));
		
		Thread.sleep(1000);

		driver.navigate().back();
		driver.findElement(By.cssSelector(".ayzqOc")).click();
		driver.findElement(By.linkText("Search history")).click();
		System.out.println("Testing 'Search History' settings menu option");
		printTestResult(driver.getTitle().contentEquals("Google - Search Customization"));

		Thread.sleep(1000);

		driver.navigate().back();
		driver.findElement(By.cssSelector(".ayzqOc")).click();
		driver.findElement(By.linkText("Search help")).click();
		System.out.println("Testing 'Search Help' settings menu option");
		printTestResult(driver.getTitle().contentEquals("Google Search Help"));
		
		Thread.sleep(1000);
		driver.navigate().back();
		
		driver.findElement(By.cssSelector(".ayzqOc")).click();
		driver.findElement(By.cssSelector(".znKVS > Span")).click();
		System.out.println("Testing 'Send Feedback' settings menu option");
		printTestResult(driver.getPageSource().contains("feedback")
				&& driver.getPageSource().contains("wizard"));
		Thread.sleep(1000);
		driver.get("http://www.google.com");

		
		
		
		//Dark Mode 
		System.out.println("Testing 'Dark Theme: Off'");
		driver.findElement(By.cssSelector(".ayzqOc")).click();
		driver.findElement(By.cssSelector(".aqvxcd > svg")).click();

		printTestResult(driver.getPageSource().contains("Dark theme: On"));
		
		System.out.println("Testing 'Dark Theme: On' settings menu option");
		driver.findElement(By.cssSelector(".ayzqOc")).click();
		driver.findElement(By.cssSelector(".tFYjZe > div:nth-child(1)")).click();
		printTestResult(driver.getPageSource().contains("Dark theme: Off"));
		
		driver.close();
		
		//Test footers
		testFooter("Advertising",advertisingTitle);
		testFooter("How Search works",howSearchWorksTitle);
		testFooter("Privacy",privateTitle);
		testFooter("Terms",termsTitle);
		testFooter("Business",businessTitle);

	}

	private static Object findElements(By tagName) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void printTestResult(boolean input) {
		if(input) {
			System.out.println("\t status: ***Test Successful***");
		}
		else {
			System.out.println("\t status: Test Failed!");
		}
	}
	
	
	public static boolean testFooter(String elementText, String title) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Austin\\libs\\selenium-java-4.6.0\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		//Maximize the windows
		driver.manage().window().maximize();
		//Wait for 10 second if elements is not loaded
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//find the element by the parameter string
		driver.findElement(By.linkText(elementText)).click();
		//wait for page load
		Thread.sleep(1000);
		System.out.println("[Testing]: \""+elementText+"\" Footer Link");
		//print the status of the element test using the URL as a the check
		if(driver.getTitle().contentEquals(title)) {
			System.out.println("\t Current Page Title: "+driver.getTitle());
			System.out.println("\t status: ***Test Successful***");
			driver.close();
			return true;
		}
		else {
			System.out.println("\t status: Test Failed!");
			System.out.println(driver.getTitle());
			//close the page
			driver.close();
			return false;
		}

	}

}