package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Register {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    public Topic_04_Register() {
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
    }
    String username, pass;
    @Test
    public void TC_01_Rigester (){
        //truy cập vao trang https://demo.guru99.com/v4/
        //nhập email bất kì
        //Click submit
        //Get user và pass lưu va biến
        username=driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
        pass=driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();

    }

    @Test
    public void TC_02_Login() {
        //truy cập trang login
        //nhập user và pass
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("uid")).sendKeys(pass);
    }

    @AfterClass
    public void afterClass() {
        this.driver.quit();
    }
}
