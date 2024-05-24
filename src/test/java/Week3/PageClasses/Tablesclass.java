package Week3.PageClasses;

import Week3.TestClasses.Tables;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tablesclass {
    private WebDriver driver;
    public JavascriptExecutor js =(JavascriptExecutor) null;
    private final By table = By.xpath("//table[@id='tablepress-1']");

    @BeforeClass
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/");
        js=(JavascriptExecutor) driver;
    }

    @Test
    public void myTestTable() {
        Tables tables = new Tables(driver);  // Pass the WebDriver instance
        tables.testTables();  // Call the method to test tables
        tables.tableItem();
        System.out.println("me");
    }

@Test
    public void sortTable(){
        Tables in = new Tables(driver);
        in.getPopulation("United States");
        in.getPopulation("Ghana");



}

}
