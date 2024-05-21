package Week3.TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tables {

    private final WebDriver driver;
    private final By Button = By.xpath("//a[normalize-space()='Tables']");
    private final By price = By.xpath("//td[text()='Oranges']/following-sibling::td");
    public Tables(WebDriver driver) {
        this.driver = driver;
    }

    public void testTables() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(Button));
        scrollToElement(button);

        try {
            button.click();
        }catch (Exception e){
            System.out.println("Nomal click failed");
            javaScriptClick(button);
        }
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void javaScriptClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void TableItem(){

        String getText =driver.findElement(price).getText();
        System.out.println("The price of oranges is"+getText);
    }


}

