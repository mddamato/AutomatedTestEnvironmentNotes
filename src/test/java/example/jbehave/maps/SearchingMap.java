package example.jbehave.maps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import example.pages.ArticlePage;
import example.pages.PortalPage;
import example.pages.WikiMainPage;

public class SearchingMap
{

	WikiMainPage wikiHomePage;
	ArticlePage articlePage;
	PortalPage portalPage;

    
    @Given("i am on the wikipedia home page")
    public void givenIAmOnTheWikiSite() 
    {
    	wikiHomePage.open();
    }
    
	@When("i search for the article '$searchString'")
    public void whenISearchForArticle(String searchString) 
    {
		wikiHomePage.searchFor(searchString);
    }
    
    @Then("the '$searchString' article should be displayed")
    public void thenTheArticleShouldBeDisplayed(String searchString) 
    {
    	articlePage.verifyTitleEquals(searchString);
    }
    

    

 
}