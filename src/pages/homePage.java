package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.*;

public class homePage {
	WebDriver driver;
	actions objactions;
	
	By homelnk =  By.cssSelector("div.container-fluid li:nth-child(2) a");
	By entitieslnk =  By.linkText("Entities");
	By accountlnk =  By.cssSelector("div.container-fluid li:nth-child(4) a");
    By loginlnk = By.cssSelector("div.container a");
    By registerlnk = By.linkText("Register a new account");
    By homepageTitle = By.xpath("//h1[text()='Welcome to Gurukula!']");
    By usertxtbox = By.id("username");
    By Passtxtbox = By.id("password");
    By authenticateBtn = By.cssSelector("div.container button");
    By branchlnk = By.cssSelector("ul.dropdown-menu a:nth-child(1)");
    By stafflnk = By.cssSelector("ul.dropdown-menu li:nth-child(2) a");
    By logoutlnk = By.cssSelector("div.container-fluid ul li:nth-child(4) ul li:nth-child(4) a");
    
    public homePage(WebDriver driver){	 
        this.driver = driver;
    }
    
    public void clickLogin(){
    	driver.findElement(loginlnk).click();
    }
    
    public void clickRegister(){
    	driver.findElement(registerlnk).click();
    }
    
    public void getTitle(){
    	 driver.findElement(homepageTitle);
    }
    
    public void login(String userName,String password){
    	driver.findElement(usertxtbox).sendKeys(userName);
    	driver.findElement(Passtxtbox).sendKeys(password);
    	driver.findElement(authenticateBtn).click();
    }
    public void verifyLogin(String value){
    	driver.getPageSource().contains(value);
    }
    public void navigateToBranch(){
    	objactions = new actions(driver);
    	objactions.waitforElementVisible(entitieslnk).click();
    	driver.findElement(branchlnk).click();
    
    }
    public void navigateToStaff(){
    	objactions = new actions(driver);
    	objactions.waitforElementVisible(entitieslnk).click();
    	driver.findElement(stafflnk).click();
    
    }
    public void logout(){
    	objactions = new actions(driver);
    	objactions.javascriptScrolltoView(accountlnk);
    	objactions.waitforElementVisible(accountlnk).click();
    	objactions.waitforElementVisible(logoutlnk).click();
    	driver.getPageSource().contains("Click here to login");
    }
}
