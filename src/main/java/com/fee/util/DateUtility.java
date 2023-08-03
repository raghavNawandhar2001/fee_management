package com.fee.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class DateUtility {
	static Logger logger = LogManager.getLogger(DateUtility .class);
	public static LocalDate localDateFormate(String date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM, yyyy");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate local_Date = null;
		String fromDate = null;
		LocalDate targetDate = null;
		try {
			local_Date = LocalDate.parse(date, formatter);
		} catch (Exception e) {
		}
		try {
			fromDate = local_Date.format(formatter1);
			targetDate = LocalDate.parse(fromDate, formatter1);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error in " + e.getMessage());
		}
		return targetDate;
	}

	public static String changeDateTimeToDate(String txnDatetime) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String date = "";
		try {
			SimpleDateFormat formt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date dateT = formt.parse(txnDatetime);
			date = format.format(dateT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static int getNoOfDay(String fromDate, String toDate) {
		try {
			String dateNow = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
			java.util.Date localFromDate = getStringDate(fromDate);
			java.util.Date localToDate = getStringDate(toDate);

			SimpleDateFormat selectedMonthFor = new SimpleDateFormat("MM");
			SimpleDateFormat selectedYear = new SimpleDateFormat("yyyy");

			String selectMonth = selectedMonthFor.format(localToDate);
			String selectYear = selectedYear.format(localToDate);
			logger.info("Current Date ==> " + dateNow + "selectYear ==> " + selectYear);

			int month;
			int year;
			GregorianCalendar date1 = new GregorianCalendar();
			month = date1.get(Calendar.MONTH);
			month = month + 1;
			year = date1.get(Calendar.YEAR);
			logger.info("Current month is  " + month);
			logger.info("Selected year ==> " + selectYear + " current yaer ==> " + year);

			if (Integer.valueOf(selectMonth) <= month && (Integer.valueOf(selectYear) == year)) {
				logger.info("selectMonth ==> " + selectMonth + "month ==> " + month);
				Period period = getPeriod(LocalDateTime.ofInstant(localFromDate.toInstant(), ZoneId.systemDefault()),
						LocalDateTime.ofInstant(localToDate.toInstant(), ZoneId.systemDefault()));

				logger.info("No of days ==> " + period.getDays());
				return period.getDays();
			}
		} catch (Exception e) {
			logger.info("Error in noOfDay against fromDate ==> " + fromDate + " To Date ==> " + toDate
					+ " Error ==> " + e.getMessage());
		}
		return 0;
	}

	private static java.util.Date getStringDate(String fromDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			java.util.Date date = dateFormat.parse(fromDate);
			return date;
		} catch (Exception e) {
			logger.info("Date  format not matched !!" + e.getMessage());
		}
		return null;
	}

	private static Period getPeriod(LocalDateTime dob, LocalDateTime now) {
		return Period.between(dob.toLocalDate(), now.toLocalDate());
	}

	public static java.util.Date getFromDateFromLocalDate(LocalDate localDate) {
		try {
			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			Calendar cal = new GregorianCalendar();
			cal.setTime(date);

			cal.set(Calendar.HOUR,0);
			cal.set(Calendar.MINUTE,0);
			cal.set(Calendar.SECOND,0);
			return cal.getTime();
		} catch (Exception e) {
			logger.info("Date  format not matched !!" + e.getMessage());
		}
		return null;
	}

	public static java.util.Date getToDateFromLocalDate(LocalDate localDate) {
		try {
			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			Calendar cal = new GregorianCalendar();
			cal.setTime(date);

			cal.set(Calendar.HOUR,23);
			cal.set(Calendar.MINUTE,59);
			cal.set(Calendar.SECOND,59);
			return cal.getTime();
		} catch (Exception e) {
			logger.info("Date  format not matched !!" + e.getMessage());
		}
		return null;
	}
}
