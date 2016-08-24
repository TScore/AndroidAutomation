package com.ngage.automationscript.registration;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.android.ddmlib.Log;
import com.ngage.automationscript.utili.NgageAbstrat;
import com.ngage.automationscript.utili.NgageDriver;
import com.ngage.automationscript.utili.NgageUtili;
import com.ngage.automationscript.utili.PropertyHandler;
import com.ngage.bean.RegisterData;
import com.ngage.dblayer.CheckListHandel;
import com.ngage.dblayer.InPutExcelDataExtractor;
import com.ngage.locatercollection.OneToOneLocater;
import com.ngage.locatercollection.OptionLocater;
import com.ngage.locatercollection.RegistrationLocater;

public class RegistrationVerifywindow extends NgageAbstrat
{
	private static Logger Log = Logger.getLogger(NgageUtili.class.getName());
	NgageUtili utili=new NgageUtili();
	CheckListHandel checkListHandel=new CheckListHandel();
	InPutExcelDataExtractor excelData=new InPutExcelDataExtractor();
	private RegistrationLocater registrationLocater=null;
	private OneToOneLocater oneToOneLocater=null;
	private OptionLocater optionLocater=null;
	private String ExcelPath=PropertyHandler.getProperty("CHECKLISTOFANDROID");
	private String testCase=PropertyHandler.getProperty("AUTOMATIONTESTCASE");
	private String UserName=null;
	private String Mobile=null;
	@BeforeTest
	public void openApplication() throws MalformedURLException
	{	
		DOMConfigurator.configure(PropertyHandler.getProperty("Loger"));
		utili.getHomePageNgage();
		//excelData.copyData();
	}
	@BeforeMethod
	public void storeLocater()
	{
		registrationLocater =loadObject(new RegistrationLocater());
		oneToOneLocater =loadObject(new OneToOneLocater());
		optionLocater =loadObject(new OptionLocater());
	}
	@Test
	public void registrationVerifyWindowTest() throws InterruptedException, InvalidFormatException, IOException
	{
		NgageDriver.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		registrationLocater.getAgreeContinueButton().click();
		Log.info("2nd regisation test case!");
		Log.info("click agree continue button");
		List<RegisterData>getResisterDataList =excelData.getResisterDataList(0);
		Log.info("getResisterDataList:"+getResisterDataList.size());
		for(int i = 0; i < getResisterDataList.size(); i++)
		{
		try{
			UserName=getResisterDataList.get(i).getName();
			Log.info("UserName:"+UserName);
			String Country=getResisterDataList.get(i).getCountry();
			Log.info("Country:"+Country);
			Mobile=getResisterDataList.get(i).getMobile();
			Log.info("Mobile"+Mobile);
			String OTP=getResisterDataList.get(i).getOTP();
			Log.info("OTP:"+OTP);
			//utili.getRegistration(UserName, Country, Mobile,OTP);
			registrationLocater.getInputName().sendKeys(UserName);
			Log.info("user sucessfuly send  user name.");
			checkListHandel.setExcelStringData(ExcelPath,0,13, 2,"PASS");
			registrationLocater.getCountryLabel().click();
			Log.info("user sucessfuly send country label");
			utili.getScroolToText(Country);
			Log.info("scrrol to country!");
			//android.widget.TextView[@text='India']
			NgageDriver.driver.findElement(By.xpath("//android.widget.TextView[@text='"+Country+"']")).click();
			Log.info("country selection complete");
			checkListHandel.setExcelStringData(ExcelPath,0,14, 2,"PASS");
			registrationLocater.getMobileNumber().sendKeys(Mobile);
			Log.info("complete to send  mobile number on mobile  eddit text box!");
			checkListHandel.setExcelStringData(ExcelPath,0,16, 2,"PASS");
			registrationLocater.getNextButtion().click();
			Log.info("complete to click next buttion of   regisation page");
			registrationLocater.getNumberChangeLink().click();
			Log.info("complete to click number chnage link !");
			NgageDriver.driver.navigate().back();
			Log.info("complete to click back buttion !");
			registrationLocater.getNumberChangeLink().click();
			Log.info("complete to click number chnage link !");
			registrationLocater.getCountrySelectionButtion().click();
			Log.info("complete to click country selection buttion");
			utili.getScroolToText(Country);
			Log.info("scrool to country selection option");
			NgageDriver.driver.findElement(By.xpath("//android.widget.TextView[@text='"+Country+"']")).click();
			Log.info("country selection complete");
			registrationLocater.getMobileNumberChnage().sendKeys(Mobile);
			Log.info("complete to  send mobile eddit text box!");
			registrationLocater.getConformMobileNoChnage().sendKeys(Mobile);
			Log.info("complete to  send  Conform mobile eddit text box!");
			registrationLocater.getSendButtion().click();
			Log.info("complete click send buttion!");
			String newNumber=registrationLocater.getVerifyNumberText().getText();
			Log.info("excepted number extract from chat page");
			Log.info("actualNumber:"+newNumber);
			//sent to +919853127120
			newNumber = newNumber.replaceAll("[^\\d.]", "");
			//StringBuffer sb = new StringBuffer(newNumber);
			//sb=sb.delete(0,2);
			//Log.info("actualNumber:"+sb);
			AssertJUnit.assertEquals(newNumber,"91"+Mobile);
			Log.info("complete excepted change number with excepted number!");
			registrationLocater.getResentButtion().click();
			Log.info("complete to click resentButtion");
			String AlertMessage=registrationLocater.getAlertMessage().getText();
			Log.info("AlertMessage:"+AlertMessage);
			Log.info("complete to acess text from pop up window!");
			AssertJUnit.assertEquals(AlertMessage,"Code sent to your mobile.");
			registrationLocater.getAlrtClose().click();
			Log.info("complete to close alert pop up window!");
			utili.getWaitForIdPresent("yw.wemet.ngageapp:id/edtVerificationCode",60);
			registrationLocater.getVerificationCode().sendKeys(OTP);
			Log.info("send otp to verification box!");
			checkListHandel.setExcelStringData(ExcelPath,0,15, 2,"PASS");
			//NgageDriver.driver.navigate().back();
			//utili.getWaitForIdPresent("yw.wemet.ngageapp:id/btnFinish",90);
			registrationLocater.getBtnFinish().click();
			Log.info("complete to click button finish buttion");
			//registrationLocater.getSkipButtion().click();
			registrationLocater.getEmailEddit().clear();
			Log.info("clear email id if present");
			registrationLocater.getEmailEddit().sendKeys("tapana.testing@outlook.com");
			Log.info("sending complete emial eddit text");
			NgageDriver.driver.navigate().back();
			Log.info("key ped hide complete!");
			registrationLocater.getRegisterButtion().click();
			Log.info("Complete to Click buttion registerion!");
			//checkListHandel.setExcelStringData(testCase,0,6, 2,"regisation sucessfuly!");
			Log.info("sending to excel sheet!");
		}
		catch(Exception e)
		{
			Log.info("exception in registrationVerifyWindowTest!");
			Log.warn(e);
		}
		}

	}
	@AfterMethod
	public void verifayTest()
	{ 
		
	}
	@AfterTest
	public void closeApplication()
	{

	}
}
