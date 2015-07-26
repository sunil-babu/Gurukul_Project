package test;

import mx4j.log.Log4JLogger;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import pages.*;
import framework.*;


public class EndtoEndTestcase {
	
	private static WebDriver driver; 
	private static Logger Log = Logger.getLogger(Log4JLogger.class.getName());
	//object creation
	homePage objhomePage;
	helperFunctions objhelperFunctions;
	branch_staff_Page objbranchstaff;
	
	//Setup for Browser
	@BeforeMethod 
	@Parameters("browser")
    public void setup(String browser){
		DOMConfigurator.configure("log4j.xml");
		if(browser.equalsIgnoreCase("firefox")) {
			  driver = new FirefoxDriver();
		  // If browser is IE, then do this	  
		 }else if (browser.equalsIgnoreCase("ie")) { 
			 System.setProperty("webdriver.ie.driver", "C:\\Users\\sunil_babu\\Gurukula\\bin\\IEDriverServer.exe"); 
			 driver = new InternetExplorerDriver();
		 } 
		  // If browser is Chrome, then do this	  
		 else if (browser.equalsIgnoreCase("chrome")) {
			  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunil_babu\\Gurukula\\bin\\chromedriver.exe");
			  driver = new ChromeDriver();
		 } 
		Log.info("New driver instantiated");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http:127.0.0.1:8080/");
        Log.info("Gurukula application launched");
        driver.manage().window().maximize();
    }
	
	@Test
    @Parameters({ "sUsername", "sPassword" ,"rowNumber"})
    public void verify_End_to_End_Branch(String sUsername,String sPassword,String rowNumber) throws InterruptedException{
        //Create Login Page object
		Reporter.log("Starting End to End Test case for Branch ");
    	objhomePage = new homePage(driver);
    	objbranchstaff = new branch_staff_Page(driver);
    	objhelperFunctions = new helperFunctions();
    	String tempValue = null;
    	//Verify login page title
    	objhomePage.getTitle();
    	//Navigate to Login Page
    	objhomePage.clickLogin();
	    // go the next page
    	Log.info("Username and password entered ");
    	objhomePage.login(sUsername, sPassword);
    	objhomePage.verifyLogin("You are logged in as user \""+ sUsername +"\".");
    	objhomePage.navigateToBranch();
    	Log.info("Navigated to Branch page ");
	    objbranchstaff.verifyBranchPage_Staff("Branches");
	    for(int i=0; i<10 ;i++){
	    	Thread.sleep(1200);//Just to slow down the Execution - Remove and Run
	    	objbranchstaff.clickCreateBranch_Staff();
	    	tempValue =objhelperFunctions.codeGenerator();
	    	objbranchstaff.addBranch(objhelperFunctions.nameGenerator(), tempValue);
	    	Log.info("Added Branch ");
	    }
	    Thread.sleep(1200);//Just to slow down the Execution for better viewing- Remove and Run
	    objbranchstaff.searchBranch_Staff(tempValue, "1");
	    Log.info("Successfully searched Branch ");
	    Thread.sleep(1200);//Just to slow down the Execution for better viewing- Remove and Run
	    objbranchstaff.viewBranch(rowNumber);
	    Log.info("Successfully viewed Branch ");
	    Thread.sleep(1200);//Just to slow down the Execution for better viewing- Remove and Run
	    objbranchstaff.editBranch(objhelperFunctions.nameGenerator(), objhelperFunctions.codeGenerator(),"1");
	    Log.info("Successfully Edited Branch ");
	    Thread.sleep(1200);//Just to slow down the Execution for better viewing - Remove and Run
	    objbranchstaff.deleteBranch(rowNumber);
	    Log.info("Successfully deleted Branch ");
	    objhomePage.logout();
	    Reporter.log("Succesffuly completed ");
    }
	@Test
    @Parameters({ "sUsername", "sPassword" ,"rowNumber"})
    public void verify_End_to_End_staff(String sUsername,String sPassword,String rowNumber) throws InterruptedException{
		Reporter.log("Starting End to End Test case for Staff ");
		//Create Login Page object
    	objhomePage = new homePage(driver);
    	objbranchstaff = new branch_staff_Page(driver);
    	objhelperFunctions = new helperFunctions();
    	
    	String tempValue = null;
    	//Verify login page title
    	objhomePage.getTitle();
    	//Navigate to Login Page
    	objhomePage.clickLogin();
	    // go the next page
    	objhomePage.login(sUsername, sPassword);
    	objhomePage.verifyLogin("You are logged in as user \""+ sUsername +"\".");
    	objhomePage.navigateToStaff();
	    objbranchstaff.verifyBranchPage_Staff("staffs");
	    for(int i=0; i<10 ;i++){
	    	Thread.sleep(1200);//Just to slow down the Execution for better viewing- Remove and Run
	    	objbranchstaff.clickCreateBranch_Staff();
	    	tempValue =objhelperFunctions.nameGenerator();
	    	objbranchstaff.addstaff(tempValue, objhelperFunctions.numGenerator());
	    	
	    }
	    objbranchstaff.searchBranch_Staff(tempValue, "1");
	    objbranchstaff.viewBranch(rowNumber);	
	    objbranchstaff.editstaff(objhelperFunctions.nameGenerator(), objhelperFunctions.numGenerator(),"1");
	    objbranchstaff.deleteStaff(rowNumber);
	    objhomePage.logout();
	    Reporter.log("Successfully Completed End to End test cased for Staffs ");
    }
	
	@AfterMethod 
	    public void tearDown(){
	        driver.close();
	    }
	

}
