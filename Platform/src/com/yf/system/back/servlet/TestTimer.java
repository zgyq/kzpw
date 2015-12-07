package com.yf.system.back.servlet;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	  public static void main(String[] args) {
          Timer timer = new Timer();
          TimerTask task = new TestTimerTask();
         // timer.schedule(task, 500L, 1000L);
          String date="2011-05-27 12:40:000";
          
          SimpleDateFormat dateFormat = new SimpleDateFormat();
          if (date.length() == 10) {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			} else {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
          try {
			timer.scheduleAtFixedRate(task, new Timestamp(dateFormat.parse(date).getTime()), 10000l);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
  }
}
