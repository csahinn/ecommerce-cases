import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CustomerComments {
    private WebDriver driver;
    private WebElement searchBox;
    private String baseUrl;

    @BeforeMethod
    public void setUp() throws Exception { //Let's set up our configurations. Details on README.md.
        System.setProperty("webdriver.chrome.driver","C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.hepsiburada.com";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void inputProductNameToSearchBar() throws Exception { //Input product name to search bar and submit.
        driver.get(baseUrl);

        searchBox = driver.findElement(By.xpath("//input[@data-test-id='search-bar-input']"));
        searchBox.sendKeys("iphone");
        searchBox.sendKeys(Keys.RETURN);
        searchBox.submit();

        //WebElement acceptCookies = driver.findElement(new By.ByName(""));
        // acceptCookies.click();
    }

   /* @Test
    public void listProduct() { //list all products and click first child.
        List<WebElement> list = driver.findElements(new By.ByClassName("column"));
        System.out.println(list.size());
    }

    @Test
    public void listComments() { //list all comments of product.

    }

    */
@AfterMethod
    public void tearDown() throws Exception {
        if(driver != null) {
            driver.quit();
        }
    }

    /*
    public static void main(String[] args) {
        CustomerComments test = new CustomerComments();

        test.setUp();
        test.inputProductNameToSearchBar();
        test.tearDown();
    } */
}