package Extensions;

import Constants.TimeoutsInSeconds;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ExtendedMethods {

    private static int timeoutsInSeconds = TimeoutsInSeconds.ControlTimeout;
    private static WebDriver Driver;

    public static void EnterText(WebElement element, WebDriver webDriver, String value) {
        WaitUntilClickable(element, webDriver);
        element.sendKeys(value);
    }

    public static void EnterText(WebElement element, WebDriver webDriver, String value, int timeOuts) {
        WaitUntilClickable(element, webDriver);
        element.sendKeys(value);
    }

    public static void Click(WebElement element, WebDriver webDriver) {
        WaitUntilClickable(element, webDriver);
        element.click();
        //WaitForJavaScriptLoading(webDriver);
    }

    public static void JavaScriptClick(WebElement element, WebDriver driver) {
        WaitForElement(element);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }

    /// <summary>
    /// Select the item from a drop down with the given value.
    /// </summary>
    /// <param name="element">The WebElement that is being used to find the text value.</param>
    /// <param name="driver">WebDriver to work with</param>
    /// <param name="value">The value the is to be selected in the drop down control.</param>
    /// <param name="timeoutInSeconds">Timeout to find the control</param>
    public static void SelectDropDown(WebElement element, WebDriver driver, String value) {
        WaitUntilClickable(element, driver);
        new Select(element).selectByVisibleText(value);
    }

    /// <summary>
    /// Select the check box element if not already selected.
    /// </summary>
    /// <param name="element">The WebElement that is being used.</param>
    /// <param name="driver">WebDriver to work with</param>
    /// <param name="timeoutInSeconds">Timeout to find the control</param>
    public static void SelectCheckBox(WebElement element, WebDriver driver) {
        WaitUntilClickable(element, driver);
        if (!element.isSelected())
        {
            element.click();
        }
    }

    public static void SelectCheckBox(WebElement element, WebDriver driver, int timeoutsInSeconds) {
        WaitUntilClickable(element, driver, timeoutsInSeconds);
        if (!element.isSelected())
        {
            element.click();
        }
    }

    /// <summary>
    /// Unselected the check box element if not already un-selected.
    /// </summary>
    /// <param name="element">The WebElement that is being used.</param>
    /// <param name="driver">WebDriver to work with</param>
    /// <param name="timeoutInSeconds">Timeout to find the control</param>
    public static void UnselectCheckBox(WebElement element, WebDriver driver) {
        WaitUntilClickable(element, driver);
        if (element.isSelected())
        {
            element.click();
        }
    }

    public static void UnselectCheckBox(WebElement element, WebDriver driver, int timeoutsInSeconds) {
        WaitUntilClickable(element, driver, timeoutsInSeconds);
        if (element.isSelected())
        {
            element.click();
        }
    }

    /// <summary>
    /// Gets the text value from the passed in element.
    /// </summary>
    /// <param name="element">The WebElement that is being used.</param>
    /// <param name="driver">WebDriver to work with</param>
    /// <param name="timeoutInSeconds">Timeout to find the control</param>
    /// <returns>The text value that is in on the element.</returns>
    public static String GetText(WebElement element, WebDriver driver) {
        WaitUntilClickable(element, driver);
        WaitForElementIsVisible(element);
        //WaitForJavaScriptLoading(driver);
        return element.getText();
    }

    public static String GetText(WebElement element, WebDriver driver, int timeoutsInSeconds) {
        WaitUntilClickable(element, driver, timeoutsInSeconds);
        WaitForElementIsVisible(element, timeoutsInSeconds);
        //WaitForJavaScriptLoading(driver, timeoutsInSeconds);
        return element.getText();
    }

    /// <summary>
    /// Wait for the validation message to be displayed and then return the text in message.
    /// </summary>
    /// <param name="element">The WebElement that is being used.</param>
    /// <param name="timeoutInSeconds">Timeout to find the control</param>
    /// <returns>The text value that is in on the element.</returns>
    public static String GetTextWhenShown(WebElement element) {
        WaitForElementIsVisible(element);
        return element.getText();
    }

    public static String GetTextWhenShown(WebElement element, int timeoutsInSeconds) {
        WaitForElementIsVisible(element, timeoutsInSeconds);
        return element.getText();
    }

    public static void WaitUntilClickable(WebElement element, WebDriver webDriver) {
        if (timeoutsInSeconds > 0) {
            new WebDriverWait(webDriver, timeoutsInSeconds).until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    public static void WaitUntilClickable(WebElement element, WebDriver webDriver, int timeoutsInSeconds) {
        if (timeoutsInSeconds > 0) {
            new WebDriverWait(webDriver, timeoutsInSeconds).until(ExpectedConditions.elementToBeClickable(element));
        }
    }


    public static void WaitForJavaScriptLoading(WebDriver webDriver)
    {
        Driver = webDriver;

        Wait<WebDriver> wait = new WebDriverWait(Driver, timeoutsInSeconds);
        wait.until(driver -> ((JavascriptExecutor)webDriver).executeScript("return document.readystate").equals("complete"));
    }

    public static void WaitForJavaScriptLoading(WebDriver webDriver, int timeoutsInSeconds)
    {
        Driver = webDriver;

        Wait<WebDriver> wait = new WebDriverWait(Driver, timeoutsInSeconds);
        wait.until(driver -> ((JavascriptExecutor)webDriver).executeScript("return document.readystate").equals("complete"));
    }

    public static boolean WaitForElementIsVisible(WebElement element)
    {
        boolean result = false;
        int timeout = 0;
        while (result == false)
        {
            if (timeout >= timeoutsInSeconds)
            {
                break;
            }
            timeout += 1;
            result = element.isDisplayed();
        }
        return result;
    }

    public static boolean WaitForElementIsVisible(WebElement element, int timeoutsInSeconds)
    {
        boolean result = false;
        int timeout = 0;
        while (result == false)
        {
            if (timeout >= timeoutsInSeconds)
            {
                break;
            }
            timeout += 1;
            result = element.isDisplayed();
        }
        return result;
    }

    public static void WaitForElement(WebElement element) {
        WaitForElementIsVisible(element);
    }
}
