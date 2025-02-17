package easyApplytestcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import easyApplypage.Next_btnpage;

public class Next_btn extends basetest{
	Next_btnpage nextOpt;
	
	@Test
	public void nextbtn() throws InterruptedException, IOException{
		nextOpt = new Next_btnpage(driver);
		nextOpt.option();
	}
}
