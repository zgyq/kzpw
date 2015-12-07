/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.travelskyreport;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TravelskyreportComponent   implements ITravelskyreportComponent{ 
	
	
	private ITravelskyreportManager travelskyreportManager;
   
   
 	public ITravelskyreportManager getTravelskyreportManager() {
		return travelskyreportManager;
	}

	public void setTravelskyreportManager(ITravelskyreportManager travelskyreportManager) {
		this.travelskyreportManager = travelskyreportManager;
	}
  
 	/**
	 * 创建 航空公司报表导入
	 * @param id
	 * @return deleted count 
	 */
	public Travelskyreport createTravelskyreport(Travelskyreport travelskyreport) throws SQLException{
	
		return travelskyreportManager.createTravelskyreport(travelskyreport);
	}
	/**
	 * 删除 航空公司报表导入
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTravelskyreport(long id){
	
		return travelskyreportManager.deleteTravelskyreport(id);
	}
	
	
	/**
	 * 修改 航空公司报表导入
	 * @param id
	 * @return updated count 
	 */
	public int updateTravelskyreport(Travelskyreport travelskyreport){
		return travelskyreportManager.updateTravelskyreport(travelskyreport);
	
	}

		
	/**
	 * 修改 航空公司报表导入但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTravelskyreportIgnoreNull(Travelskyreport travelskyreport){
			return travelskyreportManager.updateTravelskyreportIgnoreNull(travelskyreport);
	
	}
	
	/**
	 * 查找 航空公司报表导入
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTravelskyreport(String where, String orderby,int limit,int offset){
		return travelskyreportManager.findAllTravelskyreport(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 航空公司报表导入
	 * @param id
	 * @return
	 */
	public Travelskyreport findTravelskyreport(long id){
		return travelskyreportManager.findTravelskyreport(id);
	}
	
	/** 
	 * 查找 航空公司报表导入
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTravelskyreport(String where, String orderby,PageInfo pageinfo){
		return travelskyreportManager.findAllTravelskyreport(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找航空公司报表导入
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTravelskyreport(String sql,int limit,int offset){
		return travelskyreportManager.findAllTravelskyreport(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 航空公司报表导入
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTravelskyreportBySql(String sql){
		return travelskyreportManager.excuteTravelskyreportBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTravelskyreportBySql(String sql){
		return travelskyreportManager.countTravelskyreportBySql(sql);
	}
}

