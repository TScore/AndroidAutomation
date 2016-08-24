package com.ngage.locatercollection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OneToOneLocater {
	@FindBy(id="yw.wemet.ngageapp:id/lay44")
	private WebElement chatButton;
	@FindBy(id="yw.wemet.ngageapp:id/tvCreateNew")
	private WebElement stratNewConversation;
	@FindBy(id="yw.wemet.ngageapp:id/imvAppTheme")
	private WebElement sharingManu;
	@FindBy(id="yw.wemet.ngageapp:id/grid_image")
	private WebElement backButtionSharingManu;
	@FindBy(id="yw.wemet.ngageapp:id/NewOneToOneActivity_etSearchFriends")
	private WebElement newOneToOneSearchBox;
	@FindBy(id="yw.wemet.ngageapp:id/tvName")
	private WebElement searchListName;

	@FindBy(id="yw.wemet.ngageapp:id/moretext")
	private WebElement moreButtionformSelect;

	@FindBy(id="yw.wemet.ngageapp:id/textView_longClick")
	private WebElement viewProfile;

	@FindBy(id="yw.wemet.ngageapp:id/text")
	private WebElement textEditBox;

	@FindBy(id="yw.wemet.ngageapp:id/btnSend")
	private WebElement sendButtion;

	@FindBy(id="yw.wemet.ngageapp:id/btnAudio")
	private WebElement audioButtion;

	@FindBy(id="yw.wemet.ngageapp:id/btnStickers")
	private WebElement buttionSticker;


	//-------------sticker locater-----------------
	@FindBy(xpath="//android.widget.ImageView[2]")
	private WebElement stickerSelect;

	
	@FindBy(id="yw.wemet.ngageapp:id/download_more_Decoration_yes")
	private WebElement stickerDownlodeButtion;

	@FindBy(id="yw.wemet.ngageapp:id/tvdownload_all")
	private WebElement downlodeAllFreeSticker;


	@FindBy(id="yw.wemet.ngageapp:id/imvBack")
	private WebElement backButtion;

	@FindBy(xpath="//android.widget.RelativeLayout[1]/android.widget.ImageView[1]")
	private WebElement stickerSend;
	
	@FindBy(id="yw.wemet.ngageapp:id/SteekerGreeting_tvUserSelectionSend")
	private WebElement stickerSendingButtion;
	
	//-------------------------------------doodle image---------------------------------------------
	
	@FindBy(id="yw.wemet.ngageapp:id/btnSend")
	private WebElement doodeButtion;
	
	
	@FindBy(id="yw.wemet.ngageapp:id/DoodlePlusActivity_llSendMenu")
	private WebElement doodleImagesendingButtion;
	
	
	@FindBy(id="yw.wemet.ngageapp:id/DoodlePlusActivity_llBackgroundcolor")
	private WebElement doodleDecorate;
	
	@FindBy(xpath="//android.widget.LinearLayout[3]")
	private WebElement doodleCollerDecorate;
	//-------------------------------------- Attachment  button------------------------------------------------
	
	@FindBy(id="yw.wemet.ngageapp:id/btnOptions")
	private WebElement attachmentButtion;
	
	@FindBy(xpath="//android.widget.LinearLayout[2]")
	private WebElement fileAttachmentButtion;
	
	@FindBy(xpath="//android.widget.RelativeLayout[6]")
	private WebElement selectFolder;
	
	@FindBy(xpath="//android.widget.RelativeLayout[4]")
	private WebElement fileSelection;
	
	
	@FindBy(id="yw.wemet.ngageapp:id/tvMessage")
	private WebElement fileName;
	
	
	//------------------------------------------------life button-----------------------------------------------
	@FindBy(xpath="//android.widget.TextView[@text='Lifie']")
	private WebElement lifieButtion;
	@FindBy(id="yw.wemet.ngageapp:id/capture_camera")
	private WebElement captureImage;
	@FindBy(id="yw.wemet.ngageapp:id/DoodlePlusActivity_llSendMenu")
	private WebElement lifieSendButtion;
	//-----------------------------------------------Klipy testing-----------------------------------------------
	@FindBy(xpath="//android.widget.TextView[@text='Klipy']")
	private WebElement klipyButtion;
	@FindBy(xpath="//android.widget.ImageView[2]")
	private WebElement selectKlipyFromFooterPanel;
	@FindBy(xpath="//android.widget.LinearLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
	private WebElement lifieDownlode;
	@FindBy(id="yw.wemet.ngageapp:id/DoodlePlusActivity_llGifCapture")
	private WebElement captureLifiImage;
	@FindBy(id="yw.wemet.ngageapp:id/DoodlePlusActivity_llGifCaptureOk")
	private WebElement clickLifiOKButtion;
	@FindBy(id="yw.wemet.ngageapp:id/DoodlePlusActivity_llGifSpeedOk")
	private WebElement okButtionOFLifie;
	
	public WebElement getOkButtionOFLifie() {
		return okButtionOFLifie;
	}
	@FindBy(id="yw.wemet.ngageapp:id/DoodlePlusActivity_llSendMenu")
	private WebElement klipySendingButtion;
	@FindBy(id="yw.wemet.ngageapp:id/radioButton1")
	private WebElement buttionHighQuality;
	@FindBy(id="yw.wemet.ngageapp:id/llfotterSend")
	private WebElement lifieSelectButtion;
	
	//------------------------------------------------kollage testing---------------------------------
	
	@FindBy(xpath="//android.widget.TextView[@text='Kollage']")
	private WebElement clickKollageButtion;
	@FindBy(xpath="//android.widget.ImageView[2]")
	private WebElement kollageImageFormFooter;
	@FindBy(xpath="//android.widget.RelativeLayout[1]/android.widget.ImageView[1]")
	private WebElement selectKollageFormGallery;
	@FindBy(id="yw.wemet.ngageapp:id/ll_download_more_Decoration")
	private WebElement downlodeButtionOFKollage;
	@FindBy(xpath="//android.widget.LinearLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
	private WebElement KollageStickerForGalleryDownlode;
	@FindBy(xpath="//android.widget.ImageView[1]")
	private WebElement kollageSelection; 
	@FindBy(id="yw.wemet.ngageapp:id/DoodlePlusActivity_llSendMenu")
	private WebElement kollageImageSendButtion;
	
	//--------------------------------------------------greeting module--------------------------------------
	@FindBy(xpath="//android.widget.TextView[@text='n-Cards']")
	private WebElement greetingButtion;
	@FindBy(xpath="//android.widget.ImageView[2]")
	private WebElement foodterPanelGreeting;
	@FindBy(id="yw.wemet.ngageapp:id/ll_download_more_Decoration")
	private WebElement greetingDownlodeButtion;
	@FindBy(xpath="//android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
	private WebElement downlode3rdgreeting;
	@FindBy(id="yw.wemet.ngageapp:id/imvBack")
	private WebElement backButtionOFgreeting;
	@FindBy(xpath="//android.widget.ImageView[1]")
	private WebElement greetingEdditPage;
	@FindBy(id="yw.wemet.ngageapp:id/SteekerGreeting_tvUserSelectionSend")
	private WebElement greetingSendingButtion;
	
	//----------------------------------------------current location sharing------------------------------------
	@FindBy(xpath="//android.widget.TextView[@text='Current Location']")
	private WebElement locationButtion; 
	@FindBy(xpath="//android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
	private WebElement currentLocation;
	
	//-------------------------------------other location sharing adress---------------------
	@FindBy(xpath="//android.widget.TextView[@text='Current Location']")
	private WebElement otherLOcation;
	@FindBy(xpath="//android.widget.LinearLayout[2]")
	private WebElement clickPreviousLocatios;
	@FindBy(xpath="//android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
	private WebElement otherLOcationAdress;
	//--------------------------------------video recording button-----------------------
	@FindBy(xpath="//android.widget.TextView[@text='Video Note']")
	private WebElement videoNoteButtion;
	@FindBy(id="yw.wemet.ngageapp:id/video_camera")
	private WebElement videoRecordingButtion;
	@FindBy(id="yw.wemet.ngageapp:id/ok_btn")
	private WebElement videoRecordingSendButtionl;
	//-----------------------------------------chat makeOver----------------------------------------------
	@FindBy(xpath="//android.widget.TextView[@text='Chat Makeover']")
	private WebElement chatMakeoverButtion;
	@FindBy(xpath="//android.widget.ImageView[2]")
	private WebElement footerPanelThemeSelect;
	@FindBy(id="yw.wemet.ngageapp:id/ll_download_more_Decoration")
	private WebElement downlodeButtionOfTheme;
	@FindBy(xpath="//android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
	private WebElement themeSelectionOf3d;
	@FindBy(xpath="//android.widget.ImageView[1]")
	private WebElement themeSelect;
	@FindBy(id="yw.wemet.ngageapp:id/tvMessage")
	private WebElement themeChnageMessageValidation;
	//--------------------------------------------------device gallery------------------------------------------
	@FindBy(xpath="//android.widget.LinearLayout[8]")
	private WebElement deviceGallery;
	
	
	//---------------------------------------------------click share contact-----------------------------------
	@FindBy(xpath="//android.widget.TextView[@text='Share Contact']")
	private WebElement shareContactButtion;
	@FindBy(xpath="//android.view.View[@index='4']")
	private WebElement clickConactFromConactList;
	@FindBy(id="yw.wemet.ngageapp:id/send_contact_send")
	private WebElement clickSendButtionOfConact;
	//-------------------------------------------------camera button----------------
	@FindBy(xpath="//android.widget.TextView[@text='Camera']")
	private WebElement clickCameraButtion;
	@FindBy(id="yw.wemet.ngageapp:id/capture_camera")
	private WebElement captureImageButtion;
	@FindBy(id="yw.wemet.ngageapp:id/DoodlePlusActivity_llSendMenu")
	private WebElement sendingButtionOFCaptureImage;
	//-------------------------------------------send text templed button.---------
	@FindBy(xpath="//android.widget.TextView[@text='Text']")
	private WebElement clickTextTempled;
	@FindBy(id="yw.wemet.ngageapp:id/RowTextTemplate_llSend")
	private WebElement sendingButtionTemplate;
	//----------------------------------------------faceDetector--------------------------------------
	@FindBy(xpath="//android.widget.TextView[@text='Face Detector']")
	private WebElement clickFaceDetector;
	//-----------------------------------------------exist pop up-------------------------------------
	@FindBy(id="yw.wemet.ngageapp:id/llfotterSend")
	private WebElement existButtion;
	
	public WebElement getClickCameraButtion() {
		return clickCameraButtion;
	}
	public WebElement getClickSendButtionOfConact() {
		return clickSendButtionOfConact;
	}
	public WebElement getShareContactButtion() {
		return shareContactButtion;
	}
	public WebElement getDeviceGallery() {
		return deviceGallery;
	}
	public WebElement getFooterPanelThemeSelect() {
		return footerPanelThemeSelect;
	}
	public WebElement getChatMakeoverButtion() {
		return chatMakeoverButtion;
	}
	public WebElement getClickLifiOKButtion() {
		return clickLifiOKButtion;
	}
	public WebElement getChatButton() {
		return chatButton;
	}
	public WebElement getStratNewConversation() {
		return stratNewConversation;
	}
	public WebElement getSharingManu() {
		return sharingManu;
	}
	public WebElement getBackButtionSharingManu() {
		return backButtionSharingManu;
	}
	public WebElement getNewOneToOneSearchBox() {
		return newOneToOneSearchBox;
	}
	public WebElement getSearchListName() {
		return searchListName;
	}
	public WebElement getMoreButtionformSelect() {
		return moreButtionformSelect;
	}
	public WebElement getViewProfile() {
		return viewProfile;
	}
	public WebElement getTextEditBox() {
		return textEditBox;
	}
	public WebElement getSendButtion() {
		return sendButtion;
	}
	public WebElement getAudioButtion() {
		return audioButtion;
	}
	public WebElement getButtionSticker() {
		return buttionSticker;
	}
	public WebElement getStickerSelect() {
		return stickerSelect;
	}
	public WebElement getStickerDownlodeButtion() {
		return stickerDownlodeButtion;
	}
	public WebElement getDownlodeAllFreeSticker() {
		return downlodeAllFreeSticker;
	}
	public WebElement getBackButtion() {
		return backButtion;
	}
	public WebElement getStickerSend() {
		return stickerSend;
	}
	public WebElement getStickerSendingButtion() {
		return stickerSendingButtion;
	}
	public WebElement getDoodeButtion() {
		return doodeButtion;
	}
	public WebElement getDoodleImagesendingButtion() {
		return doodleImagesendingButtion;
	}
	public WebElement getDoodleDecorate() {
		return doodleDecorate;
	}
	public WebElement getDoodleCollerDecorate() {
		return doodleCollerDecorate;
	}
	public WebElement getAttachmentButtion() {
		return attachmentButtion;
	}
	public WebElement getFileAttachmentButtion() {
		return fileAttachmentButtion;
	}
	public WebElement getSelectFolder() {
		return selectFolder;
	}
	public WebElement getFileSelection() {
		return fileSelection;
	}
	public WebElement getFileName() {
		return fileName;
	}
	public WebElement getLifieButtion() {
		return lifieButtion;
	}
	public WebElement getCaptureImage() {
		return captureImage;
	}
	public WebElement getLifieSendButtion() {
		return lifieSendButtion;
	}
	public WebElement getKlipyButtion() {
		return klipyButtion;
	}
	public WebElement getSelectKlipyFromFooterPanel() {
		return selectKlipyFromFooterPanel;
	}
	public WebElement getLifieDownlode() {
		return lifieDownlode;
	}
	public WebElement getCaptureLifiImage() {
		return captureLifiImage;
	}
	public WebElement getKlipySendingButtion() {
		return klipySendingButtion;
	}
	public WebElement getButtionHighQuality() {
		return buttionHighQuality;
	}
	public WebElement getLifieSelectButtion() {
		return lifieSelectButtion;
	}
	public WebElement getClickKollageButtion() {
		return clickKollageButtion;
	}
	public WebElement getKollageImageFormFooter() {
		return kollageImageFormFooter;
	}
	public WebElement getDownlodeButtionOFKollage() {
		return downlodeButtionOFKollage;
	}
	public WebElement getKollageStickerForGalleryDownlode() {
		return KollageStickerForGalleryDownlode;
	}
	public WebElement getKollageSelection() {
		return kollageSelection;
	}
	public WebElement getKollageImageSendButtion() {
		return kollageImageSendButtion;
	}
	public WebElement getGreetingButtion() {
		return greetingButtion;
	}
	public WebElement getFoodterPanelGreeting() {
		return foodterPanelGreeting;
	}
	public WebElement getGreetingDownlodeButtion() {
		return greetingDownlodeButtion;
	}
	public WebElement getDownlode3rdgreeting() {
		return downlode3rdgreeting;
	}
	public WebElement getBackButtionOFgreeting() {
		return backButtionOFgreeting;
	}
	public WebElement getGreetingEdditPage() {
		return greetingEdditPage;
	}
	public WebElement getGreetingSendingButtion() {
		return greetingSendingButtion;
	}
	public WebElement getLocationButtion() {
		return locationButtion;
	}
	public WebElement getSelectKollageFormGallery() {
		return selectKollageFormGallery;
	}
	public WebElement getCurrentLocation() {
		return currentLocation;
	}
	public WebElement getOtherLOcation() {
		return otherLOcation;
	}
	public WebElement getOtherLOcationAdress() {
		return otherLOcationAdress;
	}
	public WebElement getVideoNoteButtion() {
		return videoNoteButtion;
	}
	public WebElement getVideoRecordingButtion() {
		return videoRecordingButtion;
	}
	public WebElement getVideoRecordingSendButtionl() {
		return videoRecordingSendButtionl;
	}
	public WebElement getDownlodeButtionOfTheme() {
		return downlodeButtionOfTheme;
	}
	public WebElement getThemeSelectionOf3d() {
		return themeSelectionOf3d;
	}
	public WebElement getThemeSelect() {
		return themeSelect;
	}
	public WebElement getThemeChnageMessageValidation() {
		return themeChnageMessageValidation;
	}
	public WebElement getClickConactFromConactList() {
		return clickConactFromConactList;
	}
	public WebElement getCaptureImageButtion() {
		return captureImageButtion;
	}
	public WebElement getSendingButtionOFCaptureImage() {
		return sendingButtionOFCaptureImage;
	}
	public WebElement getClickTextTempled() {
		return clickTextTempled;
	}
	public WebElement getSendingButtionTemplate() {
		return sendingButtionTemplate;
	}
	public WebElement getClickFaceDetector() {
		return clickFaceDetector;
	}
	public WebElement getClickPreviousLocatios() {
		return clickPreviousLocatios;
	}
	public WebElement getExistButtion() {
		return existButtion;
	}
	
}
