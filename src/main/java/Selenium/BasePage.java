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

public abstract class BasePage {

    private static int timeoutsInSeconds = TimeoutsInSeconds.ControlTimeout;
    private static WebDriver Driver;

    public WebDriver getDriver() {
        return this.Driver;
    }
    public void setDriver(WebDriver driver) {
        this.Driver = driver;
    }

    protected BasePage(WebDriver webDriver) throws Exception {
       this.Driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected BasePage(WebDriver webDriver, String element) throws Exception {
        if (!WaitToFinishLoading(webDriver)) {
            throw new Exception("Timed-Out");
        }
        if (AssertElementIsDisplayed(element)) {
        this.Driver = webDriver;
        PageFactory.initElements(webDriver, this);
        }
    }

    protected BasePage(WebDriver webDriver, By element) throws Exception {
        if (!WaitToFinishLoading(webDriver)) {
            throw new Exception("Timed-Out");
        }
        if (AssertElementIsDisplayed(element)) {
        this.Driver = webDriver;
        PageFactory.initElements(webDriver, this);
        }
    }

    /* private static boolean WaitForPageToFinishLoadin(WebDriver webDriver) {
        Wait<WebDriver> wait = new WebDriverWait(Driver, timeoutsInSeconds);
        return wait.until(driver -> ((JavascriptExecutor) webDriver).executeScript("return document.readystate").equals("complete"));
    } */

    private static boolean WaitToFinishLoading(WebDriver webDriver) {
        return new WebDriverWait(Driver, timeoutsInSeconds).until(driver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void WaitForPageToFinishLoading(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, timeoutsInSeconds);
        wait.until(pageLoadCondition);
    }

    /// <summary>
    /// Checks to see if the correct page has been loaded
    /// </summary>
    /// <param name="elementId">the element that is checked to ensure that the correct page is loaded</param>
    /// <returns>Returns a true or false</returns>
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
        }

        throw new Exception("Could not find element with ID - " + elementId + " on page");
    }

    /// <summary>
    /// Checks to see if the correct page has been loaded
    /// </summary>
    /// <param name="elementId">the element that is checked to ensure that the correct page is loaded</param>
    /// <returns>Returns a true or false</returns>
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
        }

        throw new Exception("Could not find element with ID - " + elementId + " on page");
    }
}
