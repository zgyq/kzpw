package com.yf.system.back.servlet;

import java.util.Date;
import java.util.TimerTask;

public class TestTimerTask extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		  Date executeTime = new Date(this.scheduledExecutionTime());
          System.out.println("本次任务执行的时间是" + executeTime);
		
	}
	
	

}
