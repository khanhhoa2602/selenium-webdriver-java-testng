package webdriver;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_DefaultDropdown {

  WebDriver driver;
 String firstname="Khanh",lastname="Hoa",password="123456",email=getEmail();
 String selectDay="13",selectMonth="November",selectYear="1996";
  public Topic_09_DefaultDropdown() {
  }

  @BeforeClass
  public void beforeClass() {

    this.driver = new FirefoxDriver();
    this.driver.manage().window().maximize();
  }

  @Test
  public void TC_01_Register() {
    driver.get("https://demo.nopcommerce.com/");
    driver.findElement(By.cssSelector("a[class='ico-register']")).click();
    sleepInSecond(3);
    driver.findElement(By.cssSelector("#FirstName")).sendKeys(firstname);
    driver.findElement(By.cssSelector("#LastName")).sendKeys(lastname);

    Select day=new Select(driver.findElement(By.name("DateOfBirthDay")));
    // chọn ngày
    day.selectByVisibleText(selectDay);
    //verify multi-choices
    Assert.assertFalse(day.isMultiple());
    List<WebElement> dayOption=day.getOptions();
    Assert.assertEquals(dayOption.size(),32);


    new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(selectMonth);
    new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(selectYear);


    driver.findElement(By.cssSelector("#Email")).sendKeys(email);
    driver.findElement(By.cssSelector("#Password")).sendKeys(password);
    driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
    driver.findElement(By.cssSelector("#register-button")).click();
    sleepInSecond(5);

    Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");
  }

  @Test
  public void TC_02_Login() {
    driver.get("https://demo.nopcommerce.com/");
    driver.findElement(By.cssSelector("a.ico-login")).click();
    sleepInSecond(3);
    driver.findElement(By.cssSelector("#Email")).sendKeys(email);
    driver.findElement(By.cssSelector("#Password")).sendKeys(password);
    driver.findElement(By.cssSelector("button.login-button")).click();
    sleepInSecond(5);
    driver.findElement(By.cssSelector("a.ico-account")).click();

    Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),selectDay);
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
    return "automation"+ new Random().nextInt(99999)+"@gmail.com";
  }
}
