package webdriver;

import javax.swing.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_HandleButton_Radio_Checkbox {
    WebDriver driver;

    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    public Topic_11_HandleButton_Radio_Checkbox() {
    }

    @BeforeClass
    public void beforeClass() {


        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();

    }
    @Test
    public void TC_01 (){
    driver.get("https://www.fahasa.com/customer/account/create");
    driver.findElement(By.cssSelector("li.popup-login-tab-item.popup-login-tab-login")).click();
    sleepInSecond(2);
        WebElement buttonLogin=driver.findElement(By.cssSelector("button.fhs-btn-login"));
    Assert.assertFalse(buttonLogin.isEnabled());
   System.out.println(buttonLogin.getCssValue("background-color"));
    Assert.assertEquals(Color.fromString(buttonLogin.getCssValue("background-color")).asHex().toLowerCase(),"#000000");
    sleepInSecond(2);
    driver.findElement(By.cssSelector("#login_username")).sendKeys("dangthikhanhhoa14a3@gmail.com");
    driver.findElement(By.cssSelector("#login_password")).sendKeys("123456@");
    Assert.assertTrue(buttonLogin.isEnabled());
      Assert.assertEquals(Color.fromString(buttonLogin.getCssValue("background-color")).asHex().toLowerCase(),"#c92127");

    //#C92127


    }

    @Test
    public void TC_02() {
      driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
     sleepInSecond(3);
     driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();
     sleepInSecond(2);
    WebElement element= driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']//preceding-sibling::span/input"));
      JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
      javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);",element);

      element.click();
//      Actions actions=new Actions(driver);
//      driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
//      sleepInSecond(3);
//      WebElement element= driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']//preceding-sibling::span/input"));
//      actions.scrollToElement(element).perform();
//      element.click();
//      driver.get("http://live.techpanda.org/index.php/about-magento-demo-store/");
//      sleepInSecond (3);
//      WebElement newsletterTextbox= driver.findElement(By.cssSelector("input#newsletter"));
//      actions.scrollToElement(newsletterTextbox).perform();
//      sleepInSecond (2);
//      newsletterTextbox.sendKeys("dam@gmail.com"); sleepInSecond(2);


    }

    @AfterClass
    public void afterClass() {
//        this.driver.quit();
    }
    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
