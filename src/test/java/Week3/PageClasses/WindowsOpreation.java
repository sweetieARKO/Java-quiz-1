package Week3.PageClasses;

import Week3.TestClasses.WindowOperations;

import Week3.TestClasses.WindowSameTab;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowsOpreation {

    private WebDriver driver;
    WindowOperations windowOperations;

    @BeforeClass
        public void setup() {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://practice-automation.com/");
        }
        @Test
        public void opentheOprearationsWindow() throws InterruptedException {
            windowOperations = new WindowOperations(driver);
            windowOperations.performWindowOperations();
            //Thread.sleep(30000);
            windowOperations = new WindowOperations(driver);
            windowOperations.accessNewTab();


        }
        @Test
    public void openInSameWindow(){
            WindowSameTab WindowSameTab = new WindowSameTab(driver);
            WindowSameTab.acessNewTab();
        }

    }

