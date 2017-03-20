package com.prasanna.demo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class UtilityPage {
	
	private static WebDriver hf;
	private static Actions action;

	public UtilityPage(WebDriver driv) 
	{
		hf = driv;
	}
	
	public void fillIn(By identifier,String textToEnter)
	{
		try
		{
			hf.findElement(identifier).sendKeys(textToEnter);
		}catch(Exception e)
		{
			System.out.println("Exception is:"+e+":"+identifier);
		}
	}
	
	public void clearTextbox(By identifier)
	{
		try
		{
			hf.findElement(identifier).clear();
		}catch(Exception e)
		{
			System.out.println("Exception is:"+e+":"+identifier);
		}
	}
	public void clickOn(By identifier)
	{
		try
		{
			hf.findElement(identifier).click();
		}catch(Exception e)
		{
			System.out.println("Exception is:"+e+":"+identifier);		
		}
	}
	
	public void selectDropDown(By identifier, String value)
	{
		try{
			Select dropDown = new Select(hf.findElement(identifier));
			dropDown.selectByIndex(0);
			fillIn(identifier, value);
		}catch(Exception e)
		{
			System.out.println("Exception is:"+e+":"+identifier);
		}
	}

	public void selectDropDownByIndex(By identifier, int indexValue)
	{
		try{
			Select dropDown = new Select(hf.findElement(identifier));
			dropDown.selectByIndex(indexValue);
		}catch(Exception e)
		{
			System.out.println("Exception is:"+e+":"+identifier);
		}
	}

	public String getElementText(By identifier)
	{
		try
		{
			return hf.findElement(identifier).getText();
		}catch(Exception e)
		{
			System.out.println("Exception is::"+e);
			return null;
		}
	}
	public String getText(String locatorType, String value)
    {
        try
        {
            return distinctTypeFinder(locatorType, value).getText();
        }catch(Exception e)
        {
            System.out.println("Exception is::"+e);
            return null;
        }
    }
    public WebElement distinctTypeFinder(String locatorTpye, String value) 
    {
        
        if(locatorTpye.equals("id")) 
            return hf.findElement(By.id(value));
        else if(locatorTpye.equals("name")) 
            return hf.findElement(By.name(value));
        else if(locatorTpye.equals("xpath")) 
            return hf.findElement(By.xpath(value));
        else if(locatorTpye.equals("css")) 
            return hf.findElement(By.cssSelector(value));
        else if(locatorTpye.equals("tagName")) 
            return hf.findElement(By.tagName(value));
        else if(locatorTpye.equals("linkText")) 
            return hf.findElement(By.linkText(value));
        else if(locatorTpye.equals("partialLinkText"))
            return hf.findElement(By.partialLinkText(value));
        else{
            System.out.println("No such element type available");
            return null;
        }
        
    }
    
    public void waitUntill(By identifier)
	{
		try 
		{
			new WebDriverWait(hf, 10).until(ExpectedConditions.presenceOfElementLocated(identifier));
		}catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public boolean isElementEnabled(By identifier)
	{
		try
		{
			return hf.findElement(identifier).isEnabled();
		}catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public boolean isElementDisplayed(By identifier)
	{
		try {
	       return hf.findElement(identifier).isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	public boolean isCheckBoxSelected(By identifier)
	{
		try {
	       return hf.findElement(identifier).isSelected();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	public boolean isRadioSelected(By identifier)
	{
		try {
	       return hf.findElement(identifier).isSelected();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	public void mouseHandler(By identifier)
    {
         try {
               action = new Actions(hf);
               action.moveToElement(hf.findElement(identifier)).build().perform();
         } catch (Exception e) {
               System.out.println("Element is:::"+identifier);
               System.out.println(e.getMessage());
         }
    }
	
	public void mouseClick(By identifier)
    {
         try {
               action = new Actions(hf);
               action.moveToElement(hf.findElement(identifier)).build().perform();
               hf.findElement(identifier).click();
         } catch (Exception e) {
               System.out.println("Element is:::"+identifier);
               System.out.println(e.getMessage());
         }
    }
	public void alertHandler()
	{
		try{
			hf.switchTo().alert().accept();
		}catch(Exception e)
		{
			System.out.println("Alert not present");
		}
	}
	
	public void pageRefresh()
	{
		try{
			hf.navigate().refresh();
		}catch(Exception e)
		{
			System.out.println("Page could not refresh at this time.");
		}
	}
	
	public String pageTitle()
	{
		try
		{
			return hf.getTitle();
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

}
