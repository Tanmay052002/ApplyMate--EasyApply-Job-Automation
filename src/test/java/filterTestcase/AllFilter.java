package filterTestcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import filterpages.AllFilterpage;

public class AllFilter extends basetest{
	AllFilterpage filterOpt;
	
	@Test
	public void allFilters() throws InterruptedException, IOException{
		filterOpt = new AllFilterpage(driver);
		filterOpt.option();
	}
}
