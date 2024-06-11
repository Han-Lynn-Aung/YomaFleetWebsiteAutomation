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
public class SignUpCorporateTest {
    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "C:\\FireFoxDriver\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        options.setAcceptInsecureCerts(true);
        options.addPreference("devtools.debugger.remote-enabled", true);
        js = (JavascriptExecutor) driver;


    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void signUpTestCorporateWithEmptyField() {
        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1270, 744));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xxs\\3Ahidden > .text-textBlack:nth-child(2)")));
        element.click();
        driver.findElement(By.cssSelector("label:nth-child(1) > .ml-2")).click();
        driver.findElement(By.cssSelector(".disabled\\3Aopacity-50")).click();
        js.executeScript("window.scrollTo(0,785.3333129882812)");
        driver.findElement(By.cssSelector(".max-w-\\[200px\\]")).click();
    }
    @Test
    public void signUpTestCorporateWithValidCredentials() {
        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1270, 744));
        {

            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xxs\\3Ahidden > .text-textBlack:nth-child(2)")));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }

        driver.findElement(By.cssSelector(".xxs\\3Ahidden > .text-textBlack:nth-child(2)")).click();
        driver.findElement(By.cssSelector("label:nth-child(1) > .ml-2")).click();
        driver.findElement(By.cssSelector(".disabled\\3Aopacity-50")).click();

        WebElement joinNow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".select__control--is-focused .select__input-container")));
        joinNow.click();
        WebElement select = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-type-option-0")));
        select.click();

        driver.findElement(By.cssSelector(".select__value-container--has-value > .select__input-container")).click();
        driver.findElement(By.id("react-select-type-option-1")).click();
        driver.findElement(By.cssSelector(".select__value-container--has-value")).click();
        driver.findElement(By.id("react-select-type-option-2")).click();
        driver.findElement(By.cssSelector(".select__control--is-focused")).click();
        driver.findElement(By.id("react-select-type-option-3")).click();
        driver.findElement(By.id("company_name")).click();
        driver.findElement(By.id("company_name")).sendKeys("Something");
        driver.findElement(By.cssSelector(".col-span-1 .selector")).click();
        driver.findElement(By.id("react-select-industry-option-0")).click();
        driver.findElement(By.cssSelector(".select__control--is-focused .select__input-container")).click();
        driver.findElement(By.id("react-select-industry-option-1")).click();
        driver.findElement(By.cssSelector(".select__control--is-focused .select__input-container")).click();
        driver.findElement(By.id("react-select-industry-option-2")).click();
        driver.findElement(By.cssSelector(".select__control--is-focused > .select__value-container")).click();
        driver.findElement(By.id("react-select-industry-option-3")).click();
        driver.findElement(By.cssSelector(".select__control--is-focused .select__input-container")).click();
        driver.findElement(By.id("react-select-industry-option-4")).click();
        driver.findElement(By.cssSelector(".select__control--is-focused .select__input-container")).click();
        driver.findElement(By.id("react-select-industry-option-5")).click();
        driver.findElement(By.cssSelector(".select__control--is-focused .select__input-container")).click();
        driver.findElement(By.id("react-select-industry-option-6")).click();
        driver.findElement(By.cssSelector(".select__control--is-focused .select__input-container")).click();
        driver.findElement(By.id("react-select-industry-option-7")).click();
        driver.findElement(By.cssSelector(".select__control--is-focused .select__input-container")).click();
        driver.findElement(By.id("react-select-industry-option-1")).click();
        driver.findElement(By.id("contact_person")).click();
        driver.findElement(By.id("contact_person")).sendKeys("Thin Pyant Hlaing");
        driver.findElement(By.id("job_title")).click();
        driver.findElement(By.id("job_title")).sendKeys("QA");
        js.executeScript("window.scrollTo(0,894)");
        driver.findElement(By.cssSelector(".selector:nth-child(1)")).click();
        driver.findElement(By.id("react-select-country_code-option-151")).click();
        driver.findElement(By.id("national_number")).click();
        driver.findElement(By.id("national_number")).sendKeys("9421145770");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("thinpyanthlaing94@gmail.com");
        driver.findElement(By.cssSelector(".max-w-\\[200px\\]")).click();

        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".swal-button")));
        submit.click();
    }
}
