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
import java.util.List;

public class FileDownload {
    private final WebDriver driver;

    private final By buttonLocator = By.xpath("//a[normalize-space()='File Download']");
    private final By buttonDownload = By.xpath("//a[@class='wpdm-download-link download-on-click btn btn-primary ']");
    private final By buttonlockDownload = By.xpath("//a[contains(@class,'wpdm-download-link wpdm-download-locked btn btn-primary')]");
    private final By passwordInput = By.xpath("//iframe[@id='wpdm-lock-frame']");
    private final By passwordButton = By.xpath("//input[@class='wpdm_submit btn btn-secondary']");
    private final By confirmDownlowad = By.xpath("//a[normalize-space()='Download']");

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
        String url = driver.getCurrentUrl();
        System.out.println("The url of this page is: "+url);
        String name = driver.getTitle();
        System.out.println("The Title of the current page is "+name);
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void javaScriptClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void setButtonDownload() {
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

    public void setButtonlockDownload() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonlockDownload));
        try {
            button.click();
        } catch (Exception e) {
            System.out.println("Normal click failed");
            javaScriptClick(button);
        }
    }


    public void setPasswordInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate and print all iframes on the page for debugging
        List<WebElement> iframes = driver.findElements(By.tagName("input"));
        System.out.println("Number of iframes on the page: " + iframes.size());
        for (WebElement iframe : iframes) {
            System.out.println("Iframe ID: " + iframe.getAttribute("id"));
        }

        // Wait for the specific iframe to be present and switch to it
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(passwordInput));
        System.out.println("Switching to iframe with ID: " + iframe.getAttribute("id"));
        driver.switchTo().frame(iframe);

        // Wait for the password input field to be present and interactable
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        System.out.println("Password input field is present and interactable.");

        // Type the password
        input.sendKeys("automateNow");
        System.out.println("Password entered successfully.");

        // Switch back to the default content after interacting with the iframe
        driver.switchTo().defaultContent();
        System.out.println("Switched back to the default content.");
    }

    public void clickOnSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Debugging: print all iframes on the page
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of iframes on the page: " + iframes.size());
        for (WebElement iframe : iframes) {
            System.out.println("Iframe ID: " + iframe.getAttribute("id"));
        }

        // Attempt to find and switch to the iframe containing the submit button
        boolean iframeFound = false;
        for (WebElement iframe : iframes) {
            driver.switchTo().frame(iframe);
            try {
                WebElement button = wait.until(ExpectedConditions.elementToBeClickable(passwordButton));
                iframeFound = true;
                button.click();
                System.out.println("Submit button clicked successfully.");
                break;
            } catch (Exception e) {
                // If the button is not found in this iframe, switch back to the default content and try the next iframe
                driver.switchTo().defaultContent();
            }
        }
    }

    public void setConfirmDownload() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Debugging: print all iframes on the page
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of iframes on the page: " + iframes.size());
        for (WebElement iframe : iframes) {
            System.out.println("Iframe ID: " + iframe.getAttribute("id"));
        }

        // Attempt to find and switch to the iframe containing the submit button
        boolean iframeFound = false;
        for (WebElement iframe : iframes) {
            driver.switchTo().frame(iframe);
            try {
                WebElement button = wait.until(ExpectedConditions.elementToBeClickable(confirmDownlowad));
                iframeFound = true;
                button.click();
                System.out.println("Submit button clicked successfully.");
                break;
            } catch (Exception e) {
                // If the button is not found in this iframe, switch back to the default content and try the next iframe
                driver.switchTo().defaultContent();
            }
        }
    }
}