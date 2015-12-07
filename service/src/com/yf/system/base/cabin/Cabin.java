/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.cabin;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *舱位基础信息表
 *在此类中添加方法和属性，在第一次生成后将不会再做统一更改。
 */
public class Cabin extends CabinBean{

	private String cabintypename;

	public String getCabintypename() {
		return cabintypename;
	}

	public void setCabintypename(String cabintypename) {
		this.cabintypename = cabintypename;
	}

}
