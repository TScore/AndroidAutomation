package com.ngage.locatercollection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class RegistrationLocater {
	//n-gage terms of services link
	@FindBy(id="yw.wemet.ngageapp:id/tvTermsConditions1")
	private WebElement termOfService;
	//Term and condition close button
	@FindBy(id="yw.wemet.ngageapp:id/btnClose")
	private WebElement closeButtion;
	@FindBy(id="yw.wemet.ngageapp:id/tvPrivacypolicy")
	private WebElement privacyPolicy;
	@FindBy(id="yw.wemet.ngageapp:id/tvAcceptableFairUsePolicy")
	private WebElement acceptableFairUsePolicy;
	@FindBy(id="yw.wemet.ngageapp:id/tvCookiesPolicy")
	private WebElement cookiesPolicy;
	
	public WebElement getTermOfService() 
	{
		return termOfService;
	}
	public void setTermOfService(WebElement termOfService) {
		this.termOfService = termOfService;
	}
	public WebElement getCloseButtion() {
		return closeButtion;
	}
	public WebElement getPrivacyPolicy() {
		return privacyPolicy;
	}
	public WebElement getAcceptableFairUsePolicy() {
		return acceptableFairUsePolicy;
	}
	public WebElement getCookiesPolicy() {
		return cookiesPolicy;
	}
	//N-gage agree and continue button .
	@FindBy(id="yw.wemet.ngageapp:id/button_clearconversation_ok")
	private WebElement agreeContinueButton;
	public WebElement getAgreeContinueButton() {
		return agreeContinueButton;
	}
	@FindBy(xpath="//android.widget.LinearLayout[1]/android.widget.TextView[1]")
	private WebElement exceptedLocater;
	public WebElement getExceptedLocater() {
		return exceptedLocater;
	}
	//n-gage register page locater
	@FindBy(id="edtFirtsName")
	private WebElement inputName;
	@FindBy(id="yw.wemet.ngageapp:id/spinnerTarget")
	private WebElement countryLabel;
	@FindBy(id="yw.wemet.ngageapp:id/edtMobile")
	private WebElement mobileNumber;
	@FindBy(id="yw.wemet.ngageapp:id/btnContinue")
	private WebElement nextButtion;
	
	//n-gage verify page
	@FindBy(id="yw.wemet.ngageapp:id/edtVerificationCode")
	private WebElement VerificationCode;
	@FindBy(id="yw.wemet.ngageapp:id/btnFinish")
	private WebElement btnFinish;
	//n-gage email page
	@FindBy(id="yw.wemet.ngageapp:id/btnskip")
	private WebElement skipButtion;
	
	public WebElement getInputName() {
		return inputName;
	}
	public WebElement getCountryLabel() {
		return countryLabel;
	}
	public WebElement getMobileNumber() {
		return mobileNumber;
	}
	public WebElement getNextButtion() {
		return nextButtion;
	}
	public WebElement getVerificationCode() {
		return VerificationCode;
	}
	public WebElement getBtnFinish() {
		return btnFinish;
	}
	public WebElement getSkipButtion() {
		return skipButtion;
	}
	//verify page locater
	@FindBy(id="yw.wemet.ngageapp:id/tvSendNO")
	private WebElement verifyNumberText;
	
	@FindBy(id="yw.wemet.ngageapp:id/tvtap")
	private WebElement numberChangeLink;

	public WebElement getVerifyNumberText() {
		return verifyNumberText;
	}
	public WebElement getNumberChangeLink() {
		return numberChangeLink;
	}
	
	//n-gage "number change pop up !"
	@FindBy(id="yw.wemet.ngageapp:id/spinnerTarget")
	private WebElement countrySelectionButtion;
	@FindBy(id="yw.wemet.ngageapp:id/edtMobile")
	private WebElement mobileNumberChnage;
	@FindBy(id="yw.wemet.ngageapp:id/edtConfirmMobile")
	private WebElement conformMobileNoChnage;
	@FindBy(id="yw.wemet.ngageapp:id/btnCancel")
	private WebElement cancelButtion;
	@FindBy(id="yw.wemet.ngageapp:id/llfotterSend")
	private WebElement sendButtion;
	@FindBy(id="yw.wemet.ngageapp:id/btnResendCode")
	private WebElement resentButtion;
	//n-gage otp code send to mobile alert.
	@FindBy(id="yw.wemet.ngageapp:id/subHeader")
	private WebElement alertMessage;
	
	
	@FindBy(id="yw.wemet.ngageapp:id/rrfooterlayout")
	private WebElement alrtClose;
	public WebElement getCountrySelectionButtion() {
		return countrySelectionButtion;
	}
	public WebElement getMobileNumberChnage() {
		return mobileNumberChnage;
	}
	public WebElement getConformMobileNoChnage() {
		return conformMobileNoChnage;
	}
	public WebElement getCancelButtion() {
		return cancelButtion;
	}
	public WebElement getSendButtion() {
		return sendButtion;
	}
	public WebElement getResentButtion() {
		return resentButtion;
	}
	public WebElement getAlertMessage() {
		return alertMessage;
	}
	public WebElement getAlrtClose() {
		return alrtClose;
	}
	
	@FindBy(id="yw.wemet.ngageapp:id/edtVerificationCode")
	private WebElement emailEddit;
	public WebElement getEmailEddit() {
		return emailEddit;
	}
	
	@FindBy(id="yw.wemet.ngageapp:id/btnFinish")
	private WebElement registerButtion;
	public WebElement getRegisterButtion() {
		return registerButtion;
	}
	
	
	
	
}
