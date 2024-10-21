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

        //login
        WebElement loginButton = driver.findElement(By.id("nav-link-accountList"));
        loginButton.click();

        //Pages and all items don't reload fast. We must wait a little bit. I wrote a function below the code for not repeat myself.
        letsWaitALittleBit();

        WebElement emailInput = driver.findElement(By.id("ap_email"));
        emailInput.sendKeys(""); //Input email
        emailInput.submit();

        //Same with line 39
        letsWaitALittleBit();

        WebElement inputPassword = driver.findElement(By.id("ap_password"));
        inputPassword.sendKeys(""); // Input password

        //Click the login button.
        WebElement signInButton = driver.findElement(By.id("signInSubmit"));
        signInButton.click();
        letsWaitALittleBit();

        //Input "iphone" to search bar.
        searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='twotabsearchtextbox']")));
        searchBox.sendKeys("iphone" + Keys.ENTER);

        WebElement firstItem = driver.findElement(By.cssSelector(".s-main-slot .s-result-item"));
        firstItem.click();
        letsWaitALittleBit();

        // Let's go to comments.
        WebElement goToComments = driver.findElement(By.id("acrCustomerReviewLink"));
        goToComments.click();

        // Yorumların yüklenmesini bekle
        letsWaitALittleBit();

        // Like the button with error message.
        List<WebElement> helpfulButtons = driver.findElements(By.className("cr-helpful-button"));

        if (helpfulButtons.size() > 0) {
            helpfulButtons.get(0).click();
            System.out.println("The comment is liked!");
        } else {
            System.out.println("Cannot find the like button.");
        }

        letsWaitALittleBit();

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

    void letsWaitALittleBit() {
        try {
            Thread.sleep(3000); // Yükleme için bekleme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
