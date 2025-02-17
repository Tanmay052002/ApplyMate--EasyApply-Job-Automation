package easyApplytestcase;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.testng.annotations.Test;

import basetest.basetest;
import easyApplypage.review_btnpage;

public class review_btn extends basetest{

	review_btnpage reviewOpt;
	
	@Test
	public void review_btnOpt() throws ExecutionException,IOException{
		reviewOpt = new review_btnpage(driver);
		reviewOpt.option();
	}
}
