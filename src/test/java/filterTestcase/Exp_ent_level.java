package filterTestcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import filterpages.Exp_ent_levelpage;

public class Exp_ent_level extends basetest{
	Exp_ent_levelpage entryLvlOpt;
	
	@Test
	public void entryExp() throws InterruptedException, IOException{
		entryLvlOpt = new Exp_ent_levelpage(driver);
		entryLvlOpt.option();
	}
}
