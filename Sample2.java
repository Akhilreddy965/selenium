import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SeleniumGoogleSearch {
    public static void main(String[] args) {
        // Set path to ChromeDriver (Update path accordingly)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open Google
            driver.get("https://www.google.com");

            // Maximize browser window
            driver.manage().window().maximize();

            // Locate search box and enter a query
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");
            searchBox.sendKeys(Keys.RETURN);

            // Wait for results to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

            // Retrieve search results
            List<WebElement> results = driver.findElements(By.cssSelector("h3"));

            // Print search result titles
            System.out.println("Top Search Results:");
            for (int i = 0; i < Math.min(results.size(), 5); i++) {
                System.out.println((i + 1) + ". " + results.get(i).getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
