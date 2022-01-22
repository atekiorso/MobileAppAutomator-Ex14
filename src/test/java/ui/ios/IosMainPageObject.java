package ui.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.CorePageObject;

public class IosMainPageObject extends CorePageObject {
    final String SEARCH_WIKIPEDIA_CONTAINER = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia' and not(following-sibling::*)]";

    public IosMainPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void clickSearchWikipediaContainer() {
        this.waitForElementAndClick(SEARCH_WIKIPEDIA_CONTAINER);
    }
}
