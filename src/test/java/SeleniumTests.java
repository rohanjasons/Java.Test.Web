import Enums.WebDriver;
import Pages.Base.PageExtensions;
import org.junit.jupiter.api.Test;
import Selenium.WebTestBase;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.ParameterizedTest;

public class SeleniumTests extends WebTestBase {

    private String Url = "http://www.automationpractice.com";

    @ParameterizedTest
    @EnumSource(value = WebDriver.class, names = { "Chrome", "Firefox"})
    public void NavigateTotShirts(WebDriver webDriver) throws Exception {
        CommonTestSetup(Url, true, webDriver);

        PageExtensions.Home(WebBrowserDriver)
                .NavigateToTshirts();
        WebBrowserDriver.quit();
    }

    @Test
    public void CheckIfTheGridOrListIsDisplayed() throws Exception {
        CommonTestSetup(Url, true, WebDriver.Chrome);

        PageExtensions.Home(WebBrowserDriver)
                .NavigateToDresses();
    }
}
