package com.ngage.automationscript.utili;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.Augmentable;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.android.ddmlib.Log;
import com.ngage.dblayer.CheckListHandel;
import com.ngage.dblayer.InPutExcelDataExtractor;
import com.ngage.locatercollection.OneToOneLocater;
import com.ngage.locatercollection.OptionLocater;
import com.ngage.locatercollection.RegistrationLocater;
import com.sun.jmx.snmp.Timestamp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
public class NgageUtili extends NgageAbstrat
{
	private JavascriptExecutor js=null;
	private 	WebElement element=null;
	private static Logger Log = Logger.getLogger(NgageUtili.class.getName());
	private String SelectionMember=null;
	private String apkID=null;
	private List<WebElement>webList =null;
	private RegistrationLocater registrationLocater=null;
	private OneToOneLocater oneToOneLocater=null;
	private OptionLocater optionLocater=null;
	InPutExcelDataExtractor inPutExcelDataExtractor=new InPutExcelDataExtractor();
	CheckListHandel checkListHandel=new CheckListHandel();
	private String ExcelPath=PropertyHandler.getProperty("CHECKLISTOFANDROID");
	private String TestCase=PropertyHandler.getProperty("AUTOMATIONTESTCASE");
	public void getHomePageNgage() throws MalformedURLException
	{	
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("deviceName", "ASUS_Z008D");
		capabilities.setCapability("app", "/Users/Swapnil/Desktop/RestAPI/ngageFinal-debug-unaligned.apk");
		capabilities.setCapability("appPackage", "yw.wemet.ngageapp");
		//new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		NgageDriver.driver= new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	}

	public void getHomePage() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("fullReset",false);
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("deviceName", "ASUS_Z008D");
		capabilities.setCapability("app", "/Users/Swapnil/Desktop/RestAPI/ngageFinal-debug-unaligned.apk");
		capabilities.setCapability("appPackage", "yw.wemet.ngageapp");
		//new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		NgageDriver.driver= new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	}
	public void getWaitForElementPresent(String elementXpath,int time)
	{ 	
		WebDriverWait wt = new WebDriverWait(NgageDriver.driver,time);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
	}
	public void getWaitForNamePresent(String Name,int time)
	{	
		WebDriverWait wt = new WebDriverWait(NgageDriver.driver, time);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.name(Name)));
	}
	public void getWaitForIdPresent(String id,int time)
	{		
		WebDriverWait wt = new WebDriverWait(NgageDriver.driver,time);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	public void getDroupDown(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}

	public void getScroolToText(String Scrooltext)
	{
		HashMap scrollObject = new HashMap();
		RemoteWebElement element = (RemoteWebElement)NgageDriver.driver.findElement(By.className("android.widget.ListView"));
		JavascriptExecutor js = (JavascriptExecutor)NgageDriver.driver;
		String webElementId = ((RemoteWebElement) element).getId();
		scrollObject.put("text", Scrooltext);
		scrollObject.put("element", webElementId);
		js.executeScript("mobile: scrollTo", scrollObject);
	}
	
	public void getScroolToText(String Xapth,String Scrooltext)
	{
		HashMap scrollObject = new HashMap();
		RemoteWebElement element = (RemoteWebElement)NgageDriver.driver.findElement(By.className(Xapth));
		JavascriptExecutor js = (JavascriptExecutor)NgageDriver.driver;
		String webElementId = ((RemoteWebElement) element).getId();
		scrollObject.put("text", Scrooltext);
		scrollObject.put("element", webElementId);
		js.executeScript("mobile: scrollTo", scrollObject);
	}

	public void getTakeScreenShot(String testName) 
	{	
		try {
			Timestamp timestamp = new Timestamp(new Date().getTime());
			String filename = PropertyHandler.getProperty("TAKESCREENHOT")+testName+timestamp+".jpg";
			WebDriver augmentedDriver = new Augmenter().augment(NgageDriver.driver);
			if (NgageDriver.driver.getClass().isAnnotationPresent(Augmentable.class)) 
			{
				NgageDriver.driver = (AppiumDriver) new Augmenter().augment(NgageDriver.driver);
			} else
			{
				System.out.println("Non augmentable, so augmentation can be performed but does nothing");
				NgageDriver.driver = (AppiumDriver) new Augmenter().augment(NgageDriver.driver);
			}
			File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filename), true);
		} 
		catch (IOException e)
		{

		} catch (Exception e) 
		{
			Log.info("exception in taking screen shot");
		}
	}	
	public void getRegistration(String UserName,String Country,String Mobile,String OTP) throws InvalidFormatException, IOException
	{
		try{
			registrationLocater =loadObject(new RegistrationLocater());
			registrationLocater.getInputName().sendKeys(UserName);
			Log.info("Input name");
			checkListHandel.setExcelStringData(ExcelPath,0,13, 2,"PASS");
			registrationLocater.getCountryLabel().click();
			Log.info("CountryLabel fild acess!");
			getScroolToText(Country);
			Log.info("scrrol to country selection!");
			//android.widget.TextView[@text='India']
			NgageDriver.driver.findElement(By.xpath("//android.widget.TextView[@text='"+Country+"']")).click();
			Log.info("sucessfuly select country");
			checkListHandel.setExcelStringData(ExcelPath,0,14, 2,"PASS");
			registrationLocater.getMobileNumber().sendKeys(Mobile);
			Log.info("sucessfuly send mobile number to mobile eddit page!");
			checkListHandel.setExcelStringData(ExcelPath,0,16, 2,"PASS");
			Log.info("mobile number fild complet!");
			//NgageDriver.driver.navigate().back();
			registrationLocater.getNextButtion().click();
			Log.info("sucessfuly click next buttion");
			checkListHandel.setExcelStringData(ExcelPath,0,17, 2,"PASS");
			registrationLocater.getVerificationCode().sendKeys(OTP);
			Log.info("sucessfuly send otp to otp eddit option");
			checkListHandel.setExcelStringData(ExcelPath,0,15, 2,"PASS");
			NgageDriver.driver.navigate().back();
			Log.info("sucessfuly user click back buttion");
			getWaitForIdPresent("yw.wemet.ngageapp:id/btnFinish",90);
			registrationLocater.getBtnFinish().click();
			Log.info("sucessfuly user click finish buttion!");
			registrationLocater.getSkipButtion().click();
			Log.info("sucessfuly user click skip buttion of regisater page");
		}catch(Exception e)
		{
			getTakeScreenShot("Registration");
			Log.info("exception in getRegistration method");
			Log.warn(e);
		}
	}
	public  void    getUserForOneToOneList(String exceptedName)
	{
		try
		{
			oneToOneLocater =loadObject(new OneToOneLocater());
			Log.info("one to locater load");
			oneToOneLocater.getStratNewConversation().click();
			Log.info("load locater of start new conversation!");
			optionLocater =loadObject(new OptionLocater());
			//send number to search box.
			Log.info("searchingName "+exceptedName);
			oneToOneLocater.getNewOneToOneSearchBox().sendKeys(exceptedName);
			Log.info("complete send to number to search panel");
			try
			{
				getWaitForElementPresent("//android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]",90);
				webList=NgageDriver.driver.findElements(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"));
				Log.info("store list of user which is found from contact  list");
				//String actualname=oneToOneLocater.getSearchListName().getText();
				//Log.info("actualName"+actualname);
				//oneToOneLocater.getSearchListName().click();
				if(webList!=null )
				{
					for(int l=1;l<=webList.size();l++)
					{
						try
						{
							//String actualName=webList.get(l).getText();
							NgageDriver.driver.findElement(By.xpath("//android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]")).click();
							Log.info("click log click buttion and log click pop up is displaying!");
							oneToOneLocater.getMoreButtionformSelect().click();
							Log.info("click more buttion of log click pop up window!");
							oneToOneLocater.getViewProfile().click();
							Log.info("click view profile image buttion!");
							Actions action = new Actions(NgageDriver.driver);
							action.sendKeys(Keys.PAGE_DOWN);
							Log.info("scrool to Personal Details text manu");
							String actualNumber=optionLocater.getProfileNumber().getText();
							//919029003061
							Log.info("actualNumber:"+actualNumber);
							optionLocater.getProfileBackButtion().click();
							Log.info("click back buttion of profile image!");

							if(("91"+exceptedName).equals(actualNumber))
							{
								//webList.get(l).click();
								NgageDriver.driver.findElement(By.xpath("//android.widget.LinearLayout["+l+"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
								Log.info("click actual contact user!");
								break;
							}
							else
							{
								Log.info("user is not found!");
							}
						}
						catch(Exception e)
						{
							Log.info("Exception in for loop of user selection!");	
						}
					}
				}
				else
				{
					Log.info("webList is not present!");	
				}
			}catch(Exception e)
			{
				Log.info("user list is not displaying");
				Log.warn(e);

			}
		}
		catch(Exception e)
		{
			Log.info("exception selection user!");
			Log.warn(e);
		}

	}
	public void getSendText(String message)
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		oneToOneLocater.getTextEditBox().sendKeys(message);
		Log.info("complete text message to text edit option!");
		oneToOneLocater.getSendButtion().click();
		Log.info("Complete to click sending buttion");
	}
	public void getSticker() throws InterruptedException
	{	
		oneToOneLocater =loadObject(new OneToOneLocater());
		oneToOneLocater.getButtionSticker().click();
		Log.info("click sticker buttion!");
		getWaitForIdPresent("yw.wemet.ngageapp:id/Template_tvCategoryName", 90);
		Log.info("wait sticker loading!");
		oneToOneLocater.getStickerSelect().click();
		Log.info("footer sticker selection complete!");

		try
		{
			NgageDriver.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			oneToOneLocater.getStickerDownlodeButtion().click();
			Log.info("downlode sticker click complete!");
			oneToOneLocater.getDownlodeAllFreeSticker().click();
			Log.info("download all sticker! wthich is free catogories!");
			String ButionMessage=oneToOneLocater.getDownlodeAllFreeSticker().getText();
			Thread.sleep(5000);
			Log.info("ButionMessage:"+ButionMessage);
			oneToOneLocater.getBackButtion().click();
			Log.info("click backButtion of sticker gallery");
			oneToOneLocater.getStickerSelect().click();
			Log.info("click foter sticker buttion!");
		}catch(Exception e)
		{
			NgageDriver.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Log.info("allrady sticker download   complete!");

		}

		//getWaitForElementPresent("//android.widget.ImageView[2]",90);
		Log.info("--wait sticker download ,wait some time after!");
		oneToOneLocater.getStickerSend().click();
		Log.info("click sticker from sticker gallery!");
		oneToOneLocater.getStickerSendingButtion().click();
		Log.info("click sending sticker buttion!");

	}

	public void getDoodle()
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		Log.info("one to one locater loading");
		oneToOneLocater.getDoodeButtion().click();
		Log.info("Doodle buttion click!");
		oneToOneLocater.getDoodleDecorate().click();
		Log.info("doodle Decorate is clicking!");
		oneToOneLocater.getDoodleCollerDecorate().click();
		Log.info("click doodle color decorate buttion!");
		oneToOneLocater.getDoodleImagesendingButtion().click();
		Log.info("sending doodle image!");
	}
	public void getSendADocument()
	{

		oneToOneLocater =loadObject(new OneToOneLocater());
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click AttachmentButtion buttion !");
		oneToOneLocater.getFileAttachmentButtion().click();
		Log.info("click attachment buttion scuessfuly!");
		oneToOneLocater.getSelectFolder().click();
		Log.info("select folder!");
		oneToOneLocater.getFileSelection().click();
		Log.info("file slection complete");

	}
	public void getLifie()
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click AttachmentButtion buttion !");
		oneToOneLocater.getLifieButtion().click();
		Log.info("lifie image buttion complete to click");
		oneToOneLocater.getCaptureImage().click();
		Log.info("click capture image buttion");
		oneToOneLocater.getLifieSendButtion().click();
		Log.info("click send buttion of life!");
	}
	public void getKlipy() throws InterruptedException
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click AttachmentButtion buttion !");
		oneToOneLocater.getKlipyButtion().click();
		Log.info("click klipy buttion complete!");
		Thread.sleep(5000);
		oneToOneLocater.getSelectKlipyFromFooterPanel().click();
		Log.info("selct klipy from footer panel--");
		try
		{
			NgageDriver.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			oneToOneLocater.getStickerDownlodeButtion().click();
			Log.info("click downlode buttion which is present in klipy page");
			oneToOneLocater.getKollageStickerForGalleryDownlode().click();
			Log.info("click one of klipy from klipy gallery!");
			oneToOneLocater.getBackButtion().click();
			Log.info("click backButtion of sticker gallery");
		}catch(Exception e)
		{
			NgageDriver.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Log.info("allrady sticker download   complete!");

		}
		oneToOneLocater.getSelectKollageFormGallery().click();
		Log.info("click foter sticker buttion!");
		oneToOneLocater.getCaptureLifiImage().click();
		Log.info("click capture lifie image!");
		getWaitForIdPresent("yw.wemet.ngageapp:id/DoodlePlusActivity_llGifCaptureOk",90);
		oneToOneLocater.getClickLifiOKButtion().click();
		Log.info("click lifie page ok buttion!");
		oneToOneLocater.getOkButtionOFLifie().click();
		Log.info("click ok buttion of lifie!");
		oneToOneLocater.getKlipySendingButtion().click();
		Log.info("click sending buttion of klipy");
		oneToOneLocater.getButtionHighQuality().click();
		Log.info("click quality of high redio buttion!");
		oneToOneLocater.getLifieSelectButtion().click();
		Log.info("sending lifie complete!");
	}
	public void getKollage()
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		getWaitForIdPresent("yw.wemet.ngageapp:id/btnOptions",90);
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click AttachmentButtion buttion !");
		oneToOneLocater.getClickKollageButtion().click();
		Log.info("click kollageButtion!");
		oneToOneLocater.getKollageImageFormFooter().click();
		Log.info("click footer panel of kollage image!");
		try
		{
			NgageDriver.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			oneToOneLocater.getDownlodeButtionOFKollage().click();
			Log.info("downlode buttion of kollage witch is navigate gallery!");
			oneToOneLocater.getKollageStickerForGalleryDownlode().click();
			Log.info("click one of kollgae sticker from kollage page!");
			oneToOneLocater.getBackButtion().click();
			Log.info("click backButtion of sticker gallery");
			oneToOneLocater.getKollageImageFormFooter().click();
		}catch(Exception e)
		{
			NgageDriver.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Log.info("allrady sticker download   complete!");

		}
		oneToOneLocater.getKollageSelection().click();
		Log.info("select one of kollage from kollage gallery page! ");
		oneToOneLocater.getKollageImageSendButtion().click();
		Log.info("click send buttion of kollage!");

	}

	public void getGreeting()
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		getWaitForIdPresent("yw.wemet.ngageapp:id/btnOptions",90);
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click option attchemnet!");
		oneToOneLocater.getGreetingButtion().click();
		Log.info("click greeting buttion!");
		oneToOneLocater.getFoodterPanelGreeting().click();
		Log.info("click footer panel greeting and send greeting data.");
		try
		{
			NgageDriver.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			oneToOneLocater.getGreetingDownlodeButtion().click();
			Log.info("currently after click of download buttion it is navigate to gallery page!");
			oneToOneLocater.getDownlode3rdgreeting().click();
			Log.info("complete to click 2nd  greeting of gallery!");
			oneToOneLocater.getBackButtionOFgreeting().click();
			oneToOneLocater.getFoodterPanelGreeting().click();
			Log.info("click greeting form footer panel--");
		}catch(Exception e)
		{
			NgageDriver.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Log.info("allrady sticker download   complete!");
		}
		oneToOneLocater.getGreetingEdditPage().click();
		Log.info("select one of greeting from greeting gallery!");
		oneToOneLocater.getGreetingSendingButtion().click();
		Log.info("click greeting sending buttion!");
	}
	public void getLocation()
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		oneToOneLocater.getAttachmentButtion().click();
		getScroolToText("android.widget.GridView","Face Detector");
		Log.info("click option attchemnet!");
		oneToOneLocater.getLocationButtion().click();
		Log.info("--click location buttion of application--!");
		getWaitForIdPresent("yw.wemet.ngageapp:id/tvDesc",90);
		oneToOneLocater.getCurrentLocation().click();
	}

	public void getOtherLocation()
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click option attchemnet!");
		getScroolToText("android.widget.GridView","Face Detector");
		oneToOneLocater.getLocationButtion().click();
		Log.info("--click location buttion of application--!");
		getWaitForIdPresent("yw.wemet.ngageapp:id/tvDesc",90);
		oneToOneLocater.getClickPreviousLocatios().click();
		Log.info("click Previous  location buttion!");
		oneToOneLocater.getOtherLOcationAdress().click();
		Log.info("click other location adress!");
	}
	public void getVideoNote() throws InterruptedException
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click option attchemnet!");
		oneToOneLocater.getVideoNoteButtion().click();
		Log.info("video note buttion buttion clicked!");
		oneToOneLocater.getVideoRecordingButtion().click();
		Log.info("click video recording buttion!");
		Thread.sleep(5000);
		oneToOneLocater.getVideoRecordingButtion().click();
		Log.info("click video recording buttion!");
		oneToOneLocater.getVideoRecordingSendButtionl().click();
		Log.info("Complete to send video recording !");	
	}
	public void getChatMakeOver()
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		getWaitForIdPresent("yw.wemet.ngageapp:id/btnOptions",90);
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click option attchemnet!");
		getScroolToText("android.widget.GridView","Face Detector");
		getWaitForElementPresent("//android.widget.TextView[@text='Chat Makeover']",90);
		oneToOneLocater.getChatMakeoverButtion().click();
		Log.info("click chat makeOverButtion");
		oneToOneLocater.getFooterPanelThemeSelect().click();
		Log.info("click foter panel of chat theme");
		try
		{
		NgageDriver.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		oneToOneLocater.getDownlodeButtionOfTheme().click();
		Log.info("click downlode of theme select from gallery!");
		oneToOneLocater.getThemeSelectionOf3d().click();
		Log.info("click 3rd number of greeting!");
		oneToOneLocater.getBackButtionOFgreeting().click();
		Log.info("click back buttion of greeting!");
		
		}catch(Exception e)
		{
			NgageDriver.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			Log.info("allrady downlode theme complete!");
		}
		getWaitForElementPresent("//android.widget.ImageView[1]",90);
		oneToOneLocater.getThemeSelect().click();
		Log.info("click select of theme from theme gallery!");
		String message=oneToOneLocater.getThemeChnageMessageValidation().getText();
		Log.info("message:"+message);
	}
	public void getDeviceGallery()
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click option attchemnet!");
		oneToOneLocater.getDeviceGallery().click();
		Log.info("click deviceGallery buttion");
		
		//TOODO....
	}
	public void getShareContact()
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		getWaitForIdPresent("yw.wemet.ngageapp:id/btnOptions",90);
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click option attchemnet!");
		getScroolToText("android.widget.GridView","Face Detector");
		oneToOneLocater.getShareContactButtion().click();
		Log.info("click sharing contact buttion!");
		getWaitForElementPresent("//android.view.View[@index='4']",90);
		oneToOneLocater.getClickConactFromConactList().click();
		Log.info("select one of conact from conact list!");
		getWaitForIdPresent("yw.wemet.ngageapp:id/send_contact_send",90);
		oneToOneLocater.getClickSendButtionOfConact().click();
		Log.info("click send buttion of sharing contact!");
		
	}
	public void getSendCamera()
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		getWaitForIdPresent("yw.wemet.ngageapp:id/btnOptions",90);
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click attchment buttion!");
		getScroolToText("android.widget.GridView","Face Detector");
		oneToOneLocater.getClickCameraButtion().click();
		Log.info("click camera buttion of n-gage---!");
		oneToOneLocater.getCaptureImageButtion().click();
		Log.info("take image useing capture image buttion!");
		getWaitForIdPresent("yw.wemet.ngageapp:id/DoodlePlusActivity_llSendMenu",90);
		oneToOneLocater.getSendingButtionOFCaptureImage().click();
		Log.info("click sending buttion of capture image!");
	}
	
	public void getsendTextTamplet()
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click attchment buttion!");
		getScroolToText("android.widget.GridView","Face Detector");
		oneToOneLocater.getClickTextTempled().click();
		getWaitForIdPresent("yw.wemet.ngageapp:id/RowTextTemplate_llSend",90);
		oneToOneLocater.getSendingButtionTemplate().click();
		Log.info("click sending buttion of template!");
	}
	public void  getSendFaceDetector()
	{
		oneToOneLocater =loadObject(new OneToOneLocater());
		oneToOneLocater.getAttachmentButtion().click();
		Log.info("click attchment buttion!");
		getScroolToText("android.widget.GridView","Face Detector");
		oneToOneLocater.getClickFaceDetector().click();
		Log.info("click faceDetector button!");
		oneToOneLocater.getCaptureImageButtion().click();
		Log.info("click capture image!");
		getWaitForIdPresent("yw.wemet.ngageapp:id/DoodlePlusActivity_llSendMenu", 90);
		oneToOneLocater.getSendingButtionOFCaptureImage().click();
		Log.info("click sending buttion of template!");
	}
	
}
