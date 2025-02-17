package filterTestcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import filterpages.JobFunc_itpage;

public class JobFunc_it extends basetest{
	JobFunc_itpage itOpt;
	
	@Test
	public void itFuncopt() throws InterruptedException, IOException{
		itOpt = new JobFunc_itpage(driver);
		itOpt.option();
	}
}
