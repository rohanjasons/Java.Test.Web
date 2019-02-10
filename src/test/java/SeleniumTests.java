import Enums.WebDriver;
import Pages.Base.PageExtensions;
import org.junit.jupiter.api.Test;
import Selenium.WebTestBase;

public class SeleniumTests extends WebTestBase {

    private String Url = "http://www.automationpractice.com";

    @Test
    public void NavigateTotShirts_Chrome() throws Exception {
        CommonTestSetup(Url, true, WebDriver.Chrome);

        PageExtensions.Home(WebBrowserDriver)
                .NavigateToTshirts();
        WebBrowserDriver.quit();
    }

    @Test
    public void NavigateTotShirts_Firefox() throws Exception {
        CommonTestSetup(Url, true, WebDriver.Firefox);

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
