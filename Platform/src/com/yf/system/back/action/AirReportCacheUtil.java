package com.yf.system.back.action;

import com.opensymphony.oscache.general.GeneralCacheAdministrator;

import java.util.Date;
import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

public class AirReportCacheUtil extends GeneralCacheAdministrator {
	private int refreshPeriod; // 过期时间(单位为秒);
	private String keyPrefix; // 关键字前缀字符;
	private static final long serialVersionUID = -4397192926052141162L;

	public AirReportCacheUtil(String keyPrefix, int refreshPeriod) {
		super();
		this.keyPrefix = keyPrefix;
		this.refreshPeriod = refreshPeriod;
	}

	// 添加被缓存的对象;
	public void put(String key, Object value) {
		super.putInCache("a", value);
	}

	// 删除被缓存的对象;
	public void remove(String key) {
		this.flushEntry(this.keyPrefix + "_" + key);
	}

	// 删除所有被缓存的对象;
	public void removeAll(Date date) {
		this.flushAll(date);
	}

	public void removeAll() {
		this.flushAll();
	}

	// 获取被缓存的对象;
	public Object get(String key) throws Exception {
		Object obj=null;
		try {
			obj= this.getFromCache("a",
					this.refreshPeriod);
		} catch (NeedsRefreshException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			this.cancelUpdate(this.keyPrefix + "_" + key);
			throw e;
		}
		return obj;
	}

}
