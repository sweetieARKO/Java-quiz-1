package Week3.TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUpload {

    private final WebDriver driver;
    private final By button = By.xpath("//a[normalize-space()='File Upload']");
    private final By fileButton = By.xpath("//input[@id='file-upload']");
    private final By uploadButton = By.xpath("//input[@id='upload-btn']");
    private final By message = By.xpath("//div[@class='wpcf7-response-output']");
    public FileUpload(WebDriver driver) {
        this.driver = driver;
    }

    public void testFileUpload() {
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(this.button));
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
    public void choosefile(String filePath){
        WebElement fileinput = driver.findElement(fileButton);
        fileinput.sendKeys(filePath);
        WebElement button = driver.findElement(uploadButton);
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        String Messages = messageElement.getText();
        System.out.println(Messages);

    }
}
