package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Textbox_Textarea {

  WebDriver driver;

  public Topic_08_Textbox_Textarea() {
  }

  @BeforeClass
  public void beforeClass() {

    this.driver = new FirefoxDriver();
    this.driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
    this.driver.manage().window().maximize();
  }

  @Test
  public void Login_01_Empty_Email_Password() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']"))
        .click();
    sleepInSecond(3);
    driver.findElement(By.cssSelector("button#send2")).click();
    Assert.assertEquals(
        driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(),
        "This is a required field.");
    Assert.assertEquals(
        driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(),
        "This is a required field.");
  }

  @Test
  public void Login_02_Invalid_Email() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']"))
        .click();
    sleepInSecond(3);
    driver.findElement(By.cssSelector("input#email")).sendKeys("dangt@1233");
    driver.findElement(By.cssSelector("input#pass")).sendKeys("1232322");
    driver.findElement(By.cssSelector("button#send2")).click();
    Assert.assertEquals(
        driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(),
        "Please enter a valid email address. For example johndoe@domain.com.");

  }

  @Test
  public void Login_03_Invalid_Password() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']"))
        .click();
    sleepInSecond(3);
    driver.findElement(By.cssSelector("input#email")).sendKeys("dangthikhanhhoa14a3@gmail.com");
    driver.findElement(By.cssSelector("input#pass")).sendKeys("12345");
    driver.findElement(By.cssSelector("button#send2")).click();
    Assert.assertEquals(
        driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(),
        "Please enter 6 or more characters without leading or trailing spaces.");
  }

  @Test
  public void Login_04_Incorrect_Email_Or_Password() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']"))
        .click();
    sleepInSecond(3);
    driver.findElement(By.cssSelector("input#email")).sendKeys("dangthikhanhhoa14a3@gmail.com");
    driver.findElement(By.cssSelector("input#pass")).sendKeys("1234523");
    driver.findElement(By.cssSelector("button#send2")).click();
    Assert.assertEquals(
        driver.findElement(By.xpath("//span[contains(text(),'Invalid login')]")).getText(),
        "Invalid login or password.");
  }

  @Test
  public void Login_05_Success() {
    driver.get("http://live.techpanda.org/");
    driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']"))
        .click();
    sleepInSecond(3);
    driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
    sleepInSecond(3);

    String firstname="Automation",lastname="FC",email=getEmail(),password="123456";
  String fullname=firstname+" "+lastname;
    driver.findElement(By.cssSelector("#firstname")).sendKeys(firstname);
    driver.findElement(By.cssSelector("#lastname")).sendKeys(lastname);
    driver.findElement(By.cssSelector("#email_address")).sendKeys(email);
    driver.findElement(By.cssSelector("#password")).sendKeys(password);
    driver.findElement(By.cssSelector("#confirmation")).sendKeys(password);
    driver.findElement(By.xpath("//button[@title='Register']")).click();
    sleepInSecond(3);
    Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");
    Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, "+fullname+"!");
    String contactInfo=driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
    Assert.assertTrue(contactInfo.contains(fullname));
    Assert.assertTrue(contactInfo.contains(email));

    //logout
    driver.findElement(By.cssSelector("div[class='account-cart-wrapper'] a span")).click();
    sleepInSecond(3);
    driver.findElement(By.cssSelector("a[title='Log Out']")).click();
    sleepInSecond(5);
    driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
    sleepInSecond(3);
    driver.findElement(By.cssSelector("input#email")).sendKeys(email);
    driver.findElement(By.cssSelector("input#pass")).sendKeys(password);
    driver.findElement(By.cssSelector("button#send2")).click();
    sleepInSecond(3);
    contactInfo=driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
    Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(),"Hello, "+fullname+"!");
    Assert.assertTrue(contactInfo.contains(fullname));
    Assert.assertTrue(contactInfo.contains(email));

    //verify information
    driver.findElement(By.xpath("//a[text()='Account Information']")).click();
    sleepInSecond(3);
    Assert.assertEquals(driver.findElement(By.cssSelector("#firstname")).getAttribute("value"),firstname);
    Assert.assertEquals(driver.findElement(By.cssSelector("#lastname")).getAttribute("value"),lastname);
    Assert.assertEquals(driver.findElement(By.cssSelector("#email")).getAttribute("value"),email);

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
  public String getEmail(){
    return "automation"+ new Random().nextInt(9999)+"@gmail.com";
  }

}
