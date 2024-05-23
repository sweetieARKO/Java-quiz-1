package Week3.TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WindowSameTab {
    public  final WebDriver driver;

    private final By windowReplacer = By.xpath("//button[contains(@onclick,'newWindowSelf()')]");

    public WindowSameTab(WebDriver driver) {
        this.driver = driver;
    }
    public void acessNewTab(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement WindowReplacer = wait.until(ExpectedConditions.elementToBeClickable(windowReplacer));
            WindowReplacer.click();
            System.out.println("click the link");

        }

catch (Exception e){
            e.printStackTrace();
    System.out.println("Faield to access"+ e.getMessage());
}
    }
}
