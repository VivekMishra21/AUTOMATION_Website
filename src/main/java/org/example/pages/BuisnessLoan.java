package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BuisnessLoan {

  public WebDriver driver;


  public void buisnessLoanForm() throws InterruptedException{
//      driver=new ChromeDriver();
//      driver.manage().window().maximize();

      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      //buisness loan link
      driver.get("https://www.wishfin.com/business-loan");

      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

      try {

          //loan amount
          WebElement loanAmount=wait.until(ExpectedConditions.elementToBeClickable(By.id("LoanAmount")));
          loanAmount.sendKeys("200000");
          System.out.println("Successfull Fill LoanAmount");

          //occupation
          WebElement occupationDropdown=wait.until(ExpectedConditions.elementToBeClickable(By.id("Occupation-button")));
          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", occupationDropdown);
          Thread.sleep(500);


          try {
              occupationDropdown.click();
          } catch (ElementClickInterceptedException e) {
              ((JavascriptExecutor) driver).executeScript("arguments[0].click();", occupationDropdown);
          }

          WebElement salariedOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='Salaried']")));
          salariedOption.click();
          System.out.println("Successfull Selected Employement Type");


          WebElement mobileNumber= driver.findElement(By.id("MobileNo"));
          mobileNumber.sendKeys("9876543210");
          System.out.println("Succesfull filled Mobile Number");

          WebElement city=driver.findElement(By.id("City"));
          city.sendKeys("Noida");
          System.out.println("Successfull Filled City");

          //filled Name
          driver.findElement(By.id("FirstName")).sendKeys("Rohan");
          driver.findElement(By.id("LastName")).sendKeys("Rexwal");
          System.out.println("Successfull filled FirstName and LastName");

          //EmailId
          driver.findElement(By.id("EmailID")).sendKeys("test@gmail.com");



          // === Date of Birth ===
          WebElement dobInput = driver.findElement(By.id("DOB"));
          dobInput.click();
          Thread.sleep(1000);


          Select yearSelect = new Select(driver.findElement(By.className("ui-datepicker-year")));
          yearSelect.selectByVisibleText("1996");

          Select monthSelect = new Select(driver.findElement(By.className("ui-datepicker-month")));
          monthSelect.selectByVisibleText("Oct");

          driver.findElement(By.xpath("//a[text()='15']")).click();

          //pancard
          driver.findElement(By.id("PANcard")).sendKeys("ABCDI3348Q");
          System.out.println("Successfull fill pancard");



//          //gender

//          try {
//              // Step 1: Click on the visible dropdown button
//              WebElement genderDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("gender-button")));
//              ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderDropdown);
//              Thread.sleep(100);
//
//              try {
//                  genderDropdown.click();
//              } catch (ElementClickInterceptedException e) {
//                  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderDropdown);
//              }
//
//              // Step 2: Select "Male" option
//              WebElement maleOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/form/div[2]/div[7]/div/div/label[1]/input") ));
//              maleOption.click();
//
//
//
//          } catch (Exception e) {
//              System.out.println("❌ Error selecting Gender: " + e.getMessage());
//          }


          //gender
          WebElement gender =driver.findElement(By.id("gender"));
          gender.click();


          //monthly Income
          WebElement monthlyIncome=driver.findElement(By.id("MonthlyIncome"));
          monthlyIncome.sendKeys("30000");

          //company Name
          WebElement companyName=driver.findElement(By.id("CompanyName"));
          companyName.sendKeys("Wishfin");

          //accept box checkBox
          WebElement acceptBox=driver.findElement(By.id("accept"));
          ((JavascriptExecutor)driver).executeScript("arguments[0].click();",acceptBox);
          System.out.println("Successfull Click Box");

          //submit Button
           WebElement submitButton=driver.findElement(By.className("submitBtn"));
          ((JavascriptExecutor)driver).executeScript("arguments[0].click();",submitButton);
          System.out.println("Submit Button Click");


      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }


  }

}
