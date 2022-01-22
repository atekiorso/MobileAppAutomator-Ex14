package ui.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.CorePageObject;

import java.util.List;

public class AndroidSearchPageObject extends CorePageObject {
    final String SEARCH_CRC_TEXT = "id:org.wikipedia:id/search_src_text";
    final String SEARCH_EMPTY_TEXT = "id:org.wikipedia:id/search_empty_text";
    final String PAGE_LIST_ITEM_TITLE = "xpath://android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']";

    public AndroidSearchPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void sendKeysSearchSrcText(String searchText) {
        this.waitForElementAndSendKeys(SEARCH_CRC_TEXT, searchText);
    }

    public void checkSearchResultsPresent() {
        this.waitForElementNotPresent(SEARCH_EMPTY_TEXT);
    }

    public List<WebElement> getPageListItemTitleElements() {
        return this.getElements(PAGE_LIST_ITEM_TITLE);
    }
}
