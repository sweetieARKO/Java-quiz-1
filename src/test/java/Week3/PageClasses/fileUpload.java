package Week3.PageClasses;

import Week3.TestClasses.FileUpload;
import Week3.TestClasses.WindowOperations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class fileUpload {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/");
    }
    @Test
    public void Upload(){
        FileUpload Upload = new FileUpload(driver);
        Upload.testFileUpload();
        Upload.choosefile("C:\\Users\\AbigailNyameyieArko\\Documents\\Artificial Intelligence - Course Schedule.pdf");

    }

}
