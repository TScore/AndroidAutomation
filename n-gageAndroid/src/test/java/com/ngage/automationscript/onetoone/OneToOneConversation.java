package com.ngage.automationscript.onetoone;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.android.ddmlib.Log;
import com.ngage.automationscript.utili.NgageAbstrat;
import com.ngage.automationscript.utili.NgageDriver;
import com.ngage.automationscript.utili.NgageUtili;
import com.ngage.automationscript.utili.PropertyHandler;
import com.ngage.bean.OneToOneConversationData;
import com.ngage.bean.RegisterData;
import com.ngage.dblayer.CheckListHandel;
import com.ngage.dblayer.InPutExcelDataExtractor;
import com.ngage.locatercollection.OneToOneLocater;
import com.ngage.locatercollection.OptionLocater;
import com.ngage.locatercollection.RegistrationLocater;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
/*@Authore:Tapana Kumar Badhai
 *@Date:18th Aug 2016 
 *@in this class user chat with other user!
 * 
 * */
public class OneToOneConversation extends NgageAbstrat
{
	private static Logger Log = Logger.getLogger(OneToOneConversation.class.getName());
	NgageUtili utili=new NgageUtili();
	CheckListHandel checkListHandel=new CheckListHandel();
	InPutExcelDataExtractor excelData=new InPutExcelDataExtractor();
	private RegistrationLocater registrationLocater=null;
	private OneToOneLocater oneToOneLocater=null;
	private OptionLocater optionLocater=null;
	private List<WebElement>webList =null;
	private String ExcelPath=PropertyHandler.getProperty("CHECKLISTOFANDROID");
	private String testCase=PropertyHandler.getProperty("AUTOMATIONTESTCASE");
	@BeforeClass
	public void openApplication() throws MalformedURLException
	{
		DOMConfigurator.configure(PropertyHandler.getProperty("Loger"));
		utili.getHomePage();
	}
	@BeforeMethod
	public void storeLocater()
	{
		registrationLocater =loadObject(new RegistrationLocater());
		oneToOneLocater =loadObject(new OneToOneLocater());
		optionLocater =loadObject(new OptionLocater());
	}
	@Test
	public void oneToOneConversationTest() throws InterruptedException, MalformedURLException
	{
		NgageDriver.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Click chat button --which is navigate to chat page.
		oneToOneLocater.getChatButton().click();
		Log.info("--click chat button--!");
		List<OneToOneConversationData>oneToOneConversationDataList =excelData.getOneToOneData(1);
		Log.info("oneToOneConversationDataList:"+oneToOneConversationDataList.size());
		for(int i = 0; i < oneToOneConversationDataList.size(); i++)
		{
			try
			{
				String exceptedName=oneToOneConversationDataList.get(i).getContactNumber();
				Log.info("get data from excel sheet and verifay!");
				utili.getUserForOneToOneList(exceptedName);
				int data=oneToOneConversationDataList.get(i).getMessageSendingNumber();
				String Message=oneToOneConversationDataList.get(i).getMessageText();
				
				
				try
				{
					utili.getChatMakeOver();
					Log.info("complte to test chatMakeOver note!");
					checkListHandel.setExcelStringData(testCase,0,30, 2,"one to one chnage chat theme");
				}catch(Exception e)
				{
					Log.warn(e);
					Log.info("exception in chatMakeOver note  testing");
					utili.getTakeScreenShot("exception inc hatMakeOver note error");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,30, 2,"exception in chatMakeOver note  testing");
				}
				
				//for(int k=1;k<=data;k++)
				//{
				utili.getSendText(Message);
				Log.info("message sending complete");
				checkListHandel.setExcelStringData(testCase,0,20, 2,"one to one send text message");
				//}

				//---------------------long click audio recording sending----------------------	
				//send audio message
				By captureButtonLocator = MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"yw.wemet.ngageapp:id/btnAudio\")");
				//WebElement audioRecordBution=oneToOneLocater.getAudioButtion();
				TouchAction action = new TouchAction(NgageDriver.driver);
				//action.longPress(audioRecordBution).release().perform();
				action.press(NgageDriver.driver.findElement(captureButtonLocator)).waitAction(5000) .release().perform();

				//---------------------sending sticker to user---------------------
				try
				{
					utili.getSticker();
					Log.info("//---------------------sending sticker to user---------------------");
					checkListHandel.setExcelStringData(testCase,0,21, 2,"one to one send sticker");
				}catch(Exception  e)
				{
					utili.getTakeScreenShot("sticker error");
					Log.info("exception in sendind sticker !");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,21, 2,"exception in sendind sticker");
				}
				
				
				
				//-----------------------sending doodle image--------------------
				try
				{
				utili.getDoodle();
				checkListHandel.setExcelStringData(testCase,0,22, 2,"one to one send doodle image");
				}catch(Exception e)
				{
					utili.getTakeScreenShot("Doodle error");
					Log.info("exception in doodle sending !");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,22, 2,"exception in doodle sending");
				}
				Log.info("//-----------------------sending doodle image--------------------");
				/*	try
				{
					utili.getSendADocument();
					Log.info("sending documnet!");
					oneToOneLocater.getFileName().click();
					Log.info("File selection verifay!");
				}catch(Exception e)
				{
					Log.info("---exception in sending document--!");
					utili.getTakeScreenShot("error in sending file");
				}*/
				try
				{
					utili.getLifie();
					Log.info("lifie module is testing complete!");
					checkListHandel.setExcelStringData(testCase,0,23, 2,"one to one send lifie image");
				}
				
				catch(UnreachableBrowserException d)
				{
					utili.getTakeScreenShot("lifie error");
					Log.warn(d);
					Log.info("exception in lifie testing");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,23, 2,"exception in lifie testing");
				}
				catch(Exception e)
				{
					utili.getTakeScreenShot("lifie error");
					Log.warn(e);
					Log.info("exception in lifie testing");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,23, 2,"exception in lifie testing");
				}
				try
				{
					utili.getKlipy();
					Log.info("klipy  module is testing complete!");
					checkListHandel.setExcelStringData(testCase,0,24, 2,"one to one send klipy image");
				}
				catch(Exception e)
				{
					Log.warn(e);
					Log.info("exception in klipy  testing");
					utili.getTakeScreenShot("klipy  error");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,24, 2,"exception in klipy  testing");
				}
				try
				{
					utili.getKollage();
					Log.info("kollage   module is testing complete!");
					checkListHandel.setExcelStringData(testCase,0,25, 2,"one to one send Kollage image");
				}
				catch(Exception e)
				{
					Log.warn(e);
					Log.info("exception in kollage   testing");
					utili.getTakeScreenShot("kollage  error");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,25, 2,"exception in kollage   testing");
				}
				try
				{
					utili.getGreeting();
					Log.info("greeting  module is testing complete!");
					checkListHandel.setExcelStringData(testCase,0,26, 2,"one to one send greeting image");
				}
				catch(Exception e)
				{
					Log.warn(e);
					Log.info("exception in greeting    testing");
					utili.getTakeScreenShot("greeting  error");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,26, 2,"exception in greeting    testing");
				}
				//oneToOneLocater.getAttachmentButtion().click();
				//utili.getScroolToText("android.widget.GridView","Face Detector");
				
				// Scroll to locater of webLink
				try
				{
					utili.getLocation();
					Log.info("complte to test location!");
					checkListHandel.setExcelStringData(testCase,0,27, 2,"one to one send location");
				}catch(Exception e)
				{
					Log.warn(e);
					Log.info("exception in location  testing");
					utili.getTakeScreenShot("location  error");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,27, 2,"exception in location  testing");
				}
				
				try
				{
					utili.getOtherLocation();
					Log.info("complte to test other location!");
					checkListHandel.setExcelStringData(testCase,0,28, 2,"one to one send previes location");
				}catch(Exception e)
				{
					Log.warn(e);
					Log.info("exception in previes location  error  testing");
					utili.getTakeScreenShot("previes location  error");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,28, 2,"exception in previes location  error  testing");
				}
				
				try
				{
					utili.getVideoNote();
					Log.info("complte to test video  note!");
					checkListHandel.setExcelStringData(testCase,0,29, 2,"one to one send video note");
				}catch(Exception e)
				{
					Log.warn(e);
					Log.info("exception in video note  testing");
					utili.getTakeScreenShot("exception in video note  error");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,29, 2,"exception in video note  error");
				}
				
				try
				{
					utili.getChatMakeOver();
					Log.info("complte to test chatMakeOver note!");
					checkListHandel.setExcelStringData(testCase,0,30, 2,"one to one chnage chat theme");
				}catch(Exception e)
				{
					Log.warn(e);
					Log.info("exception in chatMakeOver note  testing");
					utili.getTakeScreenShot("exception inc hatMakeOver note error");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,30, 2,"exception in chatMakeOver note  testing");
				}

				try
				{
					utili.getShareContact();
					Log.info("complte to test share contact !");
					checkListHandel.setExcelStringData(testCase,0,31, 2,"one to one share contact");
				}catch(Exception e)
				{
					Log.warn(e);
					Log.info("exception in share contact  note  testing");
					utili.getTakeScreenShot("exception in share conact  note  testing  error");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,31, 2,"exception in share contact   note  testing");
				}
				
				try
				{
					utili.getSendCamera();
					Log.info("complte to test capture image module !");
					checkListHandel.setExcelStringData(testCase,0,32, 2,"one to one send capture image");
				}catch(Exception e)
				{
					Log.warn(e);
					Log.info("exception in test capture image module  testing");
					utili.getTakeScreenShot("exception in test capture image module  testing  error");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,32, 2,"exception in test capture image module  testing");
				}
				try
				{
					utili.getsendTextTamplet();
					Log.info("complte to test sending text tamplet module !");
					checkListHandel.setExcelStringData(testCase,0,33, 2,"one to one send text tamplet");
				}catch(Exception e)
				{
					Log.warn(e);
					Log.info("exception in test sending text tamplet  testing");
					utili.getTakeScreenShot("exception test sending text tamplet");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,33, 2,"exception in test sending text tamplet  testing");
				}
				
				try
				{
					utili.getSendFaceDetector();
					Log.info("complte to test face detector module !");
					checkListHandel.setExcelStringData(testCase,0,34, 2,"one to one send face detector");
				}catch(Exception e)
				{
					Log.warn(e);
					Log.info("exception in test face detectort  testing");
					utili.getTakeScreenShot("exception test face detector tamplet");
					NgageDriver.driver.quit();
					Log.info("quit application");
					utili.getHomePage();
					Log.info("open home page!");
					utili.getUserForOneToOneList(exceptedName);
					checkListHandel.setExcelStringData(testCase,0,34, 2,"exception in test face detectort  testing");
				}
			}
			catch(Exception e)
			{
				Log.info("exception in one to conversation ");
				NgageDriver.driver.quit();
				utili.getHomePage();
				Log.info("open home page!");
				Log.info("quit application");
			}
		}
	}
	@AfterMethod
	public void varification()
	{

	}
	@AfterClass
	public void closeApplication()
	{

	}
}
