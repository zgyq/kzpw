/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelcontract;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class HotelcontractComponent   implements IHotelcontractComponent{ 
	
	
	private IHotelcontractManager hotelcontractManager;
   
   
 	public IHotelcontractManager getHotelcontractManager() {
		return hotelcontractManager;
	}

	public void setHotelcontractManager(IHotelcontractManager hotelcontractManager) {
		this.hotelcontractManager = hotelcontractManager;
	}
  
 	/**
	 * 创建 酒店合同
	 * @param id
	 * @return deleted count 
	 */
	public Hotelcontract createHotelcontract(Hotelcontract hotelcontract) throws SQLException{
	
		return hotelcontractManager.createHotelcontract(hotelcontract);
	}
	/**
	 * 删除 酒店合同
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelcontract(long id){
	
		return hotelcontractManager.deleteHotelcontract(id);
	}
	
	
	/**
	 * 修改 酒店合同
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelcontract(Hotelcontract hotelcontract){
		return hotelcontractManager.updateHotelcontract(hotelcontract);
	
	}

		
	/**
	 * 修改 酒店合同但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelcontractIgnoreNull(Hotelcontract hotelcontract){
			return hotelcontractManager.updateHotelcontractIgnoreNull(hotelcontract);
	
	}
	
	/**
	 * 查找 酒店合同
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelcontract(String where, String orderby,int limit,int offset){
		return hotelcontractManager.findAllHotelcontract(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店合同
	 * @param id
	 * @return
	 */
	public Hotelcontract findHotelcontract(long id){
		return hotelcontractManager.findHotelcontract(id);
	}
	/**
	 * 查找 酒店合同 by language
	 * @param id
	 * @return
	 */
	public Hotelcontract findHotelcontractbylanguage(long id,Integer language){
		return hotelcontractManager.findHotelcontractbylanguage(id,language);
	}
	/** 
	 * 查找 酒店合同
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelcontract(String where, String orderby,PageInfo pageinfo){
		return hotelcontractManager.findAllHotelcontract(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店合同
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelcontract(String sql,int limit,int offset){
		return hotelcontractManager.findAllHotelcontract(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店合同
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelcontractBySql(String sql){
		return hotelcontractManager.excuteHotelcontractBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelcontractBySql(String sql){
		return hotelcontractManager.countHotelcontractBySql(sql);
	}
}

