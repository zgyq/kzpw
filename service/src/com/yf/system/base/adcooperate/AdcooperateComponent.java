/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.adcooperate;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class AdcooperateComponent   implements IAdcooperateComponent{ 
	
	
	private IAdcooperateManager adcooperateManager;
   
   
 	public IAdcooperateManager getAdcooperateManager() {
		return adcooperateManager;
	}

	public void setAdcooperateManager(IAdcooperateManager adcooperateManager) {
		this.adcooperateManager = adcooperateManager;
	}
  
 	/**
	 * 创建 广告合作表
	 * @param id
	 * @return deleted count 
	 */
	public Adcooperate createAdcooperate(Adcooperate adcooperate) throws SQLException{
	
		return adcooperateManager.createAdcooperate(adcooperate);
	}
	/**
	 * 删除 广告合作表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAdcooperate(long id){
	
		return adcooperateManager.deleteAdcooperate(id);
	}
	
	
	/**
	 * 修改 广告合作表
	 * @param id
	 * @return updated count 
	 */
	public int updateAdcooperate(Adcooperate adcooperate){
		return adcooperateManager.updateAdcooperate(adcooperate);
	
	}

		
	/**
	 * 修改 广告合作表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAdcooperateIgnoreNull(Adcooperate adcooperate){
			return adcooperateManager.updateAdcooperateIgnoreNull(adcooperate);
	
	}
	
	/**
	 * 查找 广告合作表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdcooperate(String where, String orderby,int limit,int offset){
		return adcooperateManager.findAllAdcooperate(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 广告合作表
	 * @param id
	 * @return
	 */
	public Adcooperate findAdcooperate(long id){
		return adcooperateManager.findAdcooperate(id);
	}
	
	/** 
	 * 查找 广告合作表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAdcooperate(String where, String orderby,PageInfo pageinfo){
		return adcooperateManager.findAllAdcooperate(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找广告合作表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAdcooperate(String sql,int limit,int offset){
		return adcooperateManager.findAllAdcooperate(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 广告合作表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAdcooperateBySql(String sql){
		return adcooperateManager.excuteAdcooperateBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAdcooperateBySql(String sql){
		return adcooperateManager.countAdcooperateBySql(sql);
	}
}

