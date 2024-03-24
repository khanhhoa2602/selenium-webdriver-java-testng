package webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_WebElement_Command {

  WebDriver driver;

  public Topic_07_WebElement_Command() {

  }

  @BeforeClass
  public void beforeClass() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void TC_01_Displayed() {
    driver.get("https://automationfc.github.io/basic-form/index.html");
    //Kiểm tra hiển thị
    if (driver.findElement(By.cssSelector("input#mail")).isDisplayed())

    {
      driver.findElement(By.cssSelector("input#mail")).sendKeys("Automation Testing");
    }
    else
      System.out.println("Email is not display");


    if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed())

    {
      driver.findElement(By.cssSelector("input#under_18")).click();
    }
    else
      System.out.println("under18 is not display");

    if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed())

    {
      driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing");
    }
    else
      System.out.println("Education is not display");
//   Assert.assertTrue(driver.findElement(By.cssSelector("input#mail")).isEnabled());
//   Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isEnabled());
//    Assert.assertTrue(driver.findElement(By.cssSelector("textarea#edu")).isEnabled());
    //Kiểm tra ko hiển thị
    if (driver.findElement(By.xpath("//h5[contains(text(),'User5')]")).isDisplayed())

    {
      System.out.println("Name User 5 is display");
    }
    else
      System.out.println("Name User 5 is not display");

//    Assert.assertFalse(driver.findElement(By.xpath("//h5[contains(text(),'User5')]")).isEnabled());
  }

  @Test
  public void TC_02_Enabled() {
    driver.get("https://automationfc.github.io/basic-form/index.html");

    if (driver.findElement(By.cssSelector("input#mail")).isEnabled())

    {
      System.out.println("Email is enable");
    }
    else
      System.out.println("Email is disable");


    if (driver.findElement(By.cssSelector("input#under_18")).isEnabled())

    {
      System.out.println("Under18 is enable");
    }
    else
      System.out.println("under18 is disable");

    if (driver.findElement(By.cssSelector("textarea#edu")).isEnabled())

    {
      System.out.println("Education is enable");
    }
    else
      System.out.println("Education is disable");

    if (driver.findElement(By.cssSelector("select#job1")).isEnabled())

    {
      System.out.println("Job Role 01 is enable");
    }
    else
      System.out.println("Job Role 01 is disable");

    if (driver.findElement(By.cssSelector("input#development")).isEnabled())

    {
      System.out.println("Job Role 01 is enable");
    }
    else
      System.out.println("Job Role 01 is disable");


    if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled())

    {
      System.out.println("Password is enable");
    }
    else
      System.out.println("Password is disable");
  }

  @Test
  public void TC_03_Selected() {
    driver.get("https://automationfc.github.io/basic-form/index.html");
    driver.findElement(By.cssSelector("input#under_18")).click();
    driver.findElement(By.cssSelector("input#java")).click();
    Assert.assertTrue(driver.findElement(By.cssSelector("input#under_18")).isSelected());
    Assert.assertTrue(driver.findElement(By.cssSelector("input#java")).isSelected());
    sleepInSecond(2);
    driver.findElement(By.cssSelector("input#java")).click();
    Assert.assertFalse(driver.findElement(By.cssSelector("input#java")).isSelected());

  }

  @Test
  public void TC_04_MailChimp() {
  driver.get("https://login.mailchimp.com/signup/");
  driver.findElement(By.cssSelector("input#email")).sendKeys("hoadtk@gmail.com");
  //case 1: number

  driver.findElement(By.cssSelector("input#new_password")).sendKeys("123");

  Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char not-completed']")).isDisplayed());
  Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
  Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char completed']")).isDisplayed());
  Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
  Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
  Assert.assertTrue(driver.findElement(By.cssSelector("li[class='username-check completed']")).isDisplayed());

  //case 2: lower case
    driver.findElement(By.cssSelector("input#new_password")).clear();
    driver.findElement(By.cssSelector("input#new_password")).sendKeys("abc");

    Assert.assertTrue(driver.findElement(By.cssSelector("li[class='lowercase-char completed']")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("li[class='uppercase-char not-completed']")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("li[class='number-char not-completed']")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("li[class='special-char not-completed']")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.cssSelector("li[class='username-check completed']")).isDisplayed());
  }

  @AfterClass
  public void afterClass() {

//    this.driver.quit();
  }
  public void sleepInSecond(long timeInSecond) {
    try {
      Thread.sleep(timeInSecond * 1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }


}
