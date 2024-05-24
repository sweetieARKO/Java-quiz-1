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
    private final By button = By.xpath("//a[normalize-space()='Tables']");
    private final By price = By.xpath("//td[text()='Oranges']/following-sibling::td");
    private final By lapTops = By.xpath("//td[normalize-space()='Laptop']/following-sibling::td");
    private final By marables = By.xpath("//td[.='Marbles']/following-sibling::td");
    private final By countries = By.xpath("//table[@id='tablepress-1']//tbody/tr/td[2]");
    private final By nextPageButton = By.xpath("//a[@id='tablepress-1_next']");
    private final By disableNext = By.xpath("//a[@class='paginate_button next disabled']");
    private final By search = By.id("search-input-id"); // Replace with actual search input field locator
    private final By following = By.xpath("//td[normalize-space()='United States']/following-sibling::td");
    private final By table = By.xpath("//table[@id='tablepress-1']");

    public Tables(WebDriver driver) {
        this.driver = driver;
    }

    public void testTables() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(this.button));
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

    public void tableItem() {
        String getText = driver.findElement(price).getText();
        System.out.println("The price of oranges is " + getText);
        String laptopPrice = driver.findElement(lapTops).getText();
        System.out.println("The price of the laptop is " + laptopPrice);
        String marble = driver.findElement(marables).getText();
        System.out.println("The price of the marbles is " + marble);
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
                    System.out.println("the population of "+country +" is "+population);
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
                System.out.println(country+" is not found");
                break; // Exit the loop if the country is not found and next page button is disabled
            }
        }
        return population;
    }

    public void scrollToElementTable(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void findSiblings() {
        WebElement sibling = driver.findElement(table);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        scrollToElementTable((WebElement) table);
        wait.until(ExpectedConditions.visibilityOfElementLocated(following));
        String followingText = sibling.getText();
        System.out.println("United States has a population of " + followingText + " people.");
    }
}
