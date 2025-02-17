package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import basetest.basetest;
import pages.LoginPage;
import utilities.readXLData;

public class login extends basetest {

	LoginPage login;
	
	@Test(dataProviderClass = readXLData.class, dataProvider = "testData")
	public void login(String Username, String Password) throws InterruptedException, IOException {
		
		login = new LoginPage(driver);
		
		login.sign_in();
		login.ent_username(Username);
		login.ent_Password(Password);
		login.remember_me_btn();
		enter();
		
		
	}
}
