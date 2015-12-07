package com.yf.system.bak.excel;

public class HthyExcelBase {
	
	
	/**
	 * 转换null
	 * 
	 * @param <T>
	 * @param t
	 * @param v
	 * @return
	 */
	public <T> T converNull(T t, T v) {
		if (t != null) {
			return t;
		}
		return v;
	}

}
