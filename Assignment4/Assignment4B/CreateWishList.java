package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateWishList {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateWishList() throws Exception {
    driver.get("https://www.amazon.ca/");
    driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']/span[2]")).click();
    driver.findElement(By.id("ap_email")).clear();
    driver.findElement(By.id("ap_email")).sendKeys("artin.rezaee@deliverus.ca");
    driver.findElement(By.xpath("//input[@id='continue']")).click();
    driver.findElement(By.id("ap_password")).clear();
    driver.findElement(By.id("ap_password")).sendKeys("Helloworld438");
    driver.findElement(By.id("signInSubmit")).click();
    driver.findElement(By.xpath("//a[@id='nav-link-wishlist']/span")).click();
    driver.findElement(By.id("createList-announce")).click();
    driver.findElement(By.id("editYourList")).click();
    driver.findElement(By.id("list-settings-name")).click();
    driver.findElement(By.id("list-settings-name")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=list-settings-name | ]]
    driver.findElement(By.id("list-settings-name")).click();
    driver.findElement(By.id("list-settings-name")).clear();
    driver.findElement(By.id("list-settings-name")).sendKeys("New List");
    driver.findElement(By.id("submitForm")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
