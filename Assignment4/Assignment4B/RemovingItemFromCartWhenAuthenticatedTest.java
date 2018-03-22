package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RemovingItemFromCartWhenAuthenticatedTest {
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
  public void testRemovingItemFromCartWhenAuthenticated() throws Exception {
    driver.get("https://www.amazon.com/");
    driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']/a/span")).click();
    driver.findElement(By.id("ap_email")).clear();
    driver.findElement(By.id("ap_email")).sendKeys("Artin.rezaee@deliverus.ca");
    driver.findElement(By.xpath("//input[@id='continue']")).click();
    driver.findElement(By.id("ap_password")).clear();
    driver.findElement(By.id("ap_password")).sendKeys("Helloworld438");
    driver.findElement(By.id("signInSubmit")).click();
    driver.findElement(By.linkText("Gift Cards")).click();
    driver.findElement(By.xpath("//img[@alt='Print-at-Home']")).click();
    driver.findElement(By.id("gc-buy-box-atc")).click();
    driver.findElement(By.id("hlb-view-cart-announce")).click();
    driver.findElement(By.xpath("//input[@value='Delete']")).click();
    driver.findElement(By.xpath("//a[@id='nav-item-signout-sa']/span")).click();
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
