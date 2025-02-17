package easyApplytestcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import easyApplypage.FinalTestpage;

public class FinalTest extends basetest{

	FinalTestpage finalSol;
	@Test
	public void finalTestCase() throws InterruptedException, IOException {
		
		finalSol = new FinalTestpage(driver);
		
		finalSol.Solution();
	}
}
