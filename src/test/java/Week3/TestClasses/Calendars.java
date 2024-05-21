package Week3.TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Calendars {
    private final WebDriver driver;
    private final By button = By.xpath("//a[normalize-space()='Calendars']");
    private final By datepicker = By.xpath("//input[@id='g1065-selectorenteradate']");
    private final By calendar = By.xpath("//div[@id='ui-datepicker-div']");
    private final By month = By.xpath("//span[@class='ui-datepicker-month']");
    private final By year = By.xpath("//span[@class='ui-datepicker-year']");
    private final By next = By.xpath("//a[@title='Next']");

    private final By day = By.xpath("//a[normalize-space()='8']");
    private final  By button2 =By.xpath("//div[@class='entry-content']//button[@type='submit'][normalize-space()='Submit']");
    private final By successMessage = By.xpath("//h4[@id='contact-form-success-header']");

    public Calendars(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCalendarButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(button));
        scrollToElement(buttonElement);

        try {
            buttonElement.click();
        } catch (Exception e) {
            System.out.println("Normal click failed, attempting JavaScript click.");
            javascriptClick(buttonElement);
        }
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void javascriptClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void setDatepicker(String targetMonth, String targetYear, String targetDay) {
        WebElement datepick = driver.findElement(datepicker);
        datepick.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjusted for more reliability
        WebElement nextButton;

        while (true) {
            WebElement monthsElement = driver.findElement(month);
            WebElement yearsElement = driver.findElement(year);

            // Correct the comparison by using getText() to compare the element's text with the target strings
            if (monthsElement.getText().equals(targetMonth) && yearsElement.getText().equals(targetYear)) {
                // Locate the day in the current month view and click
                List<WebElement> days = driver.findElements(By.xpath("//a[contains(@class,'ui-state-default')]")); // Assuming day elements have a common class
                boolean dayClicked = false;
                for (WebElement dayElement : days) {
                    if (dayElement.getText().equals(targetDay)) {
                        dayElement.click();
                        dayClicked = true;
                        break;
                    }
                }


                if (dayClicked) {
                    System.out.println("Selected Date: " + targetDay + " " + targetMonth + " " + targetYear);
                    break; // Exit the loop once the day is successfully clicked
                } else {
                    System.out.println("Day not found in the selected month and year.");
                    break;
                }
            } else {
                // Click the "Next" button to go to the next month if the current month and year do not match
                nextButton = driver.findElement(next);
                wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
            }
        }

    }
    public void setDay(){
    WebElement Day =  driver.findElement(day);
    Day.click();
    }
    public void clickButton(){
        WebElement click = driver.findElement(button2);
        click.click();
    }
    public void setSuccessMessage(){
        WebElement success = driver.findElement(successMessage);

    }
}