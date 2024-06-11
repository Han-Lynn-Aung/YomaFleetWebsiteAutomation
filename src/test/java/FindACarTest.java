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

public class FindACarTest {
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
    public void findACarTestWithDiffLocation() {
        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1268, 742));

        try {
            WebElement locationDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".css-1jydm44-container")));
            locationDropdown.click();

            WebElement pickupLocation = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-pickup_location-option-0-0")));
            pickupLocation.click();

            WebElement formCheckLabel = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".form-check-label")));
            formCheckLabel.click();

            WebElement returnLocationContainer = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".select__control--is-focused .select__input-container")));
            returnLocationContainer.click();

            WebElement returnLocation = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-return_location-option-1-1")));
            returnLocation.click();

            WebElement pickupDate = wait.until(ExpectedConditions.elementToBeClickable(By.name("pickup_date")));
            pickupDate.click();
            driver.findElement(By.cssSelector(".open .flatpickr-next-month")).click();
            driver.findElement(By.cssSelector(".open .flatpickr-day:nth-child(12)")).click();
            pickupDate.sendKeys("12-07-2024");

            WebElement returnDate = wait.until(ExpectedConditions.elementToBeClickable(By.name("return_date")));
            returnDate.click();
            driver.findElement(By.cssSelector(".open .flatpickr-day:nth-child(13)")).click();
            returnDate.sendKeys("16-07-2024");

            WebElement returnTime = wait.until(ExpectedConditions.elementToBeClickable(By.name("return_time")));
            returnTime.click();

            WebElement gridElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".grid:nth-child(6) > .mb-3:nth-child(2) > .font-medium")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridElement);
            gridElement.click();

            WebElement simulateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("SimulateButton")));
            simulateButton.click();

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");

            WebElement indicatorContainer = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".css-15lsz6c-indicatorContainer:nth-child(1) > .css-8mmkcg")));
            indicatorContainer.click();

            WebElement xxlElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".xxl\\3Apy-3")));
            xxlElement.click();

        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void findACarTestWithValidInput() {
        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1268, 742));

        driver.findElement(By.cssSelector(".css-1jydm44-container")).click();
        js.executeScript("window.scrollTo(0,62)");
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-pickup_location-option-0-0")));
        option.click();
        driver.findElement(By.name("pickup_date")).click();
        driver.findElement(By.cssSelector(".open .today")).click();
        driver.findElement(By.name("pickup_date")).sendKeys("11-06-2024");
        driver.findElement(By.name("pickup_time")).click();
        driver.findElement(By.cssSelector(".open .numInputWrapper:nth-child(3) > .arrowUp")).click();
        driver.findElement(By.name("pickup_time")).sendKeys("1:00 PM");
        driver.findElement(By.cssSelector(".grid:nth-child(5) > .mb-3:nth-child(1) > .font-medium")).click();
        driver.findElement(By.name("return_date")).click();
        driver.findElement(By.cssSelector(".open .today")).click();
        driver.findElement(By.name("return_date")).sendKeys("11-06-2024");
        driver.findElement(By.name("return_time")).click();
        driver.findElement(By.cssSelector(".open .numInputWrapper:nth-child(3) > .arrowDown")).click();
        driver.findElement(By.cssSelector(".open .flatpickr-hour")).click();
        driver.findElement(By.cssSelector(".open .numInputWrapper:nth-child(1) > .arrowDown")).click();
        driver.findElement(By.cssSelector(".open .numInputWrapper:nth-child(1) > .arrowUp")).click();
        driver.findElement(By.name("return_time")).sendKeys("2:59 PM");
        driver.findElement(By.cssSelector(".open .numInputWrapper:nth-child(1) > .arrowUp")).click();
        driver.findElement(By.name("return_time")).sendKeys("3:59 PM");
        driver.findElement(By.cssSelector(".open .numInputWrapper:nth-child(1) > .arrowUp")).click();
        driver.findElement(By.name("return_time")).sendKeys("4:59 PM");
        driver.findElement(By.id("SimulateButton")).click();
        js.executeScript("window.scrollTo(0,0)");
        js.executeScript("window.scrollTo(0,143.3333282470703)");
        {
            WebElement element = driver.findElement(By.cssSelector(".leading-tight"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".leading-tight"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".leading-tight"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".leading-tight")).click();

    }
    @Test
    public void findACarTestWithlessthan15minutes() {
        driver.get("https://carshare.yomafleet.com/");
        driver.manage().window().setSize(new Dimension(1268, 742));
        driver.findElement(By.cssSelector(".css-1jydm44-container")).click();
        driver.findElement(By.id("react-select-pickup_location-option-0-0")).click();
        driver.findElement(By.name("pickup_date")).click();
        driver.findElement(By.cssSelector(".open .flatpickr-day:nth-child(16)")).click();
        driver.findElement(By.cssSelector(".open .flatpickr-next-month")).click();
        driver.findElement(By.cssSelector(".open .flatpickr-monthDropdown-months")).click();
        driver.findElement(By.cssSelector(".open .flatpickr-monthDropdown-months")).click();
        driver.findElement(By.cssSelector(".open .flatpickr-prev-month > svg")).click();
        driver.findElement(By.cssSelector(".open .flatpickr-day:nth-child(18)")).click();
        driver.findElement(By.name("pickup_date")).sendKeys("12-06-2024");
        driver.findElement(By.name("pickup_date")).click();
        driver.findElement(By.cssSelector(".arrowBottom .today")).click();
        driver.findElement(By.name("pickup_date")).sendKeys("11-06-2024");
        driver.findElement(By.name("return_date")).click();
        driver.findElement(By.cssSelector(".open .today")).click();
        driver.findElement(By.name("return_date")).sendKeys("11-06-2024");
        driver.findElement(By.id("SimulateButton")).click();
        js.executeScript("window.scrollTo(0,153.3333282470703)");

    }
    @Test
    public void moreTestListOne() {
        driver.get("https://carshare.yomafleet.com/");
        driver.manage().window().setSize(new Dimension(1268, 742));
        driver.findElement(By.cssSelector("#headlessui-menu-button-1 > span:nth-child(2)")).click();
        driver.findElement(By.id("headlessui-menu-item-4")).click();
        driver.findElement(By.cssSelector("span:nth-child(2)")).click();
        driver.findElement(By.id("headlessui-menu-item-18")).click();
        js.executeScript("window.scrollTo(0,210)");
        js.executeScript("window.scrollTo(0,418)");
        driver.findElement(By.cssSelector("#headlessui-menu-button-25 > span:nth-child(2)")).click();
        driver.findElement(By.id("headlessui-menu-item-36")).click();
        driver.findElement(By.cssSelector("span:nth-child(2)")).click();
        driver.findElement(By.id("headlessui-menu-item-50")).click();
        driver.findElement(By.cssSelector("#headlessui-menu-button-53 > span:nth-child(2)")).click();
        driver.findElement(By.id("headlessui-menu-item-68")).click();

    }
    @Test
    public void moreTestListTwo() {
        driver.get("https://carshare.yomafleet.com/");
        driver.manage().window().setSize(new Dimension(1268, 742));
        driver.findElement(By.cssSelector("#headlessui-menu-button-1 > span:nth-child(2)")).click();
        driver.findElement(By.id("headlessui-menu-item-5")).click();
        driver.findElement(By.cssSelector("span:nth-child(2)")).click();
        driver.findElement(By.id("headlessui-menu-item-140")).click();
        driver.findElement(By.cssSelector("span:nth-child(2)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector("span:nth-child(2)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.id("headlessui-menu-item-154")).click();
        driver.findElement(By.cssSelector("#headlessui-menu-button-158 > span:nth-child(2)")).click();
        driver.findElement(By.id("headlessui-menu-item-168")).click();

    }
    @Test
    public void locationsTest() {
        driver.get("https://carshare.yomafleet.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().setSize(new Dimension(1268, 742));
        driver.findElement(By.cssSelector(".text-textBlack:nth-child(4)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".text-textBlack:nth-child(4)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".select__control")).click();
        driver.findElement(By.id("react-select-2-option-0")).click();
        driver.findElement(By.cssSelector(".css-8mmkcg")).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-2-option-1")));
        element.click();
        driver.findElement(By.cssSelector(".select__dropdown-indicator > .css-8mmkcg")).click();
        driver.findElement(By.id("react-select-2-option-2")).click();
        driver.findElement(By.cssSelector(".select__dropdown-indicator > .css-8mmkcg")).click();
        driver.findElement(By.id("react-select-2-option-3")).click();
        driver.findElement(By.cssSelector(".select__dropdown-indicator > .css-8mmkcg")).click();
        driver.findElement(By.id("react-select-2-option-4")).click();

    }
}
