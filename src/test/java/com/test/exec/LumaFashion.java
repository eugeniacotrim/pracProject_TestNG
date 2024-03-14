package com.test.exec;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.listener.MyListener;
import com.utils.POMRepo;

@Listeners(MyListener.class)
public class LumaFashion{
	
	WebDriver driver = new ChromeDriver();


	@BeforeSuite
	@Test
	public void openApp() {
		String URL = "https://magento.softwaretestingboard.com/";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(URL);
	}
	
	@Test(priority = 1)
	public void registration() {
		driver.findElement(POMRepo.createAcctLink).click();
		
		driver.findElement(POMRepo.createAcctLink).click();
		WebElement firstN = driver.findElement(POMRepo.firstNameField);
		firstN.sendKeys(POMRepo.firstName);
		
		WebElement lastN = driver.findElement(POMRepo.lastNameField);
		lastN.sendKeys(POMRepo.lastName);
		
		WebElement emailReg = driver.findElement(POMRepo.emailField);
		emailReg.sendKeys(POMRepo.emailValid);
		
		WebElement pwReg = driver.findElement(POMRepo.psswrdField);
		pwReg.sendKeys(POMRepo.psswrdValid);
		
		WebElement pwConf = driver.findElement(POMRepo.psswrdConfirm);
		pwConf.sendKeys(POMRepo.psswrdValid);
		
	}	
	
	@Test(priority = 2)
	public void loginIncorrectPW() {
		driver.findElement(POMRepo.signInLink).click();
		
		WebElement emailLog = driver.findElement(POMRepo.emailLogin);
		emailLog.sendKeys(POMRepo.emailValid);
		
		WebElement pwLog = driver.findElement(POMRepo.psswrdLogin);
		pwLog.sendKeys(POMRepo.psswrdInvalid1);
		
		WebElement loginButton = driver.findElement(POMRepo.loginBttn);
		loginButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Invalid Form Key')] | //div[contains(text(),'account sign-in was incorrect')]")));
		
		WebElement errorIncPW = driver.findElement(POMRepo.errorPW1_2);
		String strIncPW = errorIncPW.getText();
		System.out.println("INVALID PASSWORD SCENARIO. DISPLAYED MESSAGE: '" +strIncPW+ "'");
	
	}
	
	@Test(priority = 3)
	public void loginBlankPW() {
		driver.findElement(POMRepo.signInLink).click();
		
		WebElement emailLog = driver.findElement(POMRepo.emailLogin);
		emailLog.sendKeys(POMRepo.emailValid);
		
		WebElement pwLog = driver.findElement(POMRepo.psswrdLogin);
		pwLog.sendKeys(POMRepo.psswrdInvalid2);
		
		WebElement loginButton = driver.findElement(POMRepo.loginBttn);
		loginButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(POMRepo.errorPW2));	
	
		WebElement errorBlankPW = driver.findElement(POMRepo.errorPW2);
		String strBlankPW = errorBlankPW.getText();
		System.out.println("BLANK PASSWORD SCENARIO. DISPLAYED MESSAGE: '" +strBlankPW+ "'");

	}
	
	@Test(priority = 4)
	public void loginUnregisteredEmail() {
		driver.findElement(POMRepo.signInLink).click();
		
		WebElement emailLog = driver.findElement(POMRepo.emailLogin);
		emailLog.sendKeys(POMRepo.emailInvalid1);
		
		WebElement pwLog = driver.findElement(POMRepo.psswrdLogin);
		pwLog.sendKeys(POMRepo.psswrdValid);
		
		WebElement loginButton = driver.findElement(POMRepo.loginBttn);
		loginButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(POMRepo.errorEmail1));
	
		WebElement errorIncEmail = driver.findElement(POMRepo.errorEmail1);
		String strIncEmail = errorIncEmail.getText();
		System.out.println("INVALID EMAIL SCENARIO. DISPLAYED MESSAGE: '" +strIncEmail+ "'");

	}
	
	@Test(priority = 5)
	public void loginBlankEmail() {
		driver.findElement(POMRepo.signInLink).click();	
		
		WebElement emailLog = driver.findElement(POMRepo.emailLogin);
		emailLog.sendKeys(POMRepo.emailInvalid2);
		
		WebElement pwLog = driver.findElement(POMRepo.psswrdLogin);
		pwLog.sendKeys(POMRepo.psswrdValid);
		
		WebElement loginButton = driver.findElement(POMRepo.loginBttn);
		loginButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(POMRepo.errorEmail2));

		WebElement errorBlankEmail = driver.findElement(POMRepo.errorEmail2);
		String strBlankEmail = errorBlankEmail.getText();
		System.out.println("BLANK EMAIL SCENARIO. DISPLAYED MESSAGE: '" +strBlankEmail+ "'");

	}

	@Test(priority = 6)
	public void searchProduct() {	
		WebElement searchBar = driver.findElement(POMRepo.srchBar);
		searchBar.sendKeys(POMRepo.searchProd);
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}
	
	@Test(priority = 7)
	public void addToCart() {	
		driver.findElement(POMRepo.yogaHoodie).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains(POMRepo.searchProd));
		
		driver.findElement(POMRepo.yogaHoodieSizeSmall).click();
		driver.findElement(POMRepo.yogaHoodieColorWhite).click();
		driver.findElement(POMRepo.addToCartBttn).click();
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(POMRepo.cartNotEmpty, "1"));
		
		driver.findElement(POMRepo.showCart).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(POMRepo.checkoutBttn));
		driver.findElement(POMRepo.checkoutBttn).click();
		
		wait.until(ExpectedConditions.titleContains(POMRepo.title));
		System.out.println("The item has been added to the cart successfully...");
	}
	
	@Test(priority = 8)
	public void closeApp() {		
		driver.close();
	}
}
