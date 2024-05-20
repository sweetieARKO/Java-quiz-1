package Week3.TestClasses;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Objects;

public class formFields{
  private final WebDriver driver;
    public formFields(WebDriver driver){
        this.driver=driver;

    }
   private final By button = By.xpath("//a[normalize-space()='Form Fields']");
   private final By name = By.xpath("//input[@id='name']");
    private final By drink = By.xpath("//input[@id='drink1']");
    private final By color = By.xpath("(//input[@id='color2'])[1]");
    private final  By siblings = By.xpath("//select[@id='siblings']");
    private final  By Email = By.xpath("//input[@id='email']");
    private final By Message = By.xpath("//textarea[@id='message']");
    private  final By submit = By.xpath("//button[@id='submit-btn']");
    public void clickOnButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Button = driver.findElement(button);
        Button.click();
        WebElement Name = driver.findElement(name);
        Name.sendKeys("Abigail Arko");
        WebElement Drink = driver.findElement(drink);
        Drink.click();
        WebElement colorElement = wait.until(ExpectedConditions.elementToBeClickable(color));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", colorElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", colorElement);
        Select dropdown = new Select(driver.findElement(siblings));
        dropdown.selectByVisibleText("Yes");
        WebElement email = driver.findElement(Email);
        email.sendKeys("arko.abigail@amalitech.com");
        WebElement fillmessage = driver.findElement(Message);
        fillmessage.sendKeys("I have filled all the input of this forms");
        WebElement button = driver.findElement(submit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.alertIsPresent());
        Alert alert =driver.switchTo().alert();
        String actualMessage = alert.getText();
        System.out.println(actualMessage);
        String expected_Message = ("Message received!");
        Assert.assertEquals(actualMessage, expected_Message);
    }
}
