/**
 * Defines the methods for navigating the menu's
 * @author mddamato
 */
package example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class WikiMainPage extends PageObject{

//	@FindBy(id = "searchInput")
//	protected WebElementFacade searchBox;

	public void searchFor(String searchString)
	{
		getDriver().findElement(By.id("searchInput")).sendKeys(searchString);
		getDriver().findElement(By.id("searchButton")).click();
		//searchBox.typeAndEnter(searchString);
	}

	public void clickOnSideMenuOption(String sideMenuSelection)
	{
		if(sideMenuSelection.equalsIgnoreCase("Main Page"))
			getDriver().findElement(By.id("n-mainpage-description")).findElement(By.tagName("a")).click();
		else
			if(sideMenuSelection.equalsIgnoreCase("Contents"))
				getDriver().findElement(By.id("n-contents")).findElement(By.tagName("a")).click();
			else
				if(sideMenuSelection.equalsIgnoreCase("Featured Content"))
					getDriver().findElement(By.id("n-featuredcontent")).findElement(By.tagName("a")).click();
				else
					if(sideMenuSelection.equalsIgnoreCase("Random Article"))
						getDriver().findElement(By.id("n-randompage")).findElement(By.tagName("a")).click();
	}

}
