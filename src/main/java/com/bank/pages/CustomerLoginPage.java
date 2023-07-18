package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Utility {
    @CacheLookup
            @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerTab;
    @CacheLookup
            @FindBy(id = "userSelect")
            WebElement searchOption;
   @CacheLookup
           @FindBy(xpath = "//button[contains(text(),'Login')]")
           WebElement clickLogIN;

   @CacheLookup
           @FindBy(xpath = "//button[@class='btn logout']")
           WebElement verifyLogOut;
    @CacheLookup
            @FindBy(xpath = "//button[contains(text(),'Logout')]")
            WebElement clickLogout;
    @CacheLookup
            @FindBy(xpath = "//span[contains(text(),'Harry Potter')]")
            WebElement verifyYourName;

    public void setCustomerTab(){
        clickOnElement(customerTab);
    }
    public void setSearchOption(String Name){
        selectByVisibleTextFromDropDown(searchOption,Name);
    }
    public void setClickOnHome(){
        clickOnElement(clickLogIN);
    }
    public String setVerifyLogOut(){
        return getTextFromElement(verifyLogOut);
    }
    public void setVerifyLogOut1(){
        clickOnElement(clickLogout);
    }
    public String SetVerifyYourName(){
        return getTextFromElement(verifyYourName);
    }
}
