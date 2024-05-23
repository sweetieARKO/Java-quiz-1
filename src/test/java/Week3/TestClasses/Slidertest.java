package Week3.TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Slidertest {
    private final WebDriver driver;
    private final By ButtonLocator = By.xpath("//a[normalize-space()='Sliders']");
    private final By SliderElement = By.xpath("//input[@id='slideMe']");
    private final By Value = By.id("value");
    public Slidertest(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickButton() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(ButtonLocator));
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
        System.out.println(driver.getCurrentUrl());
    }

    public void sliderClick() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement newSlider = wait.until(ExpectedConditions.elementToBeClickable(SliderElement));
            newSlider.click();
            System.out.println("Value is " + Value);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to access the new tab: " + e.getMessage());
        }

    }
}
