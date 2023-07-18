package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPage extends Utility {
    @CacheLookup
            @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement clickOnOpenAccount;

    @CacheLookup
            @FindBy(id = "userSelect")
            WebElement searchByName;
    @CacheLookup
    @FindBy(id = "currency")
    WebElement selectCurrency;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement clickOnProcess;


    public void setClickOnOpenAccount(){
        clickOnElement(clickOnOpenAccount);
    }
    public void setSearchByName(){
        selectByVisibleTextFromDropDown(searchByName,"Harry Potter");
    }
    public void setSelectCurrency(){
        selectByVisibleTextFromDropDown(selectCurrency,"Pound");
    }
    public void setClickOnProcess(){
        clickOnElement(clickOnProcess);
    }
}
