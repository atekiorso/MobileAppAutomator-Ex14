package ui.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ui.CorePageObject;

public class IosWelcomePageObject extends CorePageObject {
    final String
            SKIP_BUTTON = "xpath://XCUIElementTypeButton[@name='Skip']";

    public IosWelcomePageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void clickSkipButton() {
        this.waitForElementAndClick(SKIP_BUTTON);
    }
}
