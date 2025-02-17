package filterTestcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import filterpages.JobFunc_engpage;

public class JobFunc_eng extends basetest{
	JobFunc_engpage engOpt;
	
	@Test
	public void engFuncopt() throws InterruptedException, IOException{
		engOpt = new JobFunc_engpage(driver);
		engOpt.option();
	}
}
