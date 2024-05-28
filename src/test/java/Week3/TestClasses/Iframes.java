package Week3.TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Iframes {
    private final WebDriver driver;
    private final By buttonLocator = By.xpath("//a[normalize-space()='Iframes']");
    private final By firstIframe = By.xpath("//iframe[@id='frame2']");
    private final By closeButton = By.xpath("/html/body/div[4]/div[2]/button");
    private final By login = By.xpath("//*[@id='fitt-analytics']/div[2]/div/div/div/div/nav/ul/li[1]/div/div/button");
    private final By mainFrame = By.xpath("//*[@id='root']/div[3]/div");
    private final By emailFrame = By.xpath("//*[@id='root']/div[3]/div/div[2]/div/div");
    private final By email = By.xpath("//*[@id='root']/div[3]/div/div[2]/div/div/form/div[2]");

    public Iframes(WebDriver driver) {
        this.driver = driver;
    }

    public void testIframes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        Actions actions = new Actions(driver);
        actions.moveToElement(button)
                .perform();
        button.click();
    }

    public void setFirstIframe() {
        driver.switchTo().frame(0);
        WebDriverWait waitPrompt = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitPrompt.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[2]/div[3]/button[2]"))).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div[8]/div[1]/div/div/div[3]/div[2]/div[2]/div[3]/a")));
//iframe.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(iframe)
                .perform();
        iframe.click();

    }
}