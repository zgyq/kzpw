/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tuipiao;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TuipiaoComponent   implements ITuipiaoComponent{ 
	
	
	private ITuipiaoManager tuipiaoManager;
   
   
 	public ITuipiaoManager getTuipiaoManager() {
		return tuipiaoManager;
	}

	public void setTuipiaoManager(ITuipiaoManager tuipiaoManager) {
		this.tuipiaoManager = tuipiaoManager;
	}
  
 	/**
	 * 创建 退票报表
	 * @param id
	 * @return deleted count 
	 */
	public Tuipiao createTuipiao(Tuipiao tuipiao) throws SQLException{
	
		return tuipiaoManager.createTuipiao(tuipiao);
	}
	/**
	 * 删除 退票报表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTuipiao(long id){
	
		return tuipiaoManager.deleteTuipiao(id);
	}
	
	
	/**
	 * 修改 退票报表
	 * @param id
	 * @return updated count 
	 */
	public int updateTuipiao(Tuipiao tuipiao){
		return tuipiaoManager.updateTuipiao(tuipiao);
	
	}

		
	/**
	 * 修改 退票报表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTuipiaoIgnoreNull(Tuipiao tuipiao){
			return tuipiaoManager.updateTuipiaoIgnoreNull(tuipiao);
	
	}
	
	/**
	 * 查找 退票报表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTuipiao(String where, String orderby,int limit,int offset){
		return tuipiaoManager.findAllTuipiao(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 退票报表
	 * @param id
	 * @return
	 */
	public Tuipiao findTuipiao(long id){
		return tuipiaoManager.findTuipiao(id);
	}
	
	/** 
	 * 查找 退票报表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTuipiao(String where, String orderby,PageInfo pageinfo){
		return tuipiaoManager.findAllTuipiao(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找退票报表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTuipiao(String sql,int limit,int offset){
		return tuipiaoManager.findAllTuipiao(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 退票报表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTuipiaoBySql(String sql){
		return tuipiaoManager.excuteTuipiaoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTuipiaoBySql(String sql){
		return tuipiaoManager.countTuipiaoBySql(sql);
	}
}

