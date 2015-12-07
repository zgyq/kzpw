/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.segmentinfo;
import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 *行程表
 *在此类中添加方法和属性，在第一次生成后将不会再做统一更改。
 */
public class Segmentinfo extends SegmentinfoBean{

    private String aircompanyname;

    
    

    
    //机型
    private String flightmodelnum;
    


	public String getAircompanyname() {
		return aircompanyname;
	}


	public void setAircompanyname(String aircompanyname) {
		this.aircompanyname = aircompanyname;
	}


	public String getFlightmodelnum() {
		return flightmodelnum;
	}


	public void setFlightmodelnum(String flightmodelnum) {
		this.flightmodelnum = flightmodelnum;
	}

}
