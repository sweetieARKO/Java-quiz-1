package Week3.PageClasses;

import Week3.TestClasses.Slidertest;
import Week3.TestClasses.WindowOperations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class sliders {
    private WebDriver driver;
    Slidertest slidertest;

    @BeforeClass
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/");
        slidertest = new Slidertest(driver); // Initialize slidertest object
    }

    @Test
    public void Slider() throws InterruptedException {
        slidertest.ClickButton();
        slidertest.sliderClick();
    }
}
