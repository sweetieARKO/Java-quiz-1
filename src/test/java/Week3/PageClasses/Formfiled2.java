package Week3.PageClasses;

import Week3.TestClasses.formFields;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Formfiled2 {
        WebDriver driver;

        @BeforeTest()
        public void driverInitializer() {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://practice-automation.com/");
        }

        @Test()
        public void testFormFields() {
            formFields test = new formFields(driver);
            test.clickOnButton();
            // Add further test steps here
        }
    }
