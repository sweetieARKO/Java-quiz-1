package Week3.TestClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Popups {
    private final WebDriver driver;

    public Popups(WebDriver driver) {
        this.driver = driver;
    }

    private final By button = By.xpath("//a[.='Popups']");
    private final By alert = By.id("alert");
    private final By confirmPopup = By.id("confirm");
    private final By prompt = By.id("prompt"); // Assuming proper ID for the prompt

    public void popUp() {
        WebElement Button = driver.findElement(button);
        Button.click();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("popups"), "URL does not contain 'popups'");
    }

    public void alertPopup() {
        driver.findElement(alert).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void confirmPopUp() {
        driver.findElement(confirmPopup).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void promptPopUp(String text) {
        driver.findElement(prompt).click();
        Alert promptAlert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        promptAlert.sendKeys(text);
        promptAlert.accept();
    }
}
