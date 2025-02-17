package filterTestcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import filterpages.Exp_intern_levelpage;

public class Exp_intern_level extends basetest{
	Exp_intern_levelpage internlvlOpt;
	
	@Test
	public void interExpopt() throws InterruptedException, IOException{
		internlvlOpt = new Exp_intern_levelpage(driver);
		internlvlOpt.option();
	}
}
