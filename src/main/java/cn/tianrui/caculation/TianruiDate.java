package cn.tianrui.caculation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TianruiDate {
	private static Logger logger = LogManager.getLogger(TianruiDate.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private Calendar neededCalendar = Calendar.getInstance();

	public TianruiDate(String yyyyMMdd) {
		try {
			Date date = sdf.parse(yyyyMMdd);
			neededCalendar.setTime(date);
		} catch (Exception e) {
			logger.debug(yyyyMMdd, e);
		}
	}

	public Date IncreaseDays(Integer days) {
		try {
			neededCalendar.add(Calendar.DAY_OF_YEAR, days);
			return this.getCurrentDate();
		} catch (Exception e) {
			logger.debug(new Exception().getStackTrace()[0].getMethodName(), e);
		}
		return null;
	}

	public Date DecreaseDays(Integer days) {
		try {
			neededCalendar.add(Calendar.DAY_OF_YEAR, -days);
			return this.getCurrentDate();
		} catch (Exception e) {
			logger.debug(new Exception().getStackTrace()[0].getMethodName(), e);
		}
		return null;
	}

	public String ShortDate(String date) {
		return date.toString().substring(2, 8);
	}

	public String getShortCurrentDate() {
		try {
			return this.ShortDate(sdf.format(neededCalendar.getTime()));
		} catch (Exception e) {
			logger.debug(new Exception().getStackTrace()[0].getMethodName(), e);
		}
		return null;
	}

	public Date getCurrentDate() {
		try {
			return sdf.parse(sdf.format(neededCalendar.getTime()));
		} catch (Exception e) {
			logger.debug(new Exception().getStackTrace()[0].getMethodName(), e);
		}
		return null;
	}

	public String getCurrentDateFormatted() {
		return sdf.format(neededCalendar.getTime());
	}

	
}
