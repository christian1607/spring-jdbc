package pvt.auna.solben.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;

public class DateUtils {

	private static final Logger LOGGER = Logger.getLogger(DateUtils.class);

	public static String getDateToStringDDMMYYYY(Date dateToString) {
		SimpleDateFormat formatDate = new SimpleDateFormat(ConstanteUtil.FORMATO_FECHA_DD_MM_YYYY);
		String dateString = null;
		
		try {
			if(dateToString != null) {
				dateString = formatDate.format(dateToString); 
			}
		} catch (Exception e) {
			LOGGER.error("dateToString is null!", e);
			dateString = null;
		}
		return dateString;
	}
	
	public static String getDateToStringDDMMYYYHHMMSS(Date date) {
		SimpleDateFormat formatDate = new SimpleDateFormat(ConstanteUtil.FORMATO_FECHA_dd_MM_yyyy_HH_mm_ss);
		String dateString = null;
		
		try {
			if(date != null) {
				dateString = formatDate.format(date); 
			}
		} catch (Exception e) {
			LOGGER.error("dateToString is null!", e);
			dateString = null;
		}
		
		return dateString;
	}
	
	public static Date getStringToDateDDMMYYYY(String dateString) {
		SimpleDateFormat formatDate = new SimpleDateFormat(ConstanteUtil.FORMATO_FECHA_DD_MM_YYYY);
		Date date = null;
		
		try {
			if (dateString != null) {
				date = formatDate.parse(dateString);			
			}
		} catch (Exception e) {
			LOGGER.error("dateString is null!", e);
			date = null;
		}
		return date;
	}

	public static String getDateToStringHHMMSS(Date date) {
		SimpleDateFormat formatDate = new SimpleDateFormat(ConstanteUtil.FORMATO_FECHA_HH_mm_ss);
		String dateString = null;
		
		try {
			if(date != null) {
				dateString = formatDate.format(date); 
			}
		} catch (Exception e) {
			LOGGER.error("dateToString is null!", e);
			dateString = null;
		}
		
		return dateString;
	}

}
