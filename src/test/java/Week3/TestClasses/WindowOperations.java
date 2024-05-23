package Week3.TestClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowOperations {

    private final WebDriver driver;
    private final By buttonLocator = By.xpath("//*[text()='Window Operations']");
    private final By newTabLocator = By.cssSelector("#post-1147 > div > p:nth-child(3) > button");
    private final By windowReplacer = By.xpath("//button[@onclick='newWindowSelf()']");

    public WindowOperations(WebDriver driver) {
        this.driver = driver;
    }

    public void performWindowOperations() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay-class")));
            Thread.sleep(300);
            if (button.isDisplayed() && button.isEnabled()) {
                try {
                    button.click();
                    System.out.println("Button clicked successfully.");
                } catch (Exception clickException) {
                    System.out.println("Regular click failed, attempting JavaScript click.");
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
                }
            } else {
                System.out.println("Button is not interactable.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to click the button: " + e.getMessage());
        }
    }

    public void accessNewTab() {
        String originalWindow = driver.getWindowHandle();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            // Wait for the button to be clickable
            WebElement newTabButton = wait.until(ExpectedConditions.elementToBeClickable(newTabLocator));

            newTabButton.click();
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newTabButton);


            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            Set<String> allWindows = driver.getWindowHandles();
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    System.out.println("Switched to new tab.");
                    System.out.println("New Url is " + driver.getCurrentUrl());
                    System.out.println("Title of new tab is " + driver.getTitle());
                    driver.close();
                    driver.wait(300);
                    break;
                }
          //      driver.findElement(windowReplacer).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to access the new tab: " + e.getMessage());

        }
    }
}