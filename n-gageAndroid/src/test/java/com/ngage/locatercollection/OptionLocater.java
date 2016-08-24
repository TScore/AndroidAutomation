package com.ngage.locatercollection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OptionLocater {
@FindBy(id="yw.wemet.ngageapp:id/btn7")
private WebElement optionButtion;

@FindBy(id="yw.wemet.ngageapp:id/btn2RightArrow")
private WebElement profile;

@FindBy(id="yw.wemet.ngageapp:id/txtusername")
private WebElement profileName;

@FindBy(id="yw.wemet.ngageapp:id/textphone_1")
private WebElement profileNumber;

@FindBy(id="yw.wemet.ngageapp:id/imgback")
private WebElement profileBackButtion;

public WebElement getProfileNumber() {
	return profileNumber;
}

public WebElement getOptionButtion() {
	return optionButtion;
}

public WebElement getProfile() {
	return profile;
}

public WebElement getProfileName() {
	return profileName;
}

public WebElement getProfileBackButtion() {
	return profileBackButtion;
}


}
