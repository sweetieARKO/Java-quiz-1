package Week3.PageClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Week3.TestClasses.Calendars;

public class CalendarsTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Assuming you've set up WebDriverManager properly
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://practice-automation.com");
    }

    @Test
    public void testCalendarFunctionality() throws InterruptedException {
        Calendars calendars = new Calendars(driver);
        calendars.clickOnCalendarButton();
        calendars.setDatepicker("June", "2025", "08");
        calendars.setDay();
        calendars.clickButton();
    }
    @AfterTest
    public void AfterTest(){
        driver.quit();
    }
}
