/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.conferencehotel;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class ConferencehotelComponent   implements IConferencehotelComponent{ 
	
	
	private IConferencehotelManager conferencehotelManager;
   
   
 	public IConferencehotelManager getConferencehotelManager() {
		return conferencehotelManager;
	}

	public void setConferencehotelManager(IConferencehotelManager conferencehotelManager) {
		this.conferencehotelManager = conferencehotelManager;
	}
  
 	/**
	 * 创建 会议酒店
	 * @param id
	 * @return deleted count 
	 */
	public Conferencehotel createConferencehotel(Conferencehotel conferencehotel) throws SQLException{
	
		return conferencehotelManager.createConferencehotel(conferencehotel);
	}
	/**
	 * 删除 会议酒店
	 * @param id
	 * @return deleted count 
	 */
	public int deleteConferencehotel(long id){
	
		return conferencehotelManager.deleteConferencehotel(id);
	}
	
	
	/**
	 * 修改 会议酒店
	 * @param id
	 * @return updated count 
	 */
	public int updateConferencehotel(Conferencehotel conferencehotel){
		return conferencehotelManager.updateConferencehotel(conferencehotel);
	
	}

		
	/**
	 * 修改 会议酒店但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateConferencehotelIgnoreNull(Conferencehotel conferencehotel){
			return conferencehotelManager.updateConferencehotelIgnoreNull(conferencehotel);
	
	}
	
	/**
	 * 查找 会议酒店
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehotel(String where, String orderby,int limit,int offset){
		return conferencehotelManager.findAllConferencehotel(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会议酒店
	 * @param id
	 * @return
	 */
	public Conferencehotel findConferencehotel(long id){
		return conferencehotelManager.findConferencehotel(id);
	}
	/**
	 * 查找 会议酒店 by language
	 * @param id
	 * @return
	 */
	public Conferencehotel findConferencehotelbylanguage(long id,Integer language){
		return conferencehotelManager.findConferencehotelbylanguage(id,language);
	}
	/** 
	 * 查找 会议酒店
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllConferencehotel(String where, String orderby,PageInfo pageinfo){
		return conferencehotelManager.findAllConferencehotel(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会议酒店
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllConferencehotel(String sql,int limit,int offset){
		return conferencehotelManager.findAllConferencehotel(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会议酒店
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteConferencehotelBySql(String sql){
		return conferencehotelManager.excuteConferencehotelBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countConferencehotelBySql(String sql){
		return conferencehotelManager.countConferencehotelBySql(sql);
	}
}

