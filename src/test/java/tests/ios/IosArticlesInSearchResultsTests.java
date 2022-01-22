package tests.ios;

import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebElement;
import tests.ArticlesInSearchResultTests;
import ui.ios.IosMainPageObject;
import ui.ios.IosSearchPageObject;
import ui.ios.IosWelcomePageObject;

import java.util.List;

@Category(IosTests.class)
public class IosArticlesInSearchResultsTests extends ArticlesInSearchResultTests {
    private IosWelcomePageObject iosWelcomePageObject;
    private IosMainPageObject iosMainPageObject;
    private IosSearchPageObject iosSearchPageObject;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.driver = this.getIOSDriver();
        iosWelcomePageObject = new IosWelcomePageObject(this.driver);
        iosMainPageObject = new IosMainPageObject(this.driver);
        iosSearchPageObject = new IosSearchPageObject(this.driver);
    }

    @Override
    protected void skipWelcomeScreen() {
        iosWelcomePageObject.clickSkipButton();
    }

    @Override
    protected void searchArticles(String searchText) {
        iosMainPageObject.clickSearchWikipediaContainer();
        iosSearchPageObject.sendKeysSearchWikipediaField(searchText);
        iosSearchPageObject.checkSearchResultsPresent();
    }

    @Override
    protected List<WebElement> getTitleElementsInSearchResults() {
        return iosSearchPageObject.getPageListItemTitleElements();
    }
}
