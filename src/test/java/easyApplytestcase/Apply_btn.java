package easyApplytestcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import easyApplypage.Apply_btnpage;

public class Apply_btn extends basetest{
	Apply_btnpage applyOpt;
	
	@Test
	public void applyBtn() throws InterruptedException, IOException{
		applyOpt = new Apply_btnpage(driver);
		applyOpt.option();
	}
}
