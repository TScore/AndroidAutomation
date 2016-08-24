package com.ngage.automationscript.registration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.ngage.automationscript.utili.NgageAbstrat;
import com.ngage.automationscript.utili.NgageDriver;
import com.ngage.automationscript.utili.NgageUtili;
import com.ngage.automationscript.utili.PropertyHandler;
import com.ngage.dblayer.CheckListHandel;
import com.ngage.dblayer.InPutExcelDataExtractor;
import com.ngage.locatercollection.OneToOneLocater;
import com.ngage.locatercollection.OptionLocater;
import com.ngage.locatercollection.RegistrationLocater;

public class Registration extends NgageAbstrat {
	
	/*@Authore:Tapana Kumar Badhai
	 *@Date:18 Aug 2016
	 *@Descrtion:complete all registration function
	 * */
	private static Logger Log = Logger.getLogger(NgageUtili.class.getName());
	NgageUtili utili=new NgageUtili();
	CheckListHandel checkListHandel=new CheckListHandel();
	InPutExcelDataExtractor excelData=new InPutExcelDataExtractor();
	private RegistrationLocater registrationLocater=null;
	private OneToOneLocater oneToOneLocater=null;
	private OptionLocater optionLocater=null;
	private String ExcelPath=PropertyHandler.getProperty("CHECKLISTOFANDROID");
	@BeforeTest
	public void openApplication() throws MalformedURLException
	{	
		DOMConfigurator.configure(PropertyHandler.getProperty("Loger"));
		utili.getHomePageNgage();
		excelData.copyData();
	}
	@BeforeClass
	public void storeLocater()
	{
		registrationLocater =loadObject(new RegistrationLocater());
	}
	@Test
	public void RegistrationTest() throws IOException, InvalidFormatException
	{
		NgageDriver.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Log.info("-Open n-age page terms and condition page--!");
		registrationLocater.getTermOfService().click();
		Log.info("--open application click termOfService!--");
		
		//registrationLocater.getCloseButtion().click();
		//checkListHandel.setExcelStringData(ExcelPath, 0, 7, 2, "PASS");
		//registrationLocater.getPrivacyPolicy().click();
		//registrationLocater.getCloseButtion().click();
		//checkListHandel.setExcelStringData(ExcelPath,0,8, 2,"PASS");
		//registrationLocater.getAcceptableFairUsePolicy().click();
		//registrationLocater.getCloseButtion().click();
		//checkListHandel.setExcelStringData(ExcelPath,0,9, 2,"PASS");
		//registrationLocater.getCookiesPolicy().click();
		//registrationLocater.getCloseButtion().click();
		//checkListHandel.setExcelStringData(ExcelPath,0,10, 2,"PASS");
		//registrationLocater.getAgreeContinueButton().click();
		//checkListHandel.setErrorMessage(ExcelPath,0,11, 2,"PASS");
		//----------------one test case complete--------------//
		//String actual=registrationLocater.getExceptedLocater().getText();
		//Log.info("actual name:"+actual);
		//AssertJUnit.assertEquals(actual,"REGISTER");
	}
	@BeforeClass
	public void edditExcelSheet()
	{ 
		//TODO..
		
		//oneToOneLocater.getStratNewConversation().click();
		//oneToOneLocater.getStratNewConversation().click();
		//oneToOneLocater.getSharingManu().click();
		//oneToOneLocater.getBackButtionSharingManu().click();
		//optionLocater.getOptionButtion().click();
		//optionLocater.getProfile().click();
		
	}
	@AfterTest
	public void closeApplication()
	{

	}
	
}
