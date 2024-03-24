package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Webdriver_Command_02 {

  WebDriver driver;

  public Topic_06_Webdriver_Command_02() {

  }

  @BeforeClass
  public void beforeClass() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void TC_01_Url() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']"))
        .click();
    sleepInSecond(3);
    Assert.assertEquals(driver.getCurrentUrl(),
        "http://live.techpanda.org/index.php/customer/account/login/");
    driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
    sleepInSecond(3);
    Assert.assertEquals(driver.getCurrentUrl(),
        "http://live.techpanda.org/index.php/customer/account/create/");
  }

  @Test
  public void TC_02_Title() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']"))
        .click();
    sleepInSecond(3);
    Assert.assertEquals(driver.getTitle(),"Customer Login");

  }

  @Test
  public void TC_03_Page_Navigation() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']"))
        .click();
    sleepInSecond(3);

    driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
    sleepInSecond(3);

    driver.navigate().back();
    sleepInSecond(3);

    Assert.assertEquals(driver.getCurrentUrl(),
        "http://live.techpanda.org/index.php/customer/account/login/");
    driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
    sleepInSecond(2);

    driver.navigate().forward();
    sleepInSecond(2);

    Assert.assertEquals(driver.getTitle(),"Create New Customer Account");


  }

  @Test
  public void TC_04_Page_Source() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']"))
        .click();
    sleepInSecond(3);
    Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

    driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
    sleepInSecond(3);

    Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
  }

  @AfterClass
  public void afterClass() {

    this.driver.quit();
  }

  public void sleepInSecond(long timeInSecond) {
    try {
      Thread.sleep(timeInSecond * 1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
