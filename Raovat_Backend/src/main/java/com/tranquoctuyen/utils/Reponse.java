package com.tranquoctuyen.utils;

public class Reponse {
	private boolean success;
	private String notification;
	public Reponse() {
		super();
	}
	public Reponse(boolean success, String notification) {
		super();
		this.success = success;
		this.notification = notification;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public static Reponse returnError(String notification) {
		Reponse reponse = new Reponse(false, notification);
		return reponse;
	}
	public static Reponse returnSuccess(String notification) {
		Reponse reponse = new Reponse(true, notification);
		return reponse;
	}
}
