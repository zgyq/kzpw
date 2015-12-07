package com.yf.system.back.servlet;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String daytime=	new SimpleDateFormat("yyyy-MM-dd").format(new Timestamp(System.currentTimeMillis()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		daytime = sdf.format(calendar.getTime());
		System.out.println(daytime);
		
	}

}
