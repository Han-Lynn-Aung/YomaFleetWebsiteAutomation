# YomaFleetWebsite Automation Selenium Setup

This project demonstrates how to set up and use Selenium WebDriver with either Chrome or Firefox in your test automation scripts. Below are the instructions for setting up the WebDriver and an example of the `@Before` method to initialize the WebDriver based on the browser choice.

## Prerequisites

1. **Java Development Kit (JDK)**: Ensure you have JDK 8 or higher installed.
2. **Maven**: Make sure Maven is installed and configured in your system.
3. **Chrome and/or Firefox Browser**: Ensure Chrome and/or Firefox are installed.
4. **ChromeDriver**: Download the ChromeDriver from [ChromeDriver downloads](https://sites.google.com/a/chromium.org/chromedriver/downloads) and place it in a known directory (e.g., `C:\\ChromeDriver\\chromedriver.exe`).
5. **GeckoDriver**: Download the GeckoDriver from [Mozilla GitHub](https://github.com/mozilla/geckodriver/releases) and place it in a known directory (e.g., `C:\\FireFoxDriver\\geckodriver.exe`).

## Project Setup

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/Han-Lynn-Aung/YomaFleetWebsiteAutomation
    cd your-repo
    ```

2. **Add Dependencies**:
    Ensure you have the following dependencies in your `pom.xml`:
    ```xml
    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.21.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/junit/junit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    ```

## WebDriver Setup

### `setUp` Method

The following `@Before` method sets up the WebDriver to use either Chrome or Firefox based on a system property:

```java
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverSetup {

    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "firefox");

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ##"\\your path\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ##"\\your path\\geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setAcceptInsecureCerts(true);
            options.addPreference("devtools.debugger.remote-enabled", true);
            driver = new FirefoxDriver(options);
        }

        js = (JavascriptExecutor) driver;
    }

    // Other test methods go here

}
