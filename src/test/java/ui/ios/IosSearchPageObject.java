package ui.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.CorePageObject;

import java.util.List;

public class IosSearchPageObject extends CorePageObject {
    final String
            SEARCH_WIKIPEDIA_FIELD = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia' and (following-sibling::XCUIElementTypeButton[@name='Cancel'])]",
            NO_RESULTS_FOUND_LABEL = "id:No results found",
            SEARCH_RESULTS_TITLES = "xpath://XCUIElementTypeToolbar[@name='Toolbar']/../.." +
                "/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeStaticText[1]";

    public IosSearchPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void sendKeysSearchWikipediaField(String searchText) {
        this.waitForElementAndSendKeys(SEARCH_WIKIPEDIA_FIELD, searchText);
    }

    public void checkSearchResultsPresent() {
        this.waitForElementNotPresent(NO_RESULTS_FOUND_LABEL);
    }

    public List<WebElement> getPageListItemTitleElements() {
        return this.getElements(SEARCH_RESULTS_TITLES);
    }
}
