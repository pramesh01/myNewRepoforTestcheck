package teststeps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Leads {
	 
	@When ("i goto {string} page")
	     public void create_lead(String leadpage) {
		   System.out.println("going to page "+leadpage);
	     }
	 
	 @And ("enter and submit the lead details")
	     public void submitlead() {
          System.out.println("entering and submitting the leaddetails ");	    	
	     }
	 
	 @And ("i goto {string} page")
	    public void gotoloaddetailpage(String leadsdetails) {
		 System.out.println("going to "+leadsdetails);
	    }
	 @Then ("i verify the lead details")
	    public void verufyleads() {
	    	System.out.println("i verify the leads details ");
	    }
	    
	 @And ("lead should be present inside the grid")
	    public void verifyleadpresent() {
		 
	 }
}
