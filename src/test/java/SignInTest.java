import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInTest {
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
    public void signInWithInvalidEmail() {
        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1268, 742));

        try {
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xxs\\3Ahidden > .text-textBlack:nth-child(1)")));
            signInButton.click();

            // Perform actions
            driver.findElement(By.id("username")).click();
            driver.findElement(By.id("username")).sendKeys("wrongEmail@gmail.com");
            driver.findElement(By.id("password")).click();
            driver.findElement(By.id("password")).sendKeys("lfdsafue");
            driver.findElement(By.cssSelector(".text-xs")).click();
        } catch (StaleElementReferenceException e) {
            // Retry logic or handle the exception as needed
            System.out.println("Element is stale, retrying...");
            WebElement retryElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xxs\\3Ahidden > .text-textBlack:nth-child(1)")));
            retryElement.click();
            // Perform actions after retry
            driver.findElement(By.id("username")).click();
            driver.findElement(By.id("username")).sendKeys("wrongEmail@gmail.com");
            driver.findElement(By.id("password")).click();
            driver.findElement(By.id("password")).sendKeys("lfdsafue");
            driver.findElement(By.cssSelector(".text-xs")).click();
        }
    }


    @Test
    public void signInWithInvalidPassword() {

        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1268, 742));

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xxs\\3Ahidden > .text-textBlack:nth-child(1)")));
        signInButton.click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("thinpyanthlaing94@gmail.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("fdslfkakd");
        driver.findElement(By.cssSelector(".text-xs")).click();
    }

    @Test
    public void signInWithValidCredentials() {
        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1268, 742));

        try {
            // Click on the initial element to trigger the sign-in process
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xxs\\3Ahidden > .text-textBlack:nth-child(1)")));
            signInButton.click();

            WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
            usernameField.sendKeys("thinpyanthlaing94@gmail.com");

            WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
            passwordField.sendKeys("thin12345");

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-xs")));
            loginButton.click();

        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException occurred. Retrying...");
            signInWithValidCredentials(); // Retry the method
        }
    }

    @Test
    public void signWithEmptyField() {
        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1268, 742));

        try {
            WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xxs\\3Ahidden > .text-textBlack:nth-child(1)")));
            signInButton.click();

            WebElement otherElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text-xs")));
            otherElement.click();

        } catch (StaleElementReferenceException e) {

            System.out.println("StaleElementReferenceException occurred. Retrying...");
            signWithEmptyField(); // Retry the method
        }
    }

}
