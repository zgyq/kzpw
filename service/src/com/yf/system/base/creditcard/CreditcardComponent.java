/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.creditcard;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CreditcardComponent   implements ICreditcardComponent{ 
	
	
	private ICreditcardManager creditcardManager;
   
   
 	public ICreditcardManager getCreditcardManager() {
		return creditcardManager;
	}

	public void setCreditcardManager(ICreditcardManager creditcardManager) {
		this.creditcardManager = creditcardManager;
	}
  
 	/**
	 * 创建 信用卡记录表
	 * @param id
	 * @return deleted count 
	 */
	public Creditcard createCreditcard(Creditcard creditcard) throws SQLException{
	
		return creditcardManager.createCreditcard(creditcard);
	}
	/**
	 * 删除 信用卡记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCreditcard(long id){
	
		return creditcardManager.deleteCreditcard(id);
	}
	
	
	/**
	 * 修改 信用卡记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateCreditcard(Creditcard creditcard){
		return creditcardManager.updateCreditcard(creditcard);
	
	}

		
	/**
	 * 修改 信用卡记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCreditcardIgnoreNull(Creditcard creditcard){
			return creditcardManager.updateCreditcardIgnoreNull(creditcard);
	
	}
	
	/**
	 * 查找 信用卡记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCreditcard(String where, String orderby,int limit,int offset){
		return creditcardManager.findAllCreditcard(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 信用卡记录表
	 * @param id
	 * @return
	 */
	public Creditcard findCreditcard(long id){
		return creditcardManager.findCreditcard(id);
	}
	
	/** 
	 * 查找 信用卡记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCreditcard(String where, String orderby,PageInfo pageinfo){
		return creditcardManager.findAllCreditcard(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找信用卡记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCreditcard(String sql,int limit,int offset){
		return creditcardManager.findAllCreditcard(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 信用卡记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCreditcardBySql(String sql){
		return creditcardManager.excuteCreditcardBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCreditcardBySql(String sql){
		return creditcardManager.countCreditcardBySql(sql);
	}
}

