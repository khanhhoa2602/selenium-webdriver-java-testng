package webdriver;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_CustomDropdown {
    WebDriver driver;
    WebDriverWait explicitWait;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    public Topic_10_CustomDropdown() {
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
        explicitWait= new WebDriverWait(driver, Duration.ofSeconds(30));
    }
//    @Test
    public void TC_01_Jquery (){
    driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
    selectItemInDropdown("#number-button","#number-menu div","15");
    sleepInSecond(3);
    driver.navigate().refresh();
    selectItemInDropdown("#number-button","#number-menu div","8");
    Assert.assertEquals(driver.findElement(By.cssSelector("#number-button span[class='ui-selectmenu-text']")).getText(),"9");
    }

    //@Test
    public void TC_02_React() {
driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
selectItemInDropdown("i.dropdown.icon","div.visible.menu.transition div span","Jenny Hess");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Jenny Hess");
    }
    //@Test
    public void TC_03_VueJS(){
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInDropdown("span.caret","ul.dropdown-menu a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(),"Second Option");

    }
    @Test
    public void TC_04_EditTable(){
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemInEditTableDropdown("input.search","div.visible.menu.transition span","Afghanistan");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Afghanistan");
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
    public void selectItemInDropdown(String parentCss,String chilrentCss,String itemTextExpected){
        //click vao 1 item de dropdown hien thi ra
        driver.findElement(By.cssSelector(parentCss)).click();
        //wait cho den khi load het tat ca cac item xuat hien day du trong HTML
        List<WebElement> allItems=explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
            (By.cssSelector(chilrentCss)));
        // allItems dang chua 19 items ben trong
        for(WebElement item:allItems){
            String textItem=item.getText();
            if (textItem.equals(itemTextExpected)) {
                item.click();
                break;
            }

        }
    }
    public void selectItemInEditTableDropdown(String parentCss,String chilrentCss,String itemTextExpected){
        //nhap du lieu
        driver.findElement(By.cssSelector(parentCss)).clear();
        driver.findElement(By.cssSelector(parentCss)).sendKeys(itemTextExpected);
        //wait cho den khi load het tat ca cac item xuat hien day du trong HTML
        List<WebElement> allItems=explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
            (By.cssSelector(chilrentCss)));
        // allItems dang chua 19 items ben trong
        for(WebElement item:allItems){
            String textItem=item.getText();
            if (textItem.equals(itemTextExpected)) {
                item.click();
                break;
            }

        }
    }
}
