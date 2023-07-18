package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomersPage extends Utility {
    @CacheLookup
            @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement clickOnAddCustomerTab;

    public void setClickOnAddCustomerTab(){
        clickOnElement(clickOnAddCustomerTab);
    }
}
