package com.crm.test.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	   * 获取现在时间
	   * 
	   * @return返回字符串格式 yyyyMMdd
	   */
	public static String getStringDate() {
	   Date currentTime = new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	   String dateString = formatter.format(currentTime);
	   return dateString;
	}
	public static String checkDate(String fromDate) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		String destDate = fromDate;
		try {
			if (fromDate != null && !fromDate.equals("")) {
				if (fromDate.split("/").length > 1) {
					DateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
					date = sdf1.parse(fromDate);
					destDate = dateFormat.format(date);
				} else if (fromDate.split("-").length > 1) {
					DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
					date = sdf2.parse(fromDate);
					destDate = dateFormat.format(date);
				} 
			} else {
				throw new Exception("日期不能为空！");
			}
		} catch (Exception e) {
			throw new Exception("日期格式不对，正确格式为：yyyy-MM-dd或yyyy/MM/dd或yyyyMMdd");
		}
		return destDate;
	}
	
	/**
	 * 日期加天数
	 * @param date
	 * @param days
	 * @return
	 */
	public static String fomatDate(String date, int days) {  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		Date returnDate = null;
		try {
	        Calendar c = Calendar.getInstance();  
	        c.setTime(sdf.parse(date));
	        c.add(Calendar.DAY_OF_MONTH, days); 
	        returnDate = c.getTime();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return sdf.format(returnDate);  
    } 
	
//	public static void main(String[] args) throws Exception {
//		System.out.println(checkDate("2017-06-06"));
//		System.out.println(getStringDate());
//	}
}
