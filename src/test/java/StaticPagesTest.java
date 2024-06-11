
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class StaticPagesTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "C:\\FireFoxDriver\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        options.setAcceptInsecureCerts(true);
        options.addPreference("devtools.debugger.remote-enabled", true);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }
    @Test
    public void staticPagesTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.get("https://carshare.yomafleet.com/");
        driver.manage().window().setSize(new Dimension(1268, 742));
        js.executeScript("window.scrollTo(0,453.3333435058594)");
        js.executeScript("window.scrollTo(0,1184)");
        driver.findElement(By.linkText("Find A Car")).click();
        driver.findElement(By.linkText("Locations")).click();
        js.executeScript("window.scrollTo(0,0)");
        js.executeScript("window.scrollTo(0,82)");
        driver.findElement(By.linkText("Corporate")).click();
        driver.findElement(By.linkText("Corporate")).click();
        driver.findElement(By.linkText("Benefits")).click();
        driver.findElement(By.linkText("FAQ")).click();
        driver.findElement(By.cssSelector("#headlessui-disclosure-button-17 > .font-bold")).click();
        driver.findElement(By.cssSelector("#headlessui-disclosure-button-18 > .font-bold")).click();
        driver.findElement(By.cssSelector("#headlessui-disclosure-button-19 > .font-bold")).click();
        driver.findElement(By.cssSelector("#headlessui-disclosure-button-20 > .font-bold")).click();
        driver.findElement(By.linkText("Policy")).click();
        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.cssSelector("li:nth-child(7) > .text-gray-400")).click();
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.linkText("www.yomacarshare.com")).click();
        vars.put("win536", waitForWindow(2000));
        vars.put("root", driver.getWindowHandle());
        driver.switchTo().window(vars.get("win536").toString());
        js.executeScript("window.scrollTo(0,1169.3333740234375)");
        driver.findElement(By.linkText("Terms and Conditions")).click();
        WebElement title = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(2) .title")));
        title.click();
        driver.findElement(By.linkText("privacy policy")).click();
        js.executeScript("window.scrollTo(0,260)");
        driver.findElement(By.linkText("Yoma Fleet Limited")).click();
        driver.switchTo().window(vars.get("root").toString());
        driver.findElement(By.linkText("Yoma Group")).click();
        driver.switchTo().window(vars.get("win536").toString());
        driver.switchTo().window(vars.get("root").toString());
        driver.findElement(By.linkText("Why Yoma Car Share?")).click();
        driver.findElement(By.linkText("How Yoma Car Share works")).click();
        js.executeScript("window.scrollTo(0,269.3333435058594)");
        js.executeScript("window.scrollTo(0,876)");
        driver.findElement(By.linkText("About Us")).click();
        driver.findElement(By.linkText("Click Here.")).click();
        js.executeScript("window.scrollTo(0,1593.3333740234375)");
        driver.findElement(By.linkText("About Us")).click();
        WebElement text = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dark\\3Atext-textWhite:nth-child(4) > .text-primary")));
        text.click();
        WebElement seftDrive = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Self-Drive Tips")));
        seftDrive.click();
        driver.findElement(By.linkText("Starter Pack")).click();
        driver.findElement(By.linkText("Contact Us")).click();
        driver.findElement(By.id("full_name")).click();
        driver.findElement(By.cssSelector(".selector:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".css-15lsz6c-indicatorContainer > .css-8mmkcg")).click();
        driver.findElement(By.cssSelector("div:nth-child(4) > .mb-3")).click();
        driver.findElement(By.id("react-select-2-placeholder")).click();
        driver.findElement(By.linkText("Feedback")).click();
        driver.findElement(By.cssSelector(".font-frank-new")).click();
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".xs\\3A flex-col > a:nth-child(1) img")).click();
        vars.put("win8416", waitForWindow(2000));
        driver.switchTo().window(vars.get("win8416").toString());
        driver.close();
        driver.switchTo().window(vars.get("root").toString());
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".xs\\3A flex-col > a:nth-child(2) img")).click();
        vars.put("win8023", waitForWindow(2000));
        driver.switchTo().window(vars.get("win8023").toString());
        driver.close();
        driver.switchTo().window(vars.get("root").toString());
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".xs\\3A flex-col > a:nth-child(3) img")).click();
        vars.put("win4833", waitForWindow(2000));
        driver.switchTo().window(vars.get("win4833").toString());
        driver.close();
        driver.switchTo().window(vars.get("root").toString());
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".flex:nth-child(4) > a:nth-child(1) img")).click();
        vars.put("win3097", waitForWindow(2000));
        driver.switchTo().window(vars.get("win3097").toString());
        driver.close();
        driver.switchTo().window(vars.get("root").toString());
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".flex:nth-child(4) > a:nth-child(2) img")).click();
        vars.put("win6431", waitForWindow(2000));
        driver.switchTo().window(vars.get("win6431").toString());
        driver.close();
        driver.switchTo().window(vars.get("root").toString());
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".flex:nth-child(4) > a:nth-child(3) img")).click();
        vars.put("win9221", waitForWindow(2000));
        driver.switchTo().window(vars.get("win9221").toString());
        driver.close();
        driver.switchTo().window(vars.get("root").toString());
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector("a:nth-child(4) img")).click();
        vars.put("win977", waitForWindow(2000));
        driver.switchTo().window(vars.get("win977").toString());
        driver.close();
        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().window(vars.get("win536").toString());
        driver.close();
        driver.switchTo().window(vars.get("root").toString());
    }
}
