/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fairway;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class FairwayComponent   implements IFairwayComponent{ 
	
	
	private IFairwayManager fairwayManager;
   
   
 	public IFairwayManager getFairwayManager() {
		return fairwayManager;
	}

	public void setFairwayManager(IFairwayManager fairwayManager) {
		this.fairwayManager = fairwayManager;
	}
  
 	/**
	 * 创建 国际机票航空公司
	 * @param id
	 * @return deleted count 
	 */
	public Fairway createFairway(Fairway fairway) throws SQLException{
	
		return fairwayManager.createFairway(fairway);
	}
	/**
	 * 删除 国际机票航空公司
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFairway(long id){
	
		return fairwayManager.deleteFairway(id);
	}
	
	
	/**
	 * 修改 国际机票航空公司
	 * @param id
	 * @return updated count 
	 */
	public int updateFairway(Fairway fairway){
		return fairwayManager.updateFairway(fairway);
	
	}

		
	/**
	 * 修改 国际机票航空公司但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFairwayIgnoreNull(Fairway fairway){
			return fairwayManager.updateFairwayIgnoreNull(fairway);
	
	}
	
	/**
	 * 查找 国际机票航空公司
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairway(String where, String orderby,int limit,int offset){
		return fairwayManager.findAllFairway(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 国际机票航空公司
	 * @param id
	 * @return
	 */
	public Fairway findFairway(long id){
		return fairwayManager.findFairway(id);
	}
	/**
	 * 查找 国际机票航空公司 by language
	 * @param id
	 * @return
	 */
	public Fairway findFairwaybylanguage(long id,Integer language){
		return fairwayManager.findFairwaybylanguage(id,language);
	}
	/** 
	 * 查找 国际机票航空公司
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFairway(String where, String orderby,PageInfo pageinfo){
		return fairwayManager.findAllFairway(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找国际机票航空公司
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairway(String sql,int limit,int offset){
		return fairwayManager.findAllFairway(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 国际机票航空公司
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFairwayBySql(String sql){
		return fairwayManager.excuteFairwayBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFairwayBySql(String sql){
		return fairwayManager.countFairwayBySql(sql);
	}
}

