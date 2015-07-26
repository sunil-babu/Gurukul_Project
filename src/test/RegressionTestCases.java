package test;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;
import framework.*;

public class RegressionTestCases {
	 WebDriver driver;
	homePage objhomePage;
	helperFunctions objhelperFunctions;
	branch_staff_Page objbranchstaff;
	
	@BeforeMethod 
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http:127.0.0.1:8080/");
        driver.manage().window().maximize();
    }
 
    /**
 
     * This test case will login in http://127.0.0.1:8080/
     * Verify login page title as Gurukula
     * Login to application
     * @throws InterruptedException 
 
     */
 	@Test
    @Parameters({ "sUsername", "sPassword" })
    public void verify_user_able_to_Login(String sUsername,String sPassword){
        //Create Login Page object
    	objhomePage = new homePage(driver);
    	//Verify login page title
    	objhomePage.getTitle();
    	//Navigate to Login Page
    	objhomePage.clickLogin();
	    // go the next page
    	objhomePage.login(sUsername, sPassword);
    	objhomePage.verifyLogin("You are logged in as user \""+ sUsername +"\".");
    	objhomePage.logout();
    }
  
 	  
 	 @Test
 	    @Parameters({ "sUsername", "sPassword" })
 	    public void verify_user_able_to_navigate_branch(String sUsername,String sPassword){
 	        //Create Login Page object
 	    	objhomePage = new homePage(driver);
 	    	objbranchstaff = new branch_staff_Page(driver);
 	    	//Verify login page title
 	    	objhomePage.getTitle();
 	    	//Navigate to Login Page
 	    	objhomePage.clickLogin();
 		    // go the next page
 	    	objhomePage.login(sUsername, sPassword);
 	    	objhomePage.verifyLogin("You are logged in as user \""+ sUsername +"\".");
 	    	objhomePage.navigateToBranch();
 	    	objbranchstaff.verifyBranchPage_Staff("Branches");
 	    	objhomePage.logout();
 	    }
 	@Test 
 	    @Parameters({ "sUsername", "sPassword"})
 	    public void verify_user_able_to_create_branch(String sUsername,String sPassword){
 	        //Create Login Page object
 	    	objhomePage = new homePage(driver);
 	    	objbranchstaff = new branch_staff_Page(driver);
 	    	objhelperFunctions = new helperFunctions();
 	    	//Verify login page title
 	    	objhomePage.getTitle();
 	    	//Navigate to Login Page
 	    	objhomePage.clickLogin();
 		    // go the next page
 	    	objhomePage.login(sUsername, sPassword);
 	    	objhomePage.verifyLogin("You are logged in as user \""+ sUsername +"\".");
 	    	objhomePage.navigateToBranch();
 	    	objbranchstaff.verifyBranchPage_Staff("Branches");
 	    	objbranchstaff.clickCreateBranch_Staff();
 	    	objbranchstaff.addBranch(objhelperFunctions.nameGenerator(), objhelperFunctions.codeGenerator());
 	    	objhomePage.logout();
 	    }
 	@Test 
 	    @Parameters({ "sUsername", "sPassword" ,"rowNumber"})
 	    public void verify_user_able_to_edit_branch(String sUsername,String sPassword,String rowNumber){
 	        //Create Login Page object
 	    	objhomePage = new homePage(driver);
 	    	objbranchstaff = new branch_staff_Page(driver);
 	    	objhelperFunctions = new helperFunctions();
 	    	//Verify login page title
 	    	objhomePage.getTitle();
 	    	//Navigate to Login Page
 	    	objhomePage.clickLogin();
 		    // go the next page
 	    	objhomePage.login(sUsername, sPassword);
 	    	objhomePage.verifyLogin("You are logged in as user \""+ sUsername +"\".");
 	    	objhomePage.navigateToBranch();
 	    	objbranchstaff.verifyBranchPage_Staff("Branches");
 	    	objbranchstaff.editBranch(objhelperFunctions.nameGenerator(), objhelperFunctions.codeGenerator(),"1");
 	    	objhomePage.logout();
 		}
 		
 	@Test 
 	    @Parameters({ "sUsername", "sPassword" ,"rowNumber" })
 	    public void verify_user_able_to_view_branch(String sUsername,String sPassword,String rowNumber){
 	        //Create Login Page object
 	    	objhomePage = new homePage(driver);
 	    	objbranchstaff = new branch_staff_Page(driver);
 	    	objhelperFunctions = new helperFunctions();
 	    	//Verify login page title
 	    	objhomePage.getTitle();
 	    	//Navigate to Login Page
 	    	objhomePage.clickLogin();
 		    // go the next page
 	    	objhomePage.login(sUsername, sPassword);
 	    	objhomePage.verifyLogin("You are logged in as user \""+ sUsername +"\".");
 	    	objhomePage.navigateToBranch();
 	    	objbranchstaff.verifyBranchPage_Staff("Branches");
 	    	objbranchstaff.viewBranch(rowNumber);
 	    	objhomePage.logout();
 	    }
 	@Test 
 	    @Parameters({ "sUsername", "sPassword" ,"rowNumber"})
 	    public void verify_user_able_to_delete_branch(String sUsername,String sPassword,String rowNumber){
 	        //Create Login Page object
 	    	objhomePage = new homePage(driver);
 	    	objbranchstaff = new branch_staff_Page(driver);
 	    	objhelperFunctions = new helperFunctions();
 	    	//Verify login page title
 	    	objhomePage.getTitle();
 	    	//Navigate to Login Page
 	    	objhomePage.clickLogin();
 		    // go the next page
 	    	objhomePage.login(sUsername, sPassword);
 	    	objhomePage.verifyLogin("You are logged in as user \""+ sUsername +"\".");
 	    	objhomePage.navigateToBranch();
 	    	objbranchstaff.verifyBranchPage_Staff("Branches");
 	    	objbranchstaff.deleteBranch(rowNumber);
 	    	objhomePage.logout();
 	    } 			
 	@Test 
 	    @Parameters({ "sUsername", "sPassword"})
 	    public void verify_user_able_to_search_branch(String sUsername,String sPassword){
 	        //Create Login Page object
 	    	objhomePage = new homePage(driver);
 	    	objbranchstaff = new branch_staff_Page(driver);
 	    	objhelperFunctions = new helperFunctions();
 	    	//Verify login page title
 	    	objhomePage.getTitle();
 	    	//Navigate to Login Page
 	    	objhomePage.clickLogin();
 		    // go the next page
 	    	objhomePage.login(sUsername, sPassword);
 	    	objhomePage.verifyLogin("You are logged in as user \""+ sUsername +"\".");
 	    	objhomePage.navigateToBranch();
 	    	objbranchstaff.verifyBranchPage_Staff("Branches");
 	    	objbranchstaff.searchBranch_Staff("19545", "1");
 	    	objhomePage.logout();
 	    	}
 		@Test 
 	    @Parameters({ "sUsername", "sPassword"})
 	    public void verify_user_able_to_search_staff(String sUsername,String sPassword){
 	        //Create Login Page object
 	    	objhomePage = new homePage(driver);
 	    	objbranchstaff = new branch_staff_Page(driver);
 	    	objhelperFunctions = new helperFunctions();
 	    	//Verify login page title
 	    	objhomePage.getTitle();
 	    	//Navigate to Login Page
 	    	objhomePage.clickLogin();
 		    // go the next page
 	    	objhomePage.login(sUsername, sPassword);
 	    	objhomePage.verifyLogin("You are logged in as user \""+ sUsername +"\".");
 	    	objhomePage.navigateToStaff();
 	    	objbranchstaff.verifyBranchPage_Staff("Staffs");
 	    	objbranchstaff.searchBranch_Staff("19545", "1");
 	    	objhomePage.logout();
 	    	}
 	    
 		
	  @AfterMethod 
	    public void tearDown(){
	        driver.close();
	    }
	
	
}
