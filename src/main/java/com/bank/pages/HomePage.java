package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;

import java.util.Set;

public class HomePage extends Utility {
    public void switchToWindowHandle (){
        String parentWindow = driver.getWindowHandle();
        System.out.println("parent window" +parentWindow);
        clickOnElement(By.name("a.name"));
        Set<String> handles =  driver.getWindowHandles();
        System.out.println("All Handles" + handles);
        for (String handle : handles) {
            if(!handle.equals(parentWindow)){
                //Switch to Window Whose handle is not equal to parent window handle
                driver.switchTo().window(handle);
                //Click on Sign in link inside window
                clickOnElement(By.xpath("//button[normalize-space()='Add Customer']"));
                //Close the window
                driver.close();
                break;
            }
        }

        // Switch to focus of Driver to parent window
        driver.switchTo().window(parentWindow);
    }
}
