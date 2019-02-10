package Pages.Base;

import Constants.TimeoutsInSeconds;
import Selenium.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Extensions.ExtendedMethods.*;

/**
 *
 */
public class BaseWebPage extends BasePage {

    private static WebDriver _driver;

    protected BaseWebPage(WebDriver webDriver, String controlId) throws Exception {
        super(webDriver, controlId);
    }

    protected BaseWebPage(WebDriver webDriver, By controlId) throws Exception {
        super(webDriver, controlId);
    }

    protected BaseWebPage(WebDriver webDriver) throws Exception {
        super(webDriver);
    }

    private void WaitForLoadingToFinish() {
        WebDriverWait wait = new WebDriverWait(_driver, TimeoutsInSeconds.DefaultTimeout);
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(_driver -> !_driver.findElement(By.id("Loading")).isDisplayed());
    }

    private boolean IsCorrectPageDisplayed(String url) {
        return _driver.getCurrentUrl().trim().endsWith(url);
    }

    private static void WaitForElement(WebElement element) {
        element.isDisplayed();
    }

    protected static void HoverClick(WebElement webElement, WebElement subElement) {
        Actions actions = new Actions(_driver);
        WaitForElement(webElement);
        actions.moveToElement(webElement).perform();
        WaitForElement(subElement);
        actions.moveToElement(subElement);
        actions.click();
        actions.perform();
    }

    protected static void ClearTextAndEnterInElement(WebElement element, String textToEnter) {
        WaitForElement(element);
        element.clear();
        EnterText(element, _driver, textToEnter);
    }

    protected void SearchForThisAndSubmit(WebElement element, String value) {
        WaitForElement(element);
        EnterText(element, _driver, value);
        element.submit();
    }

    protected void GoToUrl(String appendedUrl) {
        String url = _driver.getCurrentUrl();
        _driver.navigate().to(url + appendedUrl);
    }

    protected void SwitchToFrame() {
        _driver.switchTo().frame("fContent");
    }

    protected static String GetTextFromField(WebElement element) throws InterruptedException {
        element.wait(); ;
        String text = element.getText();
        return text;
    }

    protected static String GetValueFromField(WebElement element, String elementAttribute) throws InterruptedException {
        element.wait();
        String text = element.getAttribute(elementAttribute);
        return text;
    }
}