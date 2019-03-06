package Selenium;

import Constants.Timeouts;
import Constants.TimeoutsInSeconds;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base Page that all test pages will inherit to gain access to the Web Driver
 */
public abstract class BasePage {

    private static int timeoutsInSeconds = TimeoutsInSeconds.ControlTimeout;

    /**
     * Gets or sets IWebDriver Instance
     */
    private static WebDriver Driver;
    public WebDriver getDriver() {
        return this.Driver;
    }

    public void setDriver(WebDriver webDriver) {
        this.Driver = webDriver;
    }

    /**
     * @Summary
     * @see BasePage Initializes a new instance of the "BasePage" class.
     * @param webDriver
     * @throws Exception
     */
    protected BasePage(WebDriver webDriver) throws Exception {
        this.Driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * @Summary
     * @see BasePage Initializes a new instance of the "BasePage" class.
     * @param webDriver WebDriver that is in use
     * @param element The element to initially check to ensure on correct page.
     * @throws Exception
     */
    protected BasePage(WebDriver webDriver, String element) throws Exception {
        if (!WaitToFinishLoading(webDriver)) {
            throw new Exception("Timed-Out");
        }
        if (AssertElementIsDisplayed(element)) {
            this.Driver = webDriver;
            PageFactory.initElements(webDriver, this);
        }
    }

    /**
     * @Summary
     * @see BasePage Initializes a new instance of the "BasePage" class.
     * @param webDriver WebDriver that is in use
     * @param element The element to initially check to ensure on correct page.
     * @throws Exception
     */
    protected BasePage(WebDriver webDriver, By element) throws Exception {
        if (!WaitToFinishLoading(webDriver)) {
            throw new Exception("Timed-Out");
        }
        if (AssertElementIsDisplayed(element)) {
            this.Driver = webDriver;
            PageFactory.initElements(webDriver, this);
        }
    }

    /**
     * @Summary
     * Wrapped the wait for java script method for use when loading web pages
     * @param webDriver The web browser driver
     * @return The browser once the java script load has completed
     */
    private static boolean WaitToFinishLoading(WebDriver webDriver) {
        return new WebDriverWait(Driver, timeoutsInSeconds).until(driver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * @Summary
     * Wrapped the wait for java script method for use when loading web pages
     * @param webDriver The web browser driver
     * @param webDriver
     */
    public void WaitForPageToFinishLoading(WebDriver webDriver) {
        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutsInSeconds);
        wait.until(pageLoadCondition);
    }

    /**
     * @Summary
     * Checks to see if the correct page has been loaded
     * @param elementId The element that is checked to ensure that the correct page is loaded
     * @return Returns a true or false
     * @throws Exception Throws an exception
     */
    public static boolean AssertElementIsDisplayed(String elementId) throws Exception {
        int timeOut = timeoutsInSeconds;
        for (int time = 0; time < timeOut; time++)
        {
            try {
                Driver.findElement(By.id(elementId));
                return true;
            }
            catch (NoSuchElementException exception) { }

            try {
                Thread.sleep(Timeouts.OneSecond);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        } throw new Exception("Could not find element with ID - " + elementId + " on page");
    }

    /**
     * @Summary
     * Checks to see if the correct page has been loaded
     * @param elementId The element that is checked to ensure that the correct page is loaded
     * @return Returns a true or false
     * @throws Exception throws an exception
     */
    private boolean AssertElementIsDisplayed(By elementId) throws Exception {
        int timeOut = timeoutsInSeconds;
        for (int time = 0; time < timeOut; time++) {
            try {
                Driver.findElement(elementId);
                return true;
            }
            catch (NoSuchElementException exception) { }

            try {
                Thread.sleep(Timeouts.OneSecond);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        } throw new Exception("Could not find element with ID - " + elementId + " on page");
    }
}