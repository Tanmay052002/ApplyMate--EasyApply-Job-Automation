package filterTestcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import filterpages.JobType_internpage;

public class JobType_intern extends basetest{
	JobType_internpage iTimeOpt;
	
	@Test
	public void internopt() throws InterruptedException, IOException{
		iTimeOpt = new JobType_internpage(driver);
		iTimeOpt.option();
		Thread.sleep(2000);
		show();
	}
}
