/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fcountry;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class FcountryComponent   implements IFcountryComponent{ 
	
	
	private IFcountryManager fcountryManager;
   
   
 	public IFcountryManager getFcountryManager() {
		return fcountryManager;
	}

	public void setFcountryManager(IFcountryManager fcountryManager) {
		this.fcountryManager = fcountryManager;
	}
  
 	/**
	 * 创建 国际机票国家
	 * @param id
	 * @return deleted count 
	 */
	public Fcountry createFcountry(Fcountry fcountry) throws SQLException{
	
		return fcountryManager.createFcountry(fcountry);
	}
	/**
	 * 删除 国际机票国家
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFcountry(long id){
	
		return fcountryManager.deleteFcountry(id);
	}
	
	
	/**
	 * 修改 国际机票国家
	 * @param id
	 * @return updated count 
	 */
	public int updateFcountry(Fcountry fcountry){
		return fcountryManager.updateFcountry(fcountry);
	
	}

		
	/**
	 * 修改 国际机票国家但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFcountryIgnoreNull(Fcountry fcountry){
			return fcountryManager.updateFcountryIgnoreNull(fcountry);
	
	}
	
	/**
	 * 查找 国际机票国家
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcountry(String where, String orderby,int limit,int offset){
		return fcountryManager.findAllFcountry(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 国际机票国家
	 * @param id
	 * @return
	 */
	public Fcountry findFcountry(long id){
		return fcountryManager.findFcountry(id);
	}
	/**
	 * 查找 国际机票国家 by language
	 * @param id
	 * @return
	 */
	public Fcountry findFcountrybylanguage(long id,Integer language){
		return fcountryManager.findFcountrybylanguage(id,language);
	}
	/** 
	 * 查找 国际机票国家
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFcountry(String where, String orderby,PageInfo pageinfo){
		return fcountryManager.findAllFcountry(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找国际机票国家
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFcountry(String sql,int limit,int offset){
		return fcountryManager.findAllFcountry(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 国际机票国家
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFcountryBySql(String sql){
		return fcountryManager.excuteFcountryBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFcountryBySql(String sql){
		return fcountryManager.countFcountryBySql(sql);
	}
}

