package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunc {
        private final String HOME_PAGE_URL = "rus.delfi.lv";
        private WebDriver driver;
        private WebDriverWait wait;

        public BaseFunc(){
            System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 20);
        }

        public void goToUrl(String url) {
            if (!url.startsWith("http://") && !url.startsWith("https://")){
                url = "http://" + url;
            }

            driver.get(url);
        }

        public void openHomePage(){
            goToUrl(HOME_PAGE_URL);
        }

        public List<WebElement> findElements(By locator) {
            return driver.findElements(locator);
        }

        public WebElement findElement(By locator) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            WebElement element = null;
            try {
                element = driver.findElement(locator);
            }
            catch (Exception ex)
            {
                element = null;
            }

            return element;
        }

        public String getElementContent(By locator){
            WebElement foundElement = findElement(locator);

            if(foundElement == null)
                return null;

            String elementContent = foundElement.getText();

            return elementContent;
        }

        public void click(WebElement webElement) {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        }

    public int getElementValueAsInt(WebElement element) {
        String value = element.getText().replaceAll("\\D", "");
        return Integer.parseInt(value);
    }
}
