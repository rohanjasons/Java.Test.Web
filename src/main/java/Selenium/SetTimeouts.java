package Selenium;

import Constants.TimeoutsInSeconds;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class SetTimeouts {

    /**
     * @Summary
     * Set the Implicit Wait Timeout.
     * @param webDriver WebDriver Instance
     */
    public static void ImplicitlyWait(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(TimeoutsInSeconds.DefaultTimeout, TimeUnit.SECONDS);
    }

    /**
     * @Summary
     * Set the Implicit Wait Timeout.
     * @param webDriver WebDriver Instance
     * @param timeOuts Timeout to wait for
     */
    public static void ImplicitlyWait(WebDriver webDriver, int timeOuts) {
        webDriver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
    }

    /**
     * @Summary
     * Set the Page Load Timeout.
     * @param webDriver WebDriver Instance
     */
    public static void PageLoad(WebDriver webDriver) {
        webDriver.manage().timeouts().pageLoadTimeout(TimeoutsInSeconds.DefaultTimeout, TimeUnit.SECONDS);
    }

    /**
     * @Summary
     * Set the Page Load Timeout.
     * @param webDriver WebDriver Instance
     * @param timeOuts Timeout to wait for
     */
    public static void PageLoad(WebDriver webDriver, int timeOuts) {
        webDriver.manage().timeouts().pageLoadTimeout(timeOuts, TimeUnit.SECONDS);
    }

    /**
     * @Summary
     * Set the Script Timeout
     * @param webDriver WebDriver Instance
     */
    public static void Script(WebDriver webDriver) {
        webDriver.manage().timeouts().setScriptTimeout(TimeoutsInSeconds.DefaultTimeout, TimeUnit.SECONDS);
    }

    /**
     * @Summary
     * Set the Script Timeout
     * @param webDriver WebDriver Instance
     * @param timeOuts Timeout to wait for
     */
    public static void Script(WebDriver webDriver, int timeOuts) {
        webDriver.manage().timeouts().setScriptTimeout(timeOuts, TimeUnit.SECONDS);
    }
}
