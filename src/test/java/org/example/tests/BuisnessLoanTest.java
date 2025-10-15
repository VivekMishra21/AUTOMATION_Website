package org.example.tests;

import org.example.pages.BuisnessLoan;
import org.example.pages.PersonalLoan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BuisnessLoanTest {


    WebDriver driver;
    BuisnessLoan loan;
    PersonalLoan pl;

    @BeforeTest
    public void setup(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();

        loan= new BuisnessLoan();
        loan.driver=driver;
        pl=new PersonalLoan();
        pl.driver=driver;



    }


    @Test
    public void buisnessLoanTest()throws InterruptedException{
        loan.buisnessLoanForm();
        pl.personalLoanForm();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
