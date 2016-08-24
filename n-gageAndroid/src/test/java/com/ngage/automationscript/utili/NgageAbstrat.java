package com.ngage.automationscript.utili;

import org.openqa.selenium.support.PageFactory;

public class NgageAbstrat {
	@SuppressWarnings("unchecked")
	public <T> T loadObject(T t)
	{
		return (T) PageFactory.initElements(NgageDriver.driver, t.getClass());
	}
}
