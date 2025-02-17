package filterTestcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import filterpages.JobType_fullTimepage;

public class JobType_fullTime extends basetest{
	JobType_fullTimepage fTimeOpt;
	
	@Test
	public void fullTimeopt() throws InterruptedException, IOException{
		fTimeOpt = new JobType_fullTimepage(driver);
		fTimeOpt.option();
	}
}
