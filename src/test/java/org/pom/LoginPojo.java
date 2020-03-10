package org.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BaseClass;

public class LoginPojo extends BaseClass {

	static LoginPojo o;

	private LoginPojo() {

		PageFactory.initElements(driver, this);

	}
	
	
	public static LoginPojo object() {
		
		if(o==null) {
			o=new LoginPojo();
			return o;
		}
		
		else
		return o;
		
	}
	
	public static void setObject()
	{
		o=null;
	}

	
	@FindBy(xpath = "//a[@href='https://www.ikoala.com.au/login']")

	private WebElement login;

	@FindBy(xpath = "//*[@class='form-control']")

	private List<WebElement> user;

	@FindBy(xpath = "//input[@value='Login']")

	private WebElement button;

	@FindAll({
			
			@FindBy(xpath = "(//input[@type='text'])[3]"),
			@FindBy(xpath="//*[@placeholder='Search for Products, Brands and Everything']"),
			@FindBy(xpath="//input[@name='search']"),
			@FindBy(id="search-input")
			
	})

	private WebElement search;

	@FindBy(xpath = "//div[@class='input-group-addon btn  srchbtn']")

	private WebElement go;

	public WebElement getSearch() {
		return search;
	}

	public WebElement getGo() {
		return go;
	}

	public WebElement getLogin() {
		return login;
	}

	public List<WebElement> getUser() {
		return user;
	}

	public WebElement getButton() {
		return button;
	}

}
