package filterTestcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import filterpages.Easyapplypage;

public class Easyapply extends basetest{
	Easyapplypage easy_applyOpt;
	
	@Test
	public void easyApplybtn() throws InterruptedException, IOException{
		easy_applyOpt = new Easyapplypage(driver);
		easy_applyOpt.option();
	}
}
