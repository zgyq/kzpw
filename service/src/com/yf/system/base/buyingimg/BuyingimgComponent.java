/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.buyingimg;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class BuyingimgComponent   implements IBuyingimgComponent{ 
	
	
	private IBuyingimgManager buyingimgManager;
   
   
 	public IBuyingimgManager getBuyingimgManager() {
		return buyingimgManager;
	}

	public void setBuyingimgManager(IBuyingimgManager buyingimgManager) {
		this.buyingimgManager = buyingimgManager;
	}
  
 	/**
	 * 创建 团购图片信息
	 * @param id
	 * @return deleted count 
	 */
	public Buyingimg createBuyingimg(Buyingimg buyingimg) throws SQLException{
	
		return buyingimgManager.createBuyingimg(buyingimg);
	}
	/**
	 * 删除 团购图片信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBuyingimg(long id){
	
		return buyingimgManager.deleteBuyingimg(id);
	}
	
	
	/**
	 * 修改 团购图片信息
	 * @param id
	 * @return updated count 
	 */
	public int updateBuyingimg(Buyingimg buyingimg){
		return buyingimgManager.updateBuyingimg(buyingimg);
	
	}

		
	/**
	 * 修改 团购图片信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBuyingimgIgnoreNull(Buyingimg buyingimg){
			return buyingimgManager.updateBuyingimgIgnoreNull(buyingimg);
	
	}
	
	/**
	 * 查找 团购图片信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuyingimg(String where, String orderby,int limit,int offset){
		return buyingimgManager.findAllBuyingimg(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 团购图片信息
	 * @param id
	 * @return
	 */
	public Buyingimg findBuyingimg(long id){
		return buyingimgManager.findBuyingimg(id);
	}
	
	/** 
	 * 查找 团购图片信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBuyingimg(String where, String orderby,PageInfo pageinfo){
		return buyingimgManager.findAllBuyingimg(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找团购图片信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBuyingimg(String sql,int limit,int offset){
		return buyingimgManager.findAllBuyingimg(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 团购图片信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBuyingimgBySql(String sql){
		return buyingimgManager.excuteBuyingimgBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBuyingimgBySql(String sql){
		return buyingimgManager.countBuyingimgBySql(sql);
	}
}

