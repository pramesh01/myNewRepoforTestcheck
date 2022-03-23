package teststeps;

import io.cucumber.java.en.When;

public class TopMenu {

	 @When ("i click on {string} tab on top menu")
	    public void clickLeads(String tabName) {
		  System.out.println("clicking on tab name "+tabName);	 
	 }
	
	

}
