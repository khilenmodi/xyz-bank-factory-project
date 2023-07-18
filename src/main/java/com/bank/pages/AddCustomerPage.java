package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement enterFirstname;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement enterLastName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement enterPostCode;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickAddCustomer;


    public void setEnterFirstname(String name) {
        sendTextToElement(enterFirstname, "name");
    }

    public void setEnterLastName(String lastName) {
        sendTextToElement(enterLastName, "lastName");
    }

    public void setEnterPostCode(String postCode) {
        sendTextToElement(enterPostCode, "postCode");
    }

    public void setClickAddCustomer() {
        clickOnElement(clickAddCustomer);
    }
}
