package example.jbehave;
import net.serenitybdd.jbehave.SerenityStories;


public class AcceptanceTestSuite extends SerenityStories 
{
    public AcceptanceTestSuite() {
        if(System.getProperty("storyPath")!=null && !(System.getProperty("storyPath").isEmpty()))
        {
        	findStoriesCalled("**"
        		+ System.getProperty("storyPath")
        		+ ".story");
        }
    }	
}