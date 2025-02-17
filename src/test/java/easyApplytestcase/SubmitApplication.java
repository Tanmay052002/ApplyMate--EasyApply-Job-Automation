package easyApplytestcase;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.testng.annotations.Test;

import basetest.basetest;
import easyApplypage.SubmitApplicationpage;

public class SubmitApplication extends basetest{

	SubmitApplicationpage submitOpt;
	
	@Test
	public void submitAppOpt() throws ExecutionException,IOException{
		submitOpt = new SubmitApplicationpage(driver);
		submitOpt.option();
	}
}
