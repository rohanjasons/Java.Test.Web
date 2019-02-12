package Extensions;

import Constants.TimeoutsInSeconds;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Summary
 * Extended methods are used so that all common tasks are processed the same way. e.g. Inputting text, Clicking a button etc.
 */
public final class ExtendedMethods {

    private static int timeoutsInSeconds = TimeoutsInSeconds.ControlTimeout;
    private static WebDriver Driver;

    /**
     * @Summary
     * Common method used to enter text the value into the element property.
     * @param element The WebElement that is being used
     * @param webDriver WebDriver to work with
     * @param value The text value to be entered in the WebElement
     */
    public static void EnterText(WebElement element, WebDriver webDriver, String value) {
        WaitUntilClickable(element, webDriver);
        element.sendKeys(value);
    }

    /**
     * @Summary
     * Common method used to enter text the value into the element property.
     * @param element The WebElement that is being used
     * @param webDriver WebDriver to work with
     * @param value The text value to be entered in the WebElement
     * @param timeOuts Timeout to find the control
     */
    public static void EnterText(WebElement element, WebDriver webDriver, String value, int timeOuts) {
        WaitUntilClickable(element, webDriver, timeOuts);
        element.sendKeys(value);
    }

    /**
     * @Summary
     * Common method used to click the element property.
     * @param element The WebElement that is being clicked.
     * @param webDriver WebDriver to work with
     */
    public static void Click(WebElement element, WebDriver webDriver) {
        WaitUntilClickable(element, webDriver);
        element.click();
    }

    /**
     * @Summary
     * Common method used to click the element property.
     * @param element The WebElement that is being clicked.
     * @param webDriver WebDriver to work with
     * @param timeOuts Timeout to find the control
     */
    public static void Click(WebElement element, WebDriver webDriver, int timeOuts) {
        WaitUntilClickable(element, webDriver, timeOuts);
        element.click();
    }

    /**
     * @Summary
     * Common method used to click the element property.
     * @param element The WebElement that is being clicked.
     * @param webDriver WebDriver to work with
     */
    public static void JavaScriptClick(WebElement element, WebDriver webDriver) {
        WaitForElement(element);
        JavascriptExecutor executor = (JavascriptExecutor)webDriver;
        executor.executeScript("arguments[0].click()", element);
    }

    /**
     * @Summary
     * Select the item from a drop down with the given value.
     * @param element The WebElement that is being used to find the text value
     * @param webDriver WebDriver to work with
     * @param value The value the is to be selected in the drop down control
     */
    public static void SelectDropDown(WebElement element, WebDriver webDriver, String value) {
        WaitUntilClickable(element, webDriver);
        new Select(element).selectByVisibleText(value);
    }

    /**
     * @Summary
     * Select the item from a drop down with the given value.
     * @param element The WebElement that is being used to find the text value
     * @param webDriver WebDriver to work with
     * @param value The value the is to be selected in the drop down control
     * @param timeOuts Timeout to find the control
     */
    public static void SelectDropDown(WebElement element, WebDriver webDriver, String value, int timeOuts) {
        WaitUntilClickable(element, webDriver, timeOuts);
        new Select(element).selectByVisibleText(value);
    }

    /**
     * @Summary
     * Select the check box element if not already selected.
     * @param element The WebElement that is being used to find the text value
     * @param webDriver WebDriver to work with
     */
    public static void SelectCheckBox(WebElement element, WebDriver webDriver) {
        WaitUntilClickable(element, webDriver);
        if (!element.isSelected())
        {
            element.click();
        }
    }

    /**
     * @Summary
     * Select the check box element if not already selected.
     * @param element The WebElement that is being used to find the text value
     * @param webDriver WebDriver to work with
     * @param timeOuts Timeout to find the control
     */
    public static void SelectCheckBox(WebElement element, WebDriver webDriver, int timeOuts) {
        WaitUntilClickable(element, webDriver, timeOuts);
        if (!element.isSelected())
        {
            element.click();
        }
    }

    /**
     * @Summary
     * Unselected the check box element if not already un-selected.
     * @param element The WebElement that is being used to find the text value
     * @param webDriver WebDriver to work with
     */
    public static void UnselectCheckBox(WebElement element, WebDriver webDriver) {
        WaitUntilClickable(element, webDriver);
        if (element.isSelected())
        {
            element.click();
        }
    }

    /**
     * @Summary
     * Unselected the check box element if not already un-selected.
     * @param element The WebElement that is being used to find the text value
     * @param webDriver WebDriver to work with
     * @param timeOuts Timeout to find the control
     */
    public static void UnselectCheckBox(WebElement element, WebDriver webDriver, int timeOuts) {
        WaitUntilClickable(element, webDriver, timeOuts);
        if (element.isSelected())
        {
            element.click();
        }
    }

    /**
     * @Summary
     * Gets the text value from the passed in element.
     * @param element The WebElement that is being used to find the text value
     * @param webDriver WebDriver to work with
     * @return The text value that is in on the element
     */
    public static String GetText(WebElement element, WebDriver webDriver) {
        WaitUntilClickable(element, webDriver);
        WaitForElementIsVisible(element);
        //WaitForJavaScriptLoading(driver);
        return element.getText();
    }

    /**
     * @Summary
     * Gets the text value from the passed in element.
     * @param element The WebElement that is being used to find the text value
     * @param webDriver WebDriver to work with
     * @param timeOuts Timeout to find the control
     * @return The text value that is in on the element
     */
    public static String GetText(WebElement element, WebDriver webDriver, int timeOuts) {
        WaitUntilClickable(element, webDriver, timeOuts);
        WaitForElementIsVisible(element, timeOuts);
        return element.getText();
    }

    /**
     * @Summary
     * Wait for the validation message to be displayed and then return the text in message
     * @param element The WebElement that is being used to find the text value
     * @return The text value that is in on the element
     */
    public static String GetTextWhenShown(WebElement element) {
        WaitForElementIsVisible(element);
        return element.getText();
    }

    /**
     * @Summary
     * Wait for the validation message to be displayed and then return the text in message
     * @param element The WebElement that is being used to find the text value
     * @param timeOuts Timeout to find the control
     * @return The text value that is in on the element
     */
    public static String GetTextWhenShown(WebElement element, int timeOuts) {
        WaitForElementIsVisible(element, timeOuts);
        return element.getText();
    }

    /**
     * @Summary
     * Waits for an element to be clickable before attempting to click it
     * @param element The element we wish to interact with
     * @param webDriver WebDriver to work with
     */
    public static void WaitUntilClickable(WebElement element, WebDriver webDriver) {
        if (timeoutsInSeconds > 0) {
            new WebDriverWait(webDriver, timeoutsInSeconds).until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    /**
     * @Summary
     * Waits for an element to be clickable before attempting to click it
     * @param element The element we wish to interact with
     * @param webDriver WebDriver to work with
     * @param timeOuts How long we wish to wait for in seconds
     */
    public static void WaitUntilClickable(WebElement element, WebDriver webDriver, int timeOuts) {
        if (timeOuts > 0) {
            new WebDriverWait(webDriver, timeOuts).until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    /**
     * @Summary
     * Waits for a specified length of time for the javascript on a browser to load
     * @param webDriver WebDriver to work with
     */
    public static void WaitForJavaScriptLoading(WebDriver webDriver)
    {
        Driver = webDriver;

        Wait<WebDriver> wait = new WebDriverWait(Driver, timeoutsInSeconds);
        wait.until(driver -> ((JavascriptExecutor)webDriver).executeScript("return document.readystate").equals("complete"));
    }

    /**
     * @Summary
     * Waits for a specified length of time for the javascript on a browser to load
     * @param webDriver WebDriver to work with
     * @param timeOuts How long we wish to wait for in seconds
     */
    public static void WaitForJavaScriptLoading(WebDriver webDriver, int timeOuts)
    {
        Driver = webDriver;

        Wait<WebDriver> wait = new WebDriverWait(Driver, timeOuts);
        wait.until(driver -> ((JavascriptExecutor)webDriver).executeScript("return document.readystate").equals("complete"));
    }

    /**
     * @Summary
     * Waits the set amount of time before exiting if the control is not found. Searches every second.
     * @param element The WebElement that is being used
     * @return True of false if control is in visible state
     */
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

    /**
     * @Summary
     * Waits the set amount of time before exiting if the control is not found. Searches every second.
     * @param element The WebElement that is being used
     * @param timeOuts Timeout to find the control
     * @return True of false if control is in visible state
     */
    public static boolean WaitForElementIsVisible(WebElement element, int timeOuts)
    {
        boolean result = false;
        int timeout = 0;
        while (result == false)
        {
            if (timeout >= timeOuts)
            {
                break;
            }
            timeout += 1;
            result = element.isDisplayed();
        }
        return result;
    }

    /**
     * @Summary
     * Wait for the element under scrutiny to be visible
     * @param element The WebElement that is being used
     */
    public static void WaitForElement(WebElement element) {
        WaitForElementIsVisible(element);
    }
}
