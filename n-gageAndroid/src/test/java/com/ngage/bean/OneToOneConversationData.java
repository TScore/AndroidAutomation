package com.ngage.bean;

public class OneToOneConversationData {
	private String contactNumber;
	private int  MessageSendingNumber;
	private String MessageText;
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getMessageSendingNumber() {
		return MessageSendingNumber;
	}
	public void setMessageSendingNumber(int messageSendingNumber) {
		MessageSendingNumber = messageSendingNumber;
	}
	public String getMessageText() {
		return MessageText;
	}
	public void setMessageText(String messageText) {
		MessageText = messageText;
	}

	

}
