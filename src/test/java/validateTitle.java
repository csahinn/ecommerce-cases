import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class validateTitle {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void verifyGoogleTitle() {

        if (driver != null) {
            driver.get("https://www.google.com");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String title = driver.getTitle();
            Assert.assertEquals(title, "Google");
            System.out.println("Title is : "+title);
        } else {
            System.out.println("Driver is null");
        }
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        } else {
            System.out.println("Driver is null, nothing to quit.");
        }
    }
}
