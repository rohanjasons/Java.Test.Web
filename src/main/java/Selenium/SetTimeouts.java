package Selenium;

import Constants.TimeoutsInSeconds;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class SetTimeouts {

    public static void ImplicitlyWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(TimeoutsInSeconds.DefaultTimeout, TimeUnit.SECONDS);
    }

    public static void PageLoad(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(TimeoutsInSeconds.DefaultTimeout, TimeUnit.SECONDS);
    }

    public static void Script(WebDriver driver) {
        driver.manage().timeouts().setScriptTimeout(TimeoutsInSeconds.DefaultTimeout, TimeUnit.SECONDS);
    }
}
