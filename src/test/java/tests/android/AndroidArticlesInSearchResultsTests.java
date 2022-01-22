package tests.android;

import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebElement;
import tests.ArticlesInSearchResultTests;
import ui.android.AndroidMainPageObject;
import ui.android.AndroidSearchPageObject;

import java.util.List;

@Category(AndroidTests.class)
public class AndroidArticlesInSearchResultsTests extends ArticlesInSearchResultTests {
    private AndroidMainPageObject androidMainPageObject;
    private AndroidSearchPageObject androidSearchPageObject;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.driver = this.getAndroidDriver();
        androidMainPageObject = new AndroidMainPageObject(this.driver);
        androidSearchPageObject = new AndroidSearchPageObject(this.driver);
    }

    @Override
    protected void skipWelcomeScreen() {
        // В текущей версии приложения под Android экран Welcome не реализован
    }

    @Override
    protected void searchArticles(String searchText) {
        androidMainPageObject.clickSearchContainer();
        androidSearchPageObject.sendKeysSearchSrcText(searchText);
        androidSearchPageObject.checkSearchResultsPresent();
    }

    @Override
    protected List<WebElement> getTitleElementsInSearchResults() {
        return androidSearchPageObject.getPageListItemTitleElements();
    }
}
