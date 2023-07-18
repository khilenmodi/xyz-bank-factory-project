package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {
    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customerPage;
    HomePage homePage;
    OpenAccountPage openAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void InIt(){
        accountPage = new AccountPage();
        addCustomerPage = new AddCustomerPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        customerPage = new CustomersPage();
        homePage = new HomePage();
        openAccountPage = new OpenAccountPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully(){
        // click On "Bank Manager Login" Tab
        bankManagerLoginPage.setBankManagerLoginPage();
        //	click On "Add Customer" Tab
        customerPage.setClickOnAddCustomerTab();
        //	enter FirstName
        addCustomerPage.setEnterFirstname("khilen");
        //	enter LastName
        addCustomerPage.setEnterLastName("Modi");
        //	enter PostCode
        addCustomerPage.setEnterPostCode("WD25 2DN");
        //	click On "Add Customer" Button
        addCustomerPage.setClickAddCustomer();
        //	popup display
        addCustomerPage.getTextFromAlert();
        //	verify message "Customer added successfully"
        String actualMessage = homePage.getTextFromAlert();
        String expectedMessage = "Customer added successfully with customer id :6";
        Assert.assertEquals(actualMessage,expectedMessage,"Customer added successfully with customer id :6");
        //	click on "ok" button on popup.
        addCustomerPage.acceptAlert();

    }

    @Test (groups = {"smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully(){
        //click On "Bank Manager Login" Tab
        bankManagerLoginPage.setBankManagerLoginPage();
        //	click On "Open Account" Tab
        openAccountPage.setClickOnOpenAccount();
        //	Search customer that created in first test
        openAccountPage.setSearchByName();
        //	Select currency "Pound"
        openAccountPage.setSelectCurrency();
        //	click on "process" button
        openAccountPage.setClickOnProcess();
        //	popup displayed
        openAccountPage.getTextFromAlert();
        //	verify message "Account created successfully"
        String actualMessage = openAccountPage.getTextFromAlert();
        String expectedMessage = "Account created successfully with account Number :1016";
        Assert.assertEquals(actualMessage,expectedMessage,"Account created successfully with account Number :1016");
        //	click on "ok" button on popup.
        openAccountPage.acceptAlert();
    }
    @Test (groups = {"smoke", "regression"})
    public void customerShouldLoginAndLogoutSuceessfully(){
        //click on "Customer Login" Tab
        customerLoginPage.setCustomerTab();
        //	search customer that you created.
        customerLoginPage.setSearchOption("Harry Potter");
        //	click on "Login" Button
        customerLoginPage.setClickOnHome();
        //	verify "Logout" Tab displayed.
        String actualText = customerLoginPage.setVerifyLogOut();
        String expectedText = "Logout";
        Assert.assertEquals(actualText,expectedText, "Logout is not displayed");
        //	click on "Logout"
        customerLoginPage.setVerifyLogOut1();
        //	verify "Your Name" text displayed.
        String actualResult = customerLoginPage.SetVerifyYourName();
        String expectedResult = "Your Name";
        Assert.assertEquals(actualResult,expectedResult,"Your Name text is not displayed");
    }

    @Test (groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully(){
        // click on "Customer Login" Tab
        customerLoginPage.setCustomerTab();
        //	search customer that you created.
        customerLoginPage.setSearchOption("Harry Potter");
        //	click on "Login" Button
        customerLoginPage.setClickOnHome();
        //	click on "Deposit" Tab
        accountPage.setClickDeposit();
        //	Enter amount 100
        accountPage.setAmountToBeDeposited(100);
        //	click on "Deposit" Button
        accountPage.setClickOnDeposit();
        //	verify message "Deposit Successful"
        String actualMessage = accountPage.setVerifyTextDepositSuccessFul();
        String expectedMessage = "Deposit Successful";
        Assert.assertEquals(actualMessage,expectedMessage,"Deposit successful is not displayed");
    }
    @Test (groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException{
        //click on "Customer Login" Tab
        customerLoginPage.setCustomerTab();
        //	search customer that you created.
        customerLoginPage.setSearchOption("Harry Potter");
        //	click on "Login" Button
        customerLoginPage.setClickOnHome();
        //	click on "Withdrawl" Tab
        accountPage.setClickWithdraw();
        Thread.sleep(2000);
        //	Enter amount 50
        accountPage.setAmountToBeWithdrawn(50);
        //	click on "Deposit" Button
        accountPage.setClickOnWithdraw();
        //	verify message "Transaction Successful"
        String actualText = accountPage.setTransactionSuccessful();
        String expectedText = "Transaction Successful";
        Assert.assertEquals(actualText,expectedText,"Transaction Successful is not displayed");
    }
}
