package webdriver;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Alert {
    WebDriver driver;
    WebDriverWait expliciWait;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    public Topic_13_Alert() {
    }

    @BeforeClass
    public void beforeClass() {
        this.driver = new FirefoxDriver();
       expliciWait=new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void TC_01_Accept_Alert (){
    driver.get("https://automationfc.github.io/basic-form/index.html");
    driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        sleepInSecond(3);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();
        sleepInSecond(3);
        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked an alert successfully");
    }

    @Test
    public void TC_02_Confirm_Alert() {

    }
    @Test
    public void TC_03_Prompt_Alert() {

    }
    @Test
    public void TC_04_Authentication_Alert() {
    driver.get("https://the-internet.herokuapp.com/basic_auth");

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
