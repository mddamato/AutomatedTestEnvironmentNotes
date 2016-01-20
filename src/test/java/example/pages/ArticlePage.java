/**
 * @author mddamato
 */
package example.pages;

import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;
import static org.assertj.core.api.Assertions.assertThat; 

public class ArticlePage extends PageObject{


//	@FindBy(id = "firstHeading")
//	protected WebElementFacade titleOfPage;
	
	public void verifyTitleEquals(String searchString) 
	{
		String title = getDriver().findElement(By.id("firstHeading")).getText();
		assertThat(title).containsIgnoringCase(searchString);
		//titleOfPage.shouldContainText(searchString);
	}
	
	public String getPageTitle() 
	{
		return getDriver().findElement(By.id("firstHeading")).getText();
	}

	public void clickLinkWithText(String string) {
		getDriver().findElement(By.partialLinkText(string)).click();
	}


}
