package Week3.TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class formFiledTest {
    WebDriver driver;
        public void formFields(WebDriver driver){
            this.driver=driver;

        }
        By button = By.xpath("//a[normalize-space()='Form Fields']");
        public void clickOnButton(){
            WebElement Button = driver.findElement(button);
            Button.click();
        }
    }

