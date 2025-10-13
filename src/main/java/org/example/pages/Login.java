package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {


      public void login(){
          //setup a driver
          WebDriver driver=new ChromeDriver();
          driver.get("http://vbsca.ca/login/login.asp");
          driver.manage().window().maximize();

          WebElement username=driver.findElement(By.name("txtUsername"));
          username.sendKeys("Vivek Mishra");

          WebElement password=driver.findElement(By.name("txtPassword"));
          password.sendKeys("mishra");

          WebElement submit=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input"));
          submit.click();
          System.out.println("Process Complete");

      }


}
