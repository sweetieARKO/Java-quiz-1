package Week3.PageClasses;

import Week3.TestClasses.Popups;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class popupClass {
    WebDriver driver;

    @BeforeTest()
    public void setDriver(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com");
    }
    @Test()
    public void testAlertPopUp() throws InterruptedException {
        Popups popups = new Popups(driver);
        popups.popUp();
        popups.alertPopup();
        popups.confirmPopUp();
        popups.promptPopUp("Good");
}
@AfterTest()
    public void afterTest() throws InterruptedException {
        driver.quit();

}


}
