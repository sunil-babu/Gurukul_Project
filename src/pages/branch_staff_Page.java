package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import framework.actions;

public class branch_staff_Page {
	WebDriver driver;
	actions objactions;
	By createBranchbtn =  By.cssSelector("button.btn.btn-primary");
	By nameInput = By.cssSelector("div.modal-body div:nth-child(2) input");
	By codeInput = By.cssSelector("div.modal-body div:nth-child(3) input");
	By branchdpdwn = By.name("related_branch");
	By saveBtn = By.cssSelector("div.modal-footer button:nth-child(2)");
	By viewBtn = By.cssSelector("div.table-responsive tr:nth-child([*]) button:nth-child(1)");
	By editBtn = By.cssSelector("div.table-responsive tr:nth-child([*]) button:nth-child(2)");
	By deleteBtn = By.cssSelector("div.table-responsive tr:nth-child([*]) button:nth-child(3)");
	By backBtn = By.cssSelector("div.container button");
	By deleteConfBtn = By.cssSelector("div#deleteBranchConfirmation button:nth-child(2)");
	By deleteConfStaffBtn = By.cssSelector("div#deleteStaffConfirmation button:nth-child(2)");
	By searchInput = By.cssSelector("input#searchQuery");
	By searchBtn = By.cssSelector("button.btn.btn-info");
	
	
	  public branch_staff_Page(WebDriver driver){	 
	        this.driver = driver;
	    }
	  
	  
	  public void verifyBranchPage_Staff(String value){
		  driver.getPageSource().contains(value);
	    }
	  public void clickCreateBranch_Staff(){
		  objactions =  new actions(driver);
		  objactions.waitforElementVisible(createBranchbtn).click();
	  }
	  public void addBranch(String name, String code){
		  objactions =  new actions(driver);
		  objactions.waitforElementVisible(nameInput).sendKeys(name);
		  objactions.waitforElementVisible(codeInput).sendKeys(code);
		  objactions.waitforElementVisible(saveBtn).click();
	  }
	  public void addstaff(String name, int number){
		  objactions =  new actions(driver);
		  objactions.waitforElementVisible(nameInput).sendKeys(name);
		  objactions.waitforElementVisible(branchdpdwn);
		  WebElement selectElement = driver.findElement(branchdpdwn);
		  Select selectThis = new Select(selectElement);
		  selectThis.selectByIndex(number);
		  objactions.waitforElementVisible(saveBtn).click();
	  }
	  public void viewBranch(String replaceValue){
		  objactions =  new actions(driver);
		  objactions.waitforElementVisible(objactions.replaceLocator(viewBtn,replaceValue)).click();
		  objactions.waitforElementVisible(backBtn).click();
	  }
	  public void editBranch(String name, String code,String replaceValue){
		  objactions =  new actions(driver);
		  objactions.waitforElementVisible(objactions.replaceLocator(editBtn,replaceValue)).click();
		  objactions.waitforElementVisible(nameInput).clear();
		  driver.findElement(nameInput).sendKeys(name);
		  objactions.waitforElementVisible(codeInput).clear();
		  driver.findElement(codeInput).sendKeys(code);
		  objactions.waitforElementVisible(saveBtn).click();
	  }
	  
	  public void editstaff(String name, int number,String replaceValue){
		  objactions =  new actions(driver);
		  objactions.waitforElementVisible(objactions.replaceLocator(editBtn,replaceValue)).click();
		  objactions.waitforElementVisible(nameInput).clear();
		  driver.findElement(nameInput).sendKeys(name);
		  WebElement selectElement = driver.findElement(branchdpdwn);
		  Select selectThis = new Select(selectElement);
		  selectThis.selectByIndex(number);
		  objactions.waitforElementVisible(saveBtn).click();
	  }

	  public void deleteBranch(String replaceValue){
		  objactions =  new actions(driver);
		  objactions.waitforElementVisible(objactions.replaceLocator(deleteBtn,replaceValue)).click();
		  objactions.waitforElementVisible(deleteConfBtn);
		  driver.findElement(deleteConfBtn).click();
	  }  
	  public void deleteStaff(String replaceValue){
		  objactions =  new actions(driver);
		  objactions.waitforElementVisible(objactions.replaceLocator(deleteBtn,replaceValue)).click();
		  objactions.waitforElementVisible(deleteConfStaffBtn).click();
	  }
	  
	  public void searchBranch_Staff(String searchValue,String replaceValue){
		  objactions =  new actions(driver);
		  objactions.waitforElementVisible(searchInput).sendKeys(searchValue);
		  objactions.waitforElementVisible(searchBtn).click();
		  objactions.waitforElementPresent(objactions.replaceLocator(viewBtn,replaceValue));
	  }
	  
}
