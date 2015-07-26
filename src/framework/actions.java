package framework;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;


public class actions {
	WebDriver driver;
	int timeinSeconds = 30;
	public actions(WebDriver driver){	 
        this.driver = driver;
    }
	
	public WebElement waitforElementPresent(By element){
		WebElement myDynamicElement = (new WebDriverWait(driver, timeinSeconds))
				  .until(ExpectedConditions.presenceOfElementLocated(element));
		return myDynamicElement;
    }
	public WebElement waitforElementVisible(By element){
		WebElement myDynamicElement = (new WebDriverWait(driver, timeinSeconds))
				  .until(ExpectedConditions.elementToBeClickable(element));
		return myDynamicElement;
    }
	public void javascriptScrolltoView(By element){
		WebElement elements = driver.findElement(element);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);" ,elements);
	}
	public By replaceLocator(By element,String value){
		String newElement =  element.toString().replace("[*]", value);
		By newElement1 = By.cssSelector(newElement.substring(15));
		return newElement1;
	}
	

	
}
	

	

