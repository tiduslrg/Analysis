package cn.tianrui.caculation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TianruiTimer {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd" + " " + "hh:mm:ss");
	private static SimpleDateFormat siteMapFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat birthdayFormat = new SimpleDateFormat("MM-dd");

	public static String currentTime() {
		return dateFormat.format(new java.util.Date());
	}

	public static String siteMapTime() {
		return siteMapFormat.format(new java.util.Date());
	}

	public static String birthdayTime() {
		return birthdayFormat.format(new java.util.Date());
	}

	public synchronized static String publishDate(String year) {
		return year + "-" + getRandomMonth() + "-" + getRandomDay();
	}

	private static String getRandomMonth() {
		String month = new Integer((int) (1 + Math.random() * 11)).toString();
		if (month.length() < 2) {
			return "0" + month;
		}
		return month;
	}

	private static String getRandomDay() {
		String day = new Integer((int) (1 + Math.random() * 27)).toString();
		if (day.length() < 2) {
			return "0" + day;
		}
		return day;
	}

	public static void setTimeZone() {
		// set time zone
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
	}

	private long timeStart;

	public String usedTime() {
		long TimeUsed = (System.currentTimeMillis() - timeStart) / 1000;
		return TimeUsed / 86400 + "D-" + (TimeUsed / 3600) % 24 + "H-" + (TimeUsed % 3600) / 60 + "M";
	}

	public void setTimeStart(long timeStart) {
		this.timeStart = timeStart;
	}

	// TODO update time

	private static SimpleDateFormat updateTimeShow = new SimpleDateFormat("MM月dd日HH时");
	private static SimpleDateFormat updateTimeSerial = new SimpleDateFormat("MM月dd日");
	private static SimpleDateFormat updateHourLimt = new SimpleDateFormat("HH");
	int i = 0;
	long updateIime;
	Integer hour;

	// TODO HD movie filter

	public static synchronized boolean isNeedFilter(String date) {
		Date publishDate = new Date(System.currentTimeMillis());
		try {
			publishDate = siteMapFormat.parse(date);
		} catch (ParseException e) {
		}
		if ((System.currentTimeMillis() - publishDate.getTime()) / (24 * 3600000) > 60) {
			return true;
		}
		return false;
	}
}
