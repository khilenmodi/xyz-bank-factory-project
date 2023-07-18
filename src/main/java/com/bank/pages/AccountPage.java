package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement clickDeposit;
    @CacheLookup
    @FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement amountToBeDeposited;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement verifyTextDepositSuccessful;

    @CacheLookup
    @FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[3]/button[3]")
    WebElement clickWithdraw;
    @CacheLookup
    @FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement amountToBeWithdrawn;
    @CacheLookup
    @FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement clickOnWithdraw;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement transactionSuccessful;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickOnDeposit;


    public void setClickDeposit() {
        clickOnElement(clickDeposit);
    }

    public void setAmountToBeDeposited(int value) {
        clearTextOfElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]"));
        sendTextToElement(amountToBeDeposited, "value");
    }

    public void setClickOnDeposit() {
        clickOnElement(clickOnDeposit);
    }

    public String setVerifyTextDepositSuccessFul() {
        return getTextFromElement(verifyTextDepositSuccessful);
    }

    public void setClickWithdraw() {
        clickOnElement(clickWithdraw);
    }

    public void setAmountToBeWithdrawn(int value) {
        clearTextOfElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]"));
        sendTextToElement(amountToBeWithdrawn, "value");
    }

    public void setClickOnWithdraw() {
        clickOnElement(clickOnWithdraw);
    }

    public String setTransactionSuccessful() {
        return getTextFromElement(transactionSuccessful);
    }
}
