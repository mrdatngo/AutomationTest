package viettel.com;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hook {
    public static WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DATNT\\Desktop\\driver\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\DATNT\\Desktop\\driver\\geckodriver.exe");
        String browserName =  System.getProperty("browser", "chrome");
        if (browserName.equalsIgnoreCase("chrome")) {
            this.driver = new ChromeDriver();
        } else {
            this.driver = new FirefoxDriver();
        }
    }

    @After
    public void quit(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
//        this.driver.quit();
    }
}
