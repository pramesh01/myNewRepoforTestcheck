package teststeps;


import io.cucumber.java.en.Given;

public class session {
	
	@Given ("i am logging into website {string}")
	    public void website_detail(String website) {
		   System.out.println("logging into website "+website);
	        
	           }
	         }