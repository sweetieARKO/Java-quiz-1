package Week3.TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Tables {

    private final WebDriver driver;
    private final By Button = By.xpath("//a[normalize-space()='Tables']");
    private final By price = By.xpath("//td[text()='Oranges']/following-sibling::td");
    private final By lapTops = By.xpath("//td[normalize-space()='Laptop']/following-sibling::td");
    private final By marables = By.xpath("//td[.='Marbles']/following-sibling::td");
    private final By countries = By.xpath("//table[@id='tablepress-1']//tbody/tr/td[2]");
    private final By nextPageButton = By.xpath("//a[@id='tablepress-1_next']");
    private final By disableNext = By.xpath("//a[@class='paginate_button next disabled']");
    private final By search = By.id("search-input-id"); // Replace with actual search input field locator
    private  final By following =By.xpath("//td[normalize-space()='United States']/following-sibling::td");
    public Tables(WebDriver driver) {
        this.driver = driver;
    }

    public void testTables() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(Button));
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

    public void TableItem() {
        String getText = driver.findElement(price).getText();
        System.out.println("The price of oranges is " + getText);
        String LaptopPrice = driver.findElement(lapTops).getText();
        System.out.println("The price of laptop is " + LaptopPrice);
        String Marable = driver.findElement(marables).getText();
        System.out.println("The price of the marbles " + Marable);
    }

    public String getPopulation(String country) {
        boolean foundCountry = false;
        String population = "-1"; // Default value if country is not found
        while (!foundCountry) {
            List<WebElement> countryList = driver.findElements(countries);
            List<WebElement> nextDisabled = driver.findElements(disableNext);
            for (WebElement countryElement : countryList) {
                if (countryElement.getText().trim().equals(country)) {
                    WebElement populationElement = countryElement.findElement(By.xpath("./following-sibling::td"));
                    population = populationElement.getText().trim();
                    foundCountry = true;
                    break;
                }
            }
            if (!foundCountry && nextDisabled.isEmpty()) {
                WebElement button = driver.findElement(nextPageButton);
                scrollToElement(button); // Ensure the button is in view
                try {
                    button.click();
                } catch (Exception e) {
                    javaScriptClick(button); // Use JavaScript click if normal click fails
                }
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.stalenessOf(countryList.get(0))); // Wait for the next page to load
            } else if (!foundCountry && !nextDisabled.isEmpty()) {
                break; // Exit the loop if the country is not found and next page button is disabled
            }
        }
        return population;
    }

    public void FindSiblings() {
    WebElement sibling = driver.findElement(following);
    String following = sibling.getText();
        System.out.println("United States has a population of "+ following + "people.");
    }
}