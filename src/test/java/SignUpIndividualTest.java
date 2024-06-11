import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpIndividualTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "C:\\FireFoxDriver\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        options.setAcceptInsecureCerts(true);
        options.addPreference("devtools.debugger.remote-enabled", true);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void signUpTestIndividualWithEmptyField() {

        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1268, 742));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xxs\\3Ahidden > .text-textBlack:nth-child(2)")));
        element.click();
        driver.findElement(By.cssSelector(".dark\\3A border-transparent")).click();
        driver.findElement(By.cssSelector(".text-xs")).click();

    }
    @Test
    public void signUpTestIndividualWithExistEmail() {

        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1270, 744));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xxs\\3Ahidden > .text-textBlack:nth-child(2)")));
        element.click();
        driver.findElement(By.cssSelector(".dark\\3A border-transparent")).click();
        driver.findElement(By.id("fullName")).click();
        driver.findElement(By.id("fullName")).click();
        driver.findElement(By.id("fullName")).sendKeys("Thin Pyant Hlaing");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("thinpyanthlaing94@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("confirmPassword")).click();
        driver.findElement(By.id("confirmPassword")).sendKeys("12345678");
        driver.findElement(By.cssSelector(".text-xs")).click();
        driver.findElement(By.id("fullName")).click();

    }

    @Test
    public void signUpTestIndividualWithInvalidName() {
        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1270, 744));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xxs\\:hidden > .text-textBlack:nth-child(2)")));
        element.click();
        driver.findElement(By.cssSelector(".dark\\:border-transparent")).click();


        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("thinpyanthlaing94@gmail.com");

        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("134567");
        {
            WebElement username = driver.findElement(By.id("username"));
            Actions builder = new Actions(driver);
            builder.doubleClick(username).perform();
        }
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("wrongEmail@gmail.com");

        driver.findElement(By.id("confirmPassword")).click();
        driver.findElement(By.id("confirmPassword")).sendKeys("12345678");

        driver.findElement(By.id("fullName")).click();
        driver.findElement(By.id("fullName")).sendKeys("#$3s");

        driver.findElement(By.cssSelector(".max-w-\\[200px\\]")).click();
    }

    @Test
    public void signUpTestIndividualWithInvalidPassword() {
        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1270, 744));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xxs\\3Ahidden > .text-textBlack:nth-child(2)")));
        element.click();
        driver.findElement(By.cssSelector(".dark\\3A border-transparent")).click();
        WebElement fullName = wait.until(ExpectedConditions.elementToBeClickable(By.id("fullName")));
        fullName.click();
        driver.findElement(By.id("fullName")).sendKeys("Thin Pyant Hlaing");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("wrongEmail@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("dlfjdskaflsadkfkjdsalfjdslafjldskjflsadf");
        driver.findElement(By.id("confirmPassword")).click();
        driver.findElement(By.id("confirmPassword")).sendKeys("lfkjsadlkjdsflksjafdkaasdkfjlsdaf");
        driver.findElement(By.cssSelector(".max-w-\\[200px\\]")).click();
        driver.findElement(By.cssSelector(".max-w-\\[200px\\]")).click();

    }
    @Test
    public void signUpTestIndividualWithValidCredentials() {
        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1270, 744));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Sign Up')])[2]")));
        element.click();
        driver.findElement(By.cssSelector(".dark\\3A border-transparent")).click();
        WebElement fullName = wait.until(ExpectedConditions.elementToBeClickable(By.id("fullName")));
        fullName.click();
        driver.findElement(By.id("fullName")).sendKeys("Thin Pyant Hlaing");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("lynn471997@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("confirmPassword")).click();
        driver.findElement(By.id("confirmPassword")).sendKeys("12345678");
        driver.findElement(By.cssSelector(".text-xs")).click();
    }
}
