package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import core.ImdbSortBy;

public class ImdbSearchPage {

	private WebDriver driver;

	public ImdbSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Sort result list by a value
	 * 
	 * @param sort
	 *            To be classified by
	 */
	public void sortBy(ImdbSortBy sort) {
		Select select = new Select(driver.findElement(By.className("lister-sort-by")));
		switch (sort) {
		case IMDB_RATING:
			select.selectByVisibleText("IMDb Rating");
			break;
		case NUMBER_OF_RATINGS:
			select.selectByVisibleText("Number of Ratings");
			break;
		case RANKING:
			select.selectByVisibleText("Ranking");
			break;
		case REALEASE_DATE:
			select.selectByVisibleText("Release Date");
			break;
		}
	}

	/**
	 * Check if exist any result
	 * 
	 * @return Found one or more results
	 */
	public boolean existResult() {
		try {
			driver.findElement(By.className("lister-list"));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	/**
	 * Select a movie by genre
	 * 
	 * @param genre
	 *            Set a genre to showing
	 */
	public void selectGenre(String genre) {
		try {
			driver.findElement(By.linkText(genre)).click();;
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(String.format("Genre '%s' not found", genre), e);
		}
	}

}
