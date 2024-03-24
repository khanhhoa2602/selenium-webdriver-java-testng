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

public class Topic_02_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    public Topic_02_Selenium_Locator() {
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
        this.driver.get("https://demo.nopcommerce.com/register");
    }
    @Test
    //All version:

    //selenium có 8 loại locator
    // id/ class/ name = trùng 3 attribute cua HTML
    //linktext / parital linktext (HTML link: the a)
    //tagname : ten the
    //Css/ Xpath

    //Ver 4.x them: (GUI: test giao dien)
    //Class -Relative Locator
    //above/bellow/near/leafOf/rightOf
    public void TC_01_ID (){
        //tìm vị trí của label Remember me qua các vị trí liên quan
        this.driver.get("https://demo.nopcommerce.com/login");
        By btnloginbutton= By.cssSelector("button-1 login-button");
//        WebElement btn_login =driver.findElement(By.cssSelector("button-1 login-button"));
        By checkbox=By.name("RememberMe");
        WebElement labelRememberMe=driver.findElement(RelativeLocator.with(By.tagName("label")).above(btnloginbutton));
        System.out.println(labelRememberMe.getText());

    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className ("menu-toggle"));

    }
    @Test
    public void TC_03_Name() {
    driver.findElement(By.name("LastName"));
    }
    @Test
    public void TC_04_TagName() {
        driver.findElement(By.tagName("input"));
    }
    @Test
    public void TC_05_LinkText() {
    driver.findElement(By.linkText("nopCommerce"));
    //độ chính xác tuyệt đối
    }
    @Test
    public void TC_06_Partial_LinkText() {
        //độ chính xác không cao
    driver.findElement(By.partialLinkText("Commerce"));

    }
    @Test
    public void TC_07_CSS() {
    driver.findElement(By.cssSelector("input[id='FirstName']"));
    driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));
        //tương tự với class, name, tagname
    }
    @Test
    public void TC_08_XPath() {
        driver.findElement(By.xpath("//input[@id='FirstName']"));
    }


    @AfterClass
    public void afterClass() {
//        this.driver.quit();
    }
}
