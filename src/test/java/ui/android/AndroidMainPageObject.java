package ui.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.CorePageObject;

public class AndroidMainPageObject extends CorePageObject {
    final String SEARCH_CONTAINER = "id:org.wikipedia:id/search_container";

    public AndroidMainPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void clickSearchContainer() {
        this.waitForElementAndClick(SEARCH_CONTAINER);
    }
}
