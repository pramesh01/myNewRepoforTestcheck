package testcases;

import java.util.Hashtable;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.normal.LaunchPage;
import com.zoho.session.ZohoTestSession;
import com.zoho.util.Xls_Reader;

public class LoginTest {

	ZohoTestSession session;
	@BeforeMethod
	public void init() {
		
		session=new ZohoTestSession();
		session.init("Login Test");
	}
	@AfterMethod
	public void quit() {
		session.generateReports();
	}
       @Test(dataProvider="getData")
       public void loginTest(Hashtable<String,String> data){	
    	  
    	   session.log(data.toString());
    	   
    	   if(data.get("Runmode").equals("N")) {
    		   //Skip in the Extent Reports.
    		   
    		   session.skipTest("skipping the extentReports as RunMode is NO");
    		   
    		   //skip in testNG
    		   throw new SkipException("skipping the testng as RunMode is NO ");
    	   }
    	   String Username=data.get("Username");
    	   String Password=data.get("Password");
    		
    	    new LaunchPage()
           .openBrowser("chrome")
           .gotoHomePage()
          .gotoEnterUsernamepage();
          //.submitUsername(Username);
    	   /*
	         ZohoPage page=new LaunchPage()
	         //session
	         //.init("Login Test")  // store session in test context()  // and also return object of launchPage
	         .openBrowser("chrome")
	         .gotoHomePage()
	         //.validator(false).validateTitle(Constants.HomePage_Title)
	         .gotoEnterUsernamepage()
	          //.validator(true).validateElementPresent(Constants.signin_link_locator)
	          .submitUsername(Username)
			  .submitPassword(Password);
			  */
	            session.end();
               }
           
    @DataProvider
    public Object[][] getData(){
	String testcaseName="LoginTest";
	String SheetName="TestCases";

   Xls_Reader reader=new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
   int testStartRowNum=1;
   while(!reader.getCellData(SheetName, 0, testStartRowNum).equals(testcaseName)) {
   testStartRowNum++;
   }

     System.out.println("row number where the testcase is mentioned is -> "+testStartRowNum);
     int ColumnStartRowNum=testStartRowNum+1;
     System.out.println("columns headings of the test case starts from row number "+ColumnStartRowNum);

    int totalColumnInTestCase=0;
    while(!reader.getCellData(SheetName, totalColumnInTestCase, ColumnStartRowNum).equals("")) {
	totalColumnInTestCase++;
    }
    System.out.println("total no. of columns in test case is "+totalColumnInTestCase);
	int dataStartRowNum=ColumnStartRowNum+1;
	int rowscounter=0;
	while(!reader.getCellData(SheetName, 0, (dataStartRowNum+rowscounter)).equals("")) {
		rowscounter++;
	}
	System.out.println("total no of Rows in test case is "+rowscounter);
	Object testData[][]=new Object[rowscounter][1];
	Hashtable<String,String> table=null;
	int i=0;
	
//extracting the data from the sheets
for(int rownumber=dataStartRowNum;rownumber<dataStartRowNum+rowscounter;rownumber++)
{
table=new Hashtable<String,String>();
for(int colnumber=0;colnumber<totalColumnInTestCase;colnumber++) 
{
String data=reader.getCellData(SheetName, colnumber, rownumber);
String key=reader.getCellData(SheetName, colnumber, ColumnStartRowNum);		
System.out.print(key+"   "+data+"  ");
table.put(key,data);
}
testData[i][0]=table;
i++;
System.out.println();
}
System.out.println("Program Ends here");
return testData;
}
}
