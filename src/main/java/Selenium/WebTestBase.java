package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebTestBase {

    public WebDriver WebBrowserDriver;

    public void CommonTestSetup(String url, boolean deleteAllCookies, Enums.WebDriver webDriver) {
        switch (webDriver) {
            case Chrome:
            InitialiseChromeLocal(url, deleteAllCookies);
            break;
            case Firefox:
            InitialiseFirefoxLocal(url, deleteAllCookies);
            break;
        }
    }

    private void InitialiseFirefoxLocal(String url, boolean deleteAllCookies) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("browser.download.folderList", 2);
        WebBrowserDriver = new FirefoxDriver(firefoxOptions);
        InitialiseWebDriver(url, deleteAllCookies);
    }

    private void InitialiseChromeLocal(String url, boolean deleteAllCookies) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("safebrowsing.enabled");
        chromeOptions.addArguments("chrome.switches", "--disable-gpu", "--disable-popup-blocking", "--disable-extensions", "--disable-extensions-http-throttling", "--disable-extensions-file-access-check", "--disable-infobars", "--enable-automation", "--safebrowsing-disable-download-protection ", "--safebrowsing-disable-extension-blacklist", "--start-maximized");
        WebBrowserDriver = new ChromeDriver(chromeOptions);
        InitialiseWebDriver(url, deleteAllCookies);
    }

    private void InitialiseWebDriver(String url, boolean deleteAllCookies) {
        int maxAttempts = 3;
        for (int attempt = 1; attempt <= maxAttempts; attempt++)
        {
            String message = null;
            try
            {
                //SetTimeouts.PageLoad(WebBrowserDriver);

                if (deleteAllCookies)
                {
                    WebBrowserDriver.manage().deleteAllCookies();
                }

                WebBrowserDriver.manage().window().maximize();
                WebBrowserDriver.get(url);
                break;
            }
            catch (WebDriverException exception)
            {
                message = "Exception " + attempt + ": " + exception.getMessage();
                if (attempt >= maxAttempts)
                {
                    throw new WebDriverException("Failed to start Web Browser in a timely manner. - " + message);
                }
            }
        }
    }
}
