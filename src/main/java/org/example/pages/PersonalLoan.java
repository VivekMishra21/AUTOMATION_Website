package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PersonalLoan {

    public WebDriver driver;


    public void personalLoanForm() throws InterruptedException {
        // Launch Chrome
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open Wishfin Personal Loan form
        driver.get("https://www.wishfin.com/personal-loan");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // === Loan Amount ===
            WebElement loanAmount = wait.until(ExpectedConditions.elementToBeClickable(By.id("LoanAmount")));
            loanAmount.sendKeys("200000");

            // === Occupation Dropdown ===
            WebElement occupationDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("Occupation-button")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", occupationDropdown);
            Thread.sleep(500);

            try {
                occupationDropdown.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", occupationDropdown);
            }

            WebElement salariedOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='Salaried']")));
            salariedOption.click();

            // === Monthly Income ===
            WebElement monthlyIncome = driver.findElement(By.id("MonthlyIncome"));
            monthlyIncome.sendKeys("30000");

            // === Pincode === //
            WebElement pincode = driver.findElement(By.id("pincode"));
            pincode.sendKeys("110066");



            //==current addresss
            WebElement currentAddress=driver.findElement(By.id("RelativeAddress"));
            currentAddress.sendKeys("Delhi");

            // === City ===
            WebElement city = driver.findElement(By.id("City"));
            city.sendKeys("Delhi");

            // === Name Fields ===
            driver.findElement(By.id("FirstName")).sendKeys("Vicky");
            driver.findElement(By.id("LastName")).sendKeys("Rexwal");

            // === Date of Birth ===
            WebElement dobInput = driver.findElement(By.id("dob"));
            dobInput.click();
            Thread.sleep(1000);

            Select yearSelect = new Select(driver.findElement(By.className("ui-datepicker-year")));
            yearSelect.selectByVisibleText("2002");

            Select monthSelect = new Select(driver.findElement(By.className("ui-datepicker-month")));
            monthSelect.selectByVisibleText("Oct");

            driver.findElement(By.xpath("//a[text()='10']")).click();

            // === Gender ===
//            WebElement gender = driver.findElement(By.xpath("//select[@name='gender']"));
//            Select genderSelect = new Select(gender);
//            genderSelect.selectByVisibleText("Male");


            // === Gender Dropdown ===
            try {
                // Step 1: Click on the visible dropdown button
                WebElement genderDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("gender-button")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderDropdown);
                Thread.sleep(500);

                try {
                    genderDropdown.click();
                } catch (ElementClickInterceptedException e) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", genderDropdown);
                }

                // Step 2: Select "Male" option
                WebElement maleOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='Male']")));
                maleOption.click();

//                // Step 3: (Optional) Verify selected value
//                WebElement selectedGender = driver.findElement(By.id("gender-button"));
//                System.out.println("✅ Selected Gender: " + selectedGender.getText());

            } catch (Exception e) {
                System.out.println("❌ Error selecting Gender: " + e.getMessage());
            }

            // === Mobile Number ===
            driver.findElement(By.id("MobileNo")).sendKeys("9876543210");

            // === Email ===
            driver.findElement(By.id("EmailID")).sendKeys("test@gmail.com");

            // === Resident Status ===
            WebElement residentStatus = driver.findElement(By.xpath("//*[@id='PL-personal-detail']/div[8]/div/div/label[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", residentStatus);

            // === Pancard ===
            driver.findElement(By.id("pancard")).sendKeys("DAOPQ2279R");

            // === Loan Purpose ===
//            Select loanPurpose = new Select(driver.findElement(By.id("loan_purpose")));
//            loanPurpose.selectByVisibleText("Education");
            // === Loan Purpose Dropdown ===
            try {
                // Step 1: Scroll to and click on visible dropdown button
                WebElement loanPurposeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("loan_purpose-button")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loanPurposeDropdown);
                Thread.sleep(500);

                try {
                    loanPurposeDropdown.click();
                } catch (ElementClickInterceptedException e) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loanPurposeDropdown);
                }

                // Step 2: Select "Education" option from dropdown
                WebElement educationOption = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//li[normalize-space()='Education']")));
                educationOption.click();

                // Step 3: (Optional) Verify selected value
                WebElement selectedPurpose = driver.findElement(By.id("loan_purpose-button"));
                System.out.println("✅ Selected Loan Purpose: " + selectedPurpose.getText());

            } catch (Exception e) {
                System.out.println("❌ Error selecting Loan Purpose: " + e.getMessage());
            }


            // === Education Qualification ===
//            Select education = new Select(driver.findElement(By.id("education_qualification")));
//            education.selectByVisibleText("Masters");


            // === Education Qualification Dropdown ===
            try {
                // Step 1: Scroll to and click on the visible dropdown button
                WebElement educationDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("education_qualification-button")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", educationDropdown);
                Thread.sleep(500);

                try {
                    educationDropdown.click();
                } catch (ElementClickInterceptedException e) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", educationDropdown);
                }

                // Step 2: Select "Masters" from the dropdown
                WebElement mastersOption = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//li[normalize-space()='Masters']")));
                mastersOption.click();

                // Step 3: (Optional) Verify selected value
                WebElement selectedEducation = driver.findElement(By.id("education_qualification-button"));
                System.out.println("✅ Selected Education Qualification: " + selectedEducation.getText());

            } catch (Exception e) {
                System.out.println("❌ Error selecting Education Qualification: " + e.getMessage());
            }


            // === Mother’s Name ===
            driver.findElement(By.id("MotherName")).sendKeys("Rani");

            // === Work Experience ===
            driver.findElement(By.id("workExperience")).sendKeys("1");

            // === Company Name ===
            driver.findElement(By.id("CompanyName")).sendKeys("Wishfin");

            // === Official Email ===
            driver.findElement(By.id("official_email_id")).sendKeys("test@wishfin.com");

            // === Accept Terms Checkbox ===
            WebElement acceptBox = driver.findElement(By.id("accept"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acceptBox);

            // === Submit Button ===
            WebElement submitButton = driver.findElement(By.id("submitbutton"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

            System.out.println("✅ Personal Loan Form Submitted Successfully!");

        } catch (Exception e) {
            System.out.println("❌ Error occurred while filling the form:");
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);


        }
    }


}
