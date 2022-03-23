package com.zoho.base.pages;

import java.util.Hashtable;
import com.zoho.util.Xls_Reader;

public class TempReaderXls {

	public static void main(String[] args) {
		
		String testcaseName="CreateLeadTest";
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
	}
    }
