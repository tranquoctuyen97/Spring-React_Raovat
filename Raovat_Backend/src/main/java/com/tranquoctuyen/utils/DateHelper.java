package com.tranquoctuyen.utils;

import java.sql.Timestamp;

import java.util.Date;

public class DateHelper {

	public static Timestamp convertDatetoTimestmp(Date date) {
		Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		return timestamp;
	}
	public static Date convertTimestmptoTime(Timestamp timestamp) {
		Date date = new Date(timestamp.getTime());
		return date;
	}


}
