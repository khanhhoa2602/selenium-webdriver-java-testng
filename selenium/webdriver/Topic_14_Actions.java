package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Actions {
    WebDriver driver;
    Actions actions;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    public Topic_14_Actions() {
    }

    @BeforeClass
    public void beforeClass() {
        if (this.osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", this.projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", this.projectPath + "/browserDrivers/geckodriver");
        }

        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        actions=new Actions(driver);
    }
    @Test
    public void TC_01 (){

    }

    @Test
    public void TC_02() {

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
