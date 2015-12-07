package com.yf.system.framework.service;

import java.sql.Timestamp;

public class ServiceSupport   {
	/**
	 * @return 获取当前时间
	 */
	public Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());

	}
	
	

}
