package example.pages;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;
import static org.assertj.core.api.Assertions.assertThat; 

/**
 * @author mddamato
 */
public class PortalPage extends PageObject
{

	public void clickMenuItem(String string) {
		getDriver().findElement(By.cssSelector("div#mw-content-text.mw-content-ltr div.center p small small"))
			.findElement(By.partialLinkText(string)).click();
	}

	public void verifyTitleEquals(String pageTitle) {
		String header = getDriver().findElement(By.id("firstHeading")).getText();
		assertThat(header).containsIgnoringCase(pageTitle);
	}





}
