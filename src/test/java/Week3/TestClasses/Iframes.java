package Week3.TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Iframes {
    private final WebDriver driver;
    private final By buttonLocator = By.xpath("//a[normalize-space()='Iframes']");
    private final By firstIframe = By.xpath("(//iframe[@id='frame2'])[1]");
    public Iframes(WebDriver driver) {
        this.driver = driver;

    }
    public void testIframes(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        scrollToElement(button);
        try {
            button.click();
        }catch (Exception e){
            System.out.println("Normal click failed");
            javaSCriptClick(button);
        }
    }
    private void scrollToElement(WebElement element){
    (   (JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",element);
    }
    private void javaSCriptClick(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click(true);",element);
    }
    public void setFirstIframe(){
        driver.switchTo().frame(0);
        WebElement setIframe = driver.findElement(firstIframe);
        driver.switchTo().frame(setIframe);

    }
}
