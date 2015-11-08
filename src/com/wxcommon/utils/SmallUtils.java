package com.wxcommon.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmallUtils {
	private static Date date = new Date();

	public static String getDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMddHHmm");
		return simpleDateFormat.format(date);
	}
	
	public static String getSendDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
		return simpleDateFormat.format(date);
	}
	
	public static String getHour() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
		return simpleDateFormat.format(date);
	}
}
