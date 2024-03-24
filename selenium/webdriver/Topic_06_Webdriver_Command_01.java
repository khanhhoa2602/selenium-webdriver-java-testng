package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Webdriver_Command_01 {
    WebDriver driver;
    public Topic_06_Webdriver_Command_01(){

    }
    @BeforeClass
    public void beforeClass(){
        driver= new FirefoxDriver();
        //implicitlyWait dùng để chờ element dk tìm thấy
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void TC_01 (){
        //Mở ra url: hàm get
        driver.get("https://www.facebook.com/khanhhoa2602/");
        // đóng 1 tab đang thao tac
        driver.close();
        //đóng trình duyet (khong quan tâm có bnhiu tab)
        driver.quit();

    }
}
