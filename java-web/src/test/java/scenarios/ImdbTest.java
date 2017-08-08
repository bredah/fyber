package scenarios;

import java.io.IOException;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import core.Browser;
import core.DataProperties;
import core.Driver;
import core.ImdbSortBy;
import pages.ImdbSearchPage;

public class ImdbTest {

	private static WebDriver driver;
	private ImdbSearchPage searchPage;
	private Map<String, String> data;

	@BeforeClass
	public static void oneTimeSetUp() {
		driver = new Driver().start(Browser.CHROME);
	}

	@AfterClass
	public static void oneTimeTearDown() {
		driver.close();
	}

	@Before
	public void setUp() throws IOException {
		// Load data
		data = new DataProperties().getValues();
		searchPage = new ImdbSearchPage(driver);
		// Go to page
		driver.get(data.get("url"));
	}

	@Test
	public void validSortBy() {
		// Check for results on the current page
		Assert.assertTrue("No results found on first page", searchPage.existResult());

		// Sort by: IMDb Rating
		searchPage.sortBy(ImdbSortBy.IMDB_RATING);
		Assert.assertTrue("No results found when sort IMDB RATING", searchPage.existResult());

		// Sort by: Release Date
		searchPage.sortBy(ImdbSortBy.REALEASE_DATE);
		Assert.assertTrue("No results found when sort by RELEASE DATE", searchPage.existResult());

		// Sort by: Number of Ratings
		searchPage.sortBy(ImdbSortBy.NUMBER_OF_RATINGS);
		Assert.assertTrue("No results found when sort by NUMBER OF RATINGS", searchPage.existResult());

		// Sort by: Ranking
		searchPage.sortBy(ImdbSortBy.RANKING);
		Assert.assertTrue("No results found when sort by RANKING", searchPage.existResult());

		// Sort by GENRE
		searchPage.selectGenre("Western");
		Assert.assertTrue("No results found by genre 'Western'", searchPage.existResult());
	}
}
