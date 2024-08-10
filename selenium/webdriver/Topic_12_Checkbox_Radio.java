package webdriver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Checkbox_Radio {

  WebDriver driver;
  String projectPath = System.getProperty("user.dir");
  String osName = System.getProperty("os.name");

  public Topic_12_Checkbox_Radio() {
  }

  @BeforeClass
  public void beforeClass() {
    if (this.osName.contains("Windows")) {
      System.setProperty("webdriver.gecko.driver",
          this.projectPath + "\\browserDrivers\\geckodriver.exe");
    } else {
      System.setProperty("webdriver.gecko.driver",
          this.projectPath + "/browserDrivers/geckodriver");
    }

    this.driver = new FirefoxDriver();
    this.driver.manage().window().maximize();
  }

//  @Test
//  public void TC_01_Default_Checkbox() {
//    driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
//    By dualZoneCheckbox=By.cssSelector(
//        "//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
//    By dualZoneCheckbox_Checked=By.cssSelector(
//        "//label[text()='Rear side airbags']/preceding-sibling::span/input");
//    checkToElement(dualZoneCheckbox);
//    checkToElement(dualZoneCheckbox_Checked);
//    //verify Checkbox da duoc chon thanh cong
//    Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());
//    Assert.assertTrue(driver.findElement(dualZoneCheckbox_Checked).isSelected());
//
//      //Bo chon
//    uncheckToElement(dualZoneCheckbox);
//    uncheckToElement(dualZoneCheckbox_Checked);
//    //verify Checkbox da duoc bo chon thanh cong
//    Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());
//    Assert.assertFalse(driver.findElement(dualZoneCheckbox_Checked).isSelected());
//  }

//  @Test
//  public void TC_02_Default_Radio() {
//    driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
//    By carEngineRadio=By.cssSelector(
//        "//label[text()='1.8 Petrol, 118kW']/preceding-sibling::span/input");
//
//
//  }
//  @Test
//  public void TC_03_Select_All_Checkbox()
//  {
//    driver.get("https://automationfc.github.io/multiple-fields/");
//    //chon het tat ca cac checkbox trong man hinh
//  List<WebElement> allCheckbox =driver.findElements(By.cssSelector("input.form-checkbox"));
//   for (WebElement checkbox:allCheckbox){
//     if(!checkbox.isSelected()){
//      checkbox.click();
//     }
//   }
//   //Verify checkbox duoc chon
//    for (WebElement checkbox:allCheckbox){
//      Assert.assertTrue(checkbox.isSelected());
//    }
//    //bo chon tat ca cac checkbox
//    driver.manage().deleteAllCookies();
//    driver.navigate().refresh();
//    //chon 1 checkbox trong tat ca cac checkbox
//    allCheckbox =driver.findElements(By.cssSelector("input.form-checkbox"));
//    for (WebElement checkbox:allCheckbox){
//      if(checkbox.getAttribute("value").equals("Neurological Disorders")&&!checkbox.isSelected()){
//        checkbox.click();
//      }
//    }
//    for (WebElement checkbox:allCheckbox){
//      if(checkbox.getAttribute("value").equals("Neurological Disorders")){
//        Assert.assertTrue(checkbox.isSelected());
//      }
//      else Assert.assertFalse(checkbox.isSelected());
//    }
//  }
//  @Test
//public void TC_04_Customer_Checkbox{
//
//  }

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
  public void checkToElement(By byXpath){
    if(!driver.findElement(byXpath).isSelected()){
      driver.findElement(byXpath).click();
      sleepInSecond(2);
    }
  }
  public void uncheckToElement(By byXpath){
    if(!driver.findElement(byXpath).isSelected()){
      driver.findElement(byXpath).click();
      sleepInSecond(2);
    }
  }
}
