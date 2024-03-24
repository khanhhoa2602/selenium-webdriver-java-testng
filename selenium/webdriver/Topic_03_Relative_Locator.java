package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

class Topic_03_Relative_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    public Topic_03_Relative_Locator() {
    }

    @BeforeClass
    public void beforeClass() {
        if (this.osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", this.projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", this.projectPath + "/browserDrivers/geckodriver");
        }

        this.driver = new FirefoxDriver();
        this.driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.driver.get("https://demo.nopcommerce.com/login");
    }
    @Test
    public void TC_01_Relative(){
        //tìm vị trí của label Remember me qua các vị trí liên quan
        this.driver.get("https://demo.nopcommerce.com/login");
        By btnloginbutton= By.cssSelector("button.login-button");
//        WebElement btn_login =driver.findElement(By.cssSelector("button-1 login-button"));
        By checkbox=By.name("RememberMe");
        WebElement labelRememberMe=driver.findElement(RelativeLocator.with(By.tagName("label")).above(btnloginbutton));
        System.out.println(labelRememberMe.getText());

        //
        By inputEmail= By.id("Email");
        WebElement labelEmail= driver.findElement(RelativeLocator.with(By.tagName("label")).near(inputEmail));
        System.out.println(labelEmail.getText());
    }



    @AfterClass
    public void afterClass() {
        this.driver.quit();
    }
}
