package com.ngage.automationscript.registration;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
/*@Authore:Tapana
 *@Date:16AUG2016
 *@Descraption:This class cover all registration testcase.
 * */
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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
import io.selendroid.server.common.exceptions.NoSuchElementException;

/*@Authore:Tapana
 *@Date:16Aug2016
 *@Descrption: 
 * 
 * */
public class NgageRegistration extends NgageAbstrat{
	private static Logger Log = Logger.getLogger(NgageUtili.class.getName());
	NgageUtili utili=new NgageUtili();
	CheckListHandel checkListHandel=new CheckListHandel();
	InPutExcelDataExtractor excelData=new InPutExcelDataExtractor();
	private RegistrationLocater registrationLocater=null;
	private String ExcelPath=PropertyHandler.getProperty("CHECKLISTOFANDROID");
	private String testCase=PropertyHandler.getProperty("AUTOMATIONTESTCASE");
	private OneToOneLocater oneToOneLocater=null;
	private OptionLocater optionLocater=null;
	private String UserName=null;
	private String Mobile=null;
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
		oneToOneLocater =loadObject(new OneToOneLocater());
		optionLocater =loadObject(new OptionLocater());
	}
	@Test
	public void termOfServiceTest () throws IOException, InvalidFormatException
	{
		try
		{

			NgageDriver.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			registrationLocater.getTermOfService().click();
			Log.info("--click term of service--!");
			checkListHandel.setExcelStringData(testCase,0,1,2,"--click term of service--!");
			registrationLocater.getCloseButtion().click();
			Log.info("Click close buttion of teram of condiation!");
			checkListHandel.setExcelStringData(testCase,0,2,2,"Click close buttion of teram of condiation!");
			checkListHandel.setErrorMessage(ExcelPath,0,7, 2,"PASS");
			registrationLocater.getPrivacyPolicy().click();
			Log.info("Click privacy policy--!");
			checkListHandel.setExcelStringData(testCase,0,3,2,"Click privacy policy--!");
			registrationLocater.getCloseButtion().click();
			Log.info("--close buttion--!");
			checkListHandel.setExcelStringData(testCase,0,4,2,"--close buttion--!");
			checkListHandel.setErrorMessage(ExcelPath,0,8, 2,"PASS");
			registrationLocater.getAcceptableFairUsePolicy().click();
			Log.info("--getAcceptableFairUsePolicy link test--");
			checkListHandel.setExcelStringData(testCase,0,5,2,"--getAcceptableFairUsePolicy link test--");
			registrationLocater.getCloseButtion().click();
			Log.info("--Click Close Buttion!--");
			checkListHandel.setExcelStringData(testCase,0,6,2,"--Click Close Buttion!--");
			checkListHandel.setErrorMessage(ExcelPath,0,9, 2,"PASS");
			registrationLocater.getCookiesPolicy().click();
			Log.info("--Click Cookies  Policy!--");
			checkListHandel.setExcelStringData(testCase,0,7,2,"--Click Cookies  Policy!--");
			registrationLocater.getCloseButtion().click();
			Log.info("--Close Buttion!--");
			checkListHandel.setExcelStringData(testCase,0,8,2,"--Close Buttion!--");
			checkListHandel.setExcelStringData(ExcelPath,0,10, 2,"PASS");
			//checkListHandel.setExcelStringData(testCase,0,2, 2,"all terms and condition working sucessfuly");
			registrationLocater.getAgreeContinueButton().click();
			Log.info("sucessfuly click agree continue button");
			checkListHandel.setExcelStringData(testCase,0,9,2,"sucessfuly click agree continue button");
			checkListHandel.setErrorMessage(ExcelPath,0,11, 2,"PASS");
			//----------------one test case complete--------------//
			String actual=registrationLocater.getExceptedLocater().getText();
			Log.info("actual name:"+actual);
			AssertJUnit.assertEquals(actual,"REGISTER");
			Log.info("--TermOfService iS working fine--");
			checkListHandel.setExcelStringData(testCase,0,10,2,"sucessfuly  registration page is displaying !");

		}catch(Exception e)
		{
			Log.info("Exception in termOfServiceTest");
			checkListHandel.setExcelStringData(testCase,0,11,2,"Exception in termOfServiceTest case.");
			utili.getTakeScreenShot("termOfServiceTest");
			Log.warn(e);
		}
	}
	@Test(dependsOnMethods = {"termOfServiceTest"})
	//@Test
	public void registerPageTest() throws InterruptedException, InvalidFormatException, IOException
	{
		try{
			NgageDriver.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//registrationLocater.getAgreeContinueButton().click();
			Log.info("2nd regisation test case!");
			List<RegisterData>getResisterDataList =excelData.getResisterDataList(0);
			Log.info("getResisterDataList:"+getResisterDataList.size());
			for(int i = 0; i < getResisterDataList.size(); i++)
			{
				UserName=getResisterDataList.get(i).getName();
				Log.info("UserName:"+UserName);
				String Country=getResisterDataList.get(i).getCountry();
				Log.info("Country:"+Country);
				Mobile=getResisterDataList.get(i).getMobile();
				Log.info("Mobile"+Mobile);
				String OTP=getResisterDataList.get(i).getOTP();
				Log.info("OTP:"+OTP);
				utili.getRegistration(UserName, Country, Mobile,OTP);
				checkListHandel.setExcelStringData(testCase,0,11,2,"sucessfuly registration complete!");
			}
		}catch(Exception e)
		{
			Log.info("Exception in registerPageTest");
			checkListHandel.setErrorMessage(testCase,0,11,2,"Exception in registerPageTest");
			utili.getTakeScreenShot("Exception in registerPageTest");
			Log.warn(e);
		}
	}

	@AfterClass
	public void verifayRegisationDataTest() throws InvalidFormatException, IOException
	{
		try{
			utili.getWaitForIdPresent("yw.wemet.ngageapp:id/tvCreateNew",60);
			oneToOneLocater.getStratNewConversation().click();
			Log.info("in chat page user sucessfuly click start Conversation buttion!,close 1stalrt pop up");
			checkListHandel.setExcelStringData(testCase,0,12,2,"in chat page user sucessfuly click start Conversation buttion!,close 1stalrt pop up");
			oneToOneLocater.getStratNewConversation().click();
			Log.info("in chat page user sucessfuly click start Conversation buttion!,close 2nd talrt pop up");
			checkListHandel.setExcelStringData(testCase,0,13,2,"in chat page user sucessfuly click start Conversation buttion!,close 2nd talrt pop up");
			oneToOneLocater.getSharingManu().click();
			Log.info("sucessfuly click sharing manu and close 3rd pop up");
			checkListHandel.setExcelStringData(testCase,0,14,2,"sucessfuly click sharing manu and close 3rd pop up");
			oneToOneLocater.getBackButtionSharingManu().click();
			Log.info("sucessfuly click back buttion");
			checkListHandel.setExcelStringData(testCase,0,15,2,"sucessfuly click back buttion");
			optionLocater.getOptionButtion().click();
			Log.info("sucessfuly click option buttion");
			checkListHandel.setExcelStringData(testCase,0,16,2,"sucessfuly click option buttion");
			optionLocater.getProfile().click();
			Log.info("sucessfuly click option > profile  buttion");
			checkListHandel.setExcelStringData(testCase,0,17,2,"sucessfuly click option > profile  buttion");
			String actualName=optionLocater.getProfileName().getText();
			Log.info("actualName"+actualName);
			Assert.assertEquals(UserName,actualName);
			Log.info("sucessfuly click verifay");
			checkListHandel.setExcelStringData(testCase,0,18,2,"sucessfuly actual regisation name with excepted name!");
		}
		catch(Exception e)
		{
			Log.info("Exception in verifayRegisationDataTest");
			checkListHandel.setErrorMessage(testCase,0,19,2,"Exception in verifayRegisationDataTest");
			utili.getTakeScreenShot("Exception in verifayRegisationDataTest");
			Log.warn(e);
		}
	}
	@AfterTest
	public void closeApplication()
	{
		//NgageDriver.driver.quit();
	}




}
