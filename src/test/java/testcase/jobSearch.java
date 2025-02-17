package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import pages.jobSearchPage;

public class jobSearch extends basetest{
	
	jobSearchPage jobs;
	
//	(dependsOnMethods = {"testcase.login.login"} )
	@Test
	public void jobSrh() throws InterruptedException,IOException{
		
		jobs = new jobSearchPage(driver);
		jobs.job_btn();
		
		
	}
}
