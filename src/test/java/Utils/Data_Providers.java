package Utils;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Data_Providers {
	@DataProvider(name="DataInput")
	public String [][] getData() throws IOException
	{
		String path=".\\Test_data\\MakeMyTrip.xlsx";
		
		Excel_utility xlutil=new Excel_utility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcells=xlutil.getCellCount("Sheet1",1);
				
		String data[][]=new String[totalrows][totalcells];
		
		for(int i=1;i<=totalrows;i++)  
		{		
			for(int j=0;j<totalcells;j++)  
			{
				data[i-1][j]= xlutil.getCellData("Sheet1",i, j); 
			}
		}
	return data;
				
	}
}
