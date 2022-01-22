package tests;

import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class ArticlesInSearchResultTests extends CoreTestCase {
    protected final String SEARCH_TEXT = "warcraft";
    protected final int EXPECTED_MIN_SEARCH_RESULTS_COUNT = 3;

    public void testArticleTitlesInSearchResults() {
        skipWelcomeScreen();
        searchArticles(SEARCH_TEXT);
        List<WebElement> elements = getTitleElementsInSearchResults();
        checkTitlesInFirstThreeArticles(elements);
    }

    protected abstract void skipWelcomeScreen();

    protected abstract void searchArticles(String searchText);

    protected abstract List<WebElement> getTitleElementsInSearchResults();

    private void checkTitlesInFirstThreeArticles(List<WebElement> titleElementsInSearchResults) {
        int resultsCount = titleElementsInSearchResults.size();
        assertTrue("Результаты поиска '" + this.SEARCH_TEXT + "' содержат количество статей: " + resultsCount +
                        ", что меньше ожидаемых " + this.EXPECTED_MIN_SEARCH_RESULTS_COUNT + "!",
                resultsCount >= this.EXPECTED_MIN_SEARCH_RESULTS_COUNT);

        for (int i = 0; i < this.EXPECTED_MIN_SEARCH_RESULTS_COUNT; i++) {
            String title = titleElementsInSearchResults.get(i).getText();
            assertTrue("Заголовок статьи № " + (i + 1) + ": '" + title +
                            "' в результатах поиска не содержит ожидаемый текст: '" + this.SEARCH_TEXT + "'",
                    title.toLowerCase().contains(this.SEARCH_TEXT));
        }
    }
}
