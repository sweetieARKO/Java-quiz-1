package Week3.TestClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileDownload {
    private final WebDriver driver;

    private final By buttonLocator = By.xpath("//a[normalize-space()='File Download']");
    private final By buttonDownload = By.xpath("//a[@class='wpdm-download-link download-on-click btn btn-primary ']");
    private final By buttonlockDownload = By.xpath("//a[contains(@class,'wpdm-download-link wpdm-download-locked btn btn-primary')]");
    public FileDownload(WebDriver driver) {
        this.driver = driver;
    }

    public void testFileDownload() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        scrollToElement(button);
        try {
            button.click();
        } catch (Exception e) {
            System.out.println("Normal click failed");
            javaScriptClick(button);
        }
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void javaScriptClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void setButtonDownload(){
     {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonDownload));
            try {
                button.click();
            } catch (Exception e) {
                System.out.println("Normal click failejd");
                javaScriptClick(button);
            }
        }
    }
    public void setButtonlockDownload(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonlockDownload));
        try {
            button.click();
        }
        catch (Exception e){
            System.out.println("Normal click failed");
            javaScriptClick(button);
        }
    }
}
