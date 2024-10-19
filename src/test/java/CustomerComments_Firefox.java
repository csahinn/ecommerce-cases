import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CustomerComments_Firefox {
    private WebDriver driver;
    private WebElement searchBox;
    private String baseUrl;
    private AssertJUnit Assertions;

    @BeforeMethod
    public void setUp() throws Exception { //Let's set up our configurations. Details on README.md.
        System.setProperty("webdriver.firefox.driver","C:\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://www.amazon.com.tr";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    public void searchAndListProducts() throws InterruptedException { //Input product name to search bar and submit.
        driver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Input "iphone" to search bar.
        searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']")));
        searchBox.sendKeys("iphone" + Keys.ENTER);

        //List all search results.
        List<WebElement> productList = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        System.out.println("Number of products: "+productList.size());

        //Click the first item.
        if(!productList.isEmpty()) {
            System.out.println(productList.get(0));
            Thread.sleep(10000);
        } else {
            System.out.println("No items found.");
        }

        /* ACCEPT COOKIES AUTOMATICALLY
        WebElement acceptCookies = driver.findElement(new By.ByName(""));
        acceptCookies.click();
        */
    }
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
