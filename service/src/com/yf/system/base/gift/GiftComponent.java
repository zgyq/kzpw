/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.gift;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class GiftComponent   implements IGiftComponent{ 
	
	
	private IGiftManager giftManager;
   
   
 	public IGiftManager getGiftManager() {
		return giftManager;
	}

	public void setGiftManager(IGiftManager giftManager) {
		this.giftManager = giftManager;
	}
  
 	/**
	 * 创建 礼品
	 * @param id
	 * @return deleted count 
	 */
	public Gift createGift(Gift gift) throws SQLException{
	
		return giftManager.createGift(gift);
	}
	/**
	 * 删除 礼品
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGift(long id){
	
		return giftManager.deleteGift(id);
	}
	
	
	/**
	 * 修改 礼品
	 * @param id
	 * @return updated count 
	 */
	public int updateGift(Gift gift){
		return giftManager.updateGift(gift);
	
	}

		
	/**
	 * 修改 礼品但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGiftIgnoreNull(Gift gift){
			return giftManager.updateGiftIgnoreNull(gift);
	
	}
	
	/**
	 * 查找 礼品
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGift(String where, String orderby,int limit,int offset){
		return giftManager.findAllGift(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 礼品
	 * @param id
	 * @return
	 */
	public Gift findGift(long id){
		return giftManager.findGift(id);
	}
	/**
	 * 查找 礼品 by language
	 * @param id
	 * @return
	 */
	public Gift findGiftbylanguage(long id,Integer language){
		return giftManager.findGiftbylanguage(id,language);
	}
	/** 
	 * 查找 礼品
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGift(String where, String orderby,PageInfo pageinfo){
		return giftManager.findAllGift(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找礼品
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGift(String sql,int limit,int offset){
		return giftManager.findAllGift(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 礼品
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGiftBySql(String sql){
		return giftManager.excuteGiftBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGiftBySql(String sql){
		return giftManager.countGiftBySql(sql);
	}
}

