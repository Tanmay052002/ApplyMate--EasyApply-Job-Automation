package questiontestcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import questionspage.QuestionTextPage;

public class QuestionText extends basetest{
	QuestionTextPage getquestion;
	
	@Test
	public void getQues() throws InterruptedException, IOException{
		getquestion = new QuestionTextPage(driver);
		getquestion.ques();
	}
}
