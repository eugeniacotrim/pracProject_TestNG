package com.utils;

import org.openqa.selenium.By;

public class POMRepo {

//	Registration	
	public static final By createAcctLink = By.xpath("(//a[text()='Create an Account'])[1]");	
	public static final By firstNameField = By.xpath("//input[@id='firstname']");
	public static final By lastNameField = By.xpath("//input[@id='lastname']");
	public static final By emailField = By.xpath("//input[@name='email']");
	public static final By psswrdField = By.xpath("//input[@id='password']");
	public static final By psswrdConfirm = By.xpath("//input[@name='password_confirmation']");
	public static final By signInLink = By.xpath("(//a[contains(text(),'Sign In')])[1]");
	public static final String firstName = "Jane";
	public static final String lastName = "Doe";
	
//	Login	
	public static final By emailLogin = By.xpath("//input[@id='email']");
	public static final By psswrdLogin = By.xpath("//input[@name='login[password]']");
	public static final By loginBttn = By.xpath("(//button[@name='send'])[1]");
	public static final By errorPW1_1 = By.xpath("//div[contains(text(),'Invalid Form Key')]");
	public static final By errorPW1_2 = By.xpath("//div[contains(text(),'The account sign-in was incorrect')]");
	public static final By errorPW2 = By.xpath("//div[@for='pass'][contains(text(),'This is a required field')]");
	public static final By errorEmail1 = By.xpath("//div[contains(text(),'The account sign-in was incorrect')]");
	public static final By errorEmail2 = By.xpath("//div[@for='email'][contains(text(),'This is a required field')]");
	public static final String emailValid = "janedoe@example.com";
	public static final String psswrdValid = "!23A56789";
	public static final String emailInvalid1 = "jane@example.com";
	public static final String psswrdInvalid1 = "!23456789";
	public static final String emailInvalid2 = "";
	public static final String psswrdInvalid2 = "";

//	Search	
	public static final By srchBar = By.xpath("//input[@id='search']");
	public static final String searchProd = "Yoga Hoodie";
	
//	Add to cart	
	public static final By yogaHoodie = By.xpath("(//li[@class='item product product-item'])[1]");
	public static final By yogaHoodieSizeSmall = By.xpath("//div[@id='option-label-size-143-item-167']");
	public static final By yogaHoodieColorWhite = By.xpath("//div[@id='option-label-color-93-item-59']");
	public static final By addToCartBttn = By.xpath("//button[@class='action primary tocart']");
	public static final By cartNotEmpty = By.xpath("//a/span/span[@class='counter-number']");
	public static final By showCart = By.xpath("//a[@class='action showcart']");
	public static final By checkoutBttn = By.xpath("//button[@id='top-cart-btn-checkout']");
	public static final String title = "Checkout";

}
