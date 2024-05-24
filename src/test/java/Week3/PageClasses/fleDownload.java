package Week3.PageClasses;

import Week3.TestClasses.FileDownload;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class fleDownload {
    private WebDriver driver;
    FileDownload download;
        @BeforeClass
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/");
    }

@Test
    public void clickButton(){
     FileDownload download = new FileDownload(driver) ;
     download.testFileDownload();
     download.setButtonDownload();
     download.setButtonlockDownload();
}
}
