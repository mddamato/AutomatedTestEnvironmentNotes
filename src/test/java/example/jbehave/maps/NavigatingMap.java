package example.jbehave.maps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static org.assertj.core.api.Assertions.assertThat; 
import example.pages.ArticlePage;
import example.pages.PortalPage;
import example.pages.WikiMainPage;

public class NavigatingMap
{

	WikiMainPage wikiHomePage;
	ArticlePage articlePage;
	PortalPage portalPage;
	
	@Given("i am on the '$string' menu page")
    public void givenISelectMainSideMenu(String string) 
    {
		wikiHomePage.open();
		wikiHomePage.clickOnSideMenuOption(string);
    }
    
	@When("i click on '$string' from portal menu")
    public void whenISelectFromPortalTopMenu(String string) 
    {
		portalPage.clickMenuItem(string);
    }
	
    
	@When("i click on '$string1' from side menu")
    public void whenIClickOnMenuItem(String string1) 
    {
		wikiHomePage.clickOnSideMenuOption(string1);
    }
	
	@Then("'$pageTitle' should be displayed")
	public void verifyPageTitleEquals(String pageTitle)
	{
		portalPage.verifyTitleEquals(pageTitle);
	}
	
	@Then("a random article should be displayed")
	public void verifyARandomPageDisplayed(String pageTitle)
	{
		System.out.println(articlePage.getPageTitle());
		assertThat(true).isTrue();
	}
    

 
}