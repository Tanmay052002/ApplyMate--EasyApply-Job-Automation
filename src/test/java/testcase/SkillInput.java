package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import pages.SkillInputpage;
import utilities.readXLData;

public class SkillInput extends basetest{
	SkillInputpage skill;
	
	@Test(dataProviderClass = readXLData.class, dataProvider = "testData")
	public void input(String Skill) throws InterruptedException, IOException{
		skill = new SkillInputpage(driver);
		skill.input(Skill);
		enter();
	}
}
