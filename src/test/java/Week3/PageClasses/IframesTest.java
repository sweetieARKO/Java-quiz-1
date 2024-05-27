package Week3.PageClasses;

import Week3.TestClasses.Iframes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IframesTest {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/");
    }

    @Test
    public void testIframes() {
        Iframes iframes = new Iframes(driver);
        iframes.testIframes();
    }
}
