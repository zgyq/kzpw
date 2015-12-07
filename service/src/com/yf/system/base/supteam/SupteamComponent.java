/**
 * ��Ȩ����, ���컪��
 * Author: 允风文化 ��Ŀ������
 * copyright: 2012
 */
 
package com.yf.system.base.supteam;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SupteamComponent   implements ISupteamComponent{ 
	
	
	private ISupteamManager SupteamManager;
   
   
 	public ISupteamManager getSupteamManager() {
		return SupteamManager;
	}

	public void setSupteamManager(ISupteamManager SupteamManager) {
		this.SupteamManager = SupteamManager;
	}
  
 	/**
	 * ���� �Ŷ����뱨�۱�
	 * @param id
	 * @return deleted count 
	 */
	public Supteam createSupteam(Supteam Supteam) throws SQLException{
	
		return SupteamManager.createSupteam(Supteam);
	}
	/**
	 * ɾ�� �Ŷ����뱨�۱�
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSupteam(long id){
	
		return SupteamManager.deleteSupteam(id);
	}
	
	
	/**
	 * �޸� �Ŷ����뱨�۱�
	 * @param id
	 * @return updated count 
	 */
	public int updateSupteam(Supteam Supteam){
		return SupteamManager.updateSupteam(Supteam);
	
	}

		
	/**
	 * �޸� �Ŷ����뱨�۱?���Կ�ֵ 
	 * @param id
	 * @return 
	 */
	public int updateSupteamIgnoreNull(Supteam Supteam){
			return SupteamManager.updateSupteamIgnoreNull(Supteam);
	
	}
	
	/**
	 * ���� �Ŷ����뱨�۱�
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSupteam(String where, String orderby,int limit,int offset){
		return SupteamManager.findAllSupteam(where, orderby,limit,offset);
	}
		
	
	/**
	 * ���� �Ŷ����뱨�۱�
	 * @param id
	 * @return
	 */
	public Supteam findSupteam(long id){
		return SupteamManager.findSupteam(id);
	}
	
	/** 
	 * ���� �Ŷ����뱨�۱�
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSupteam(String where, String orderby,PageInfo pageinfo){
		return SupteamManager.findAllSupteam(where, orderby,pageinfo);
	}
		
	/** 
	 * ���Sql�����Ŷ����뱨�۱�
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSupteam(String sql,int limit,int offset){
		return SupteamManager.findAllSupteam(sql,limit,offset);
	}
	
	
	/**
	 * ִ��Sql �Ŷ����뱨�۱�
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSupteamBySql(String sql){
		return SupteamManager.excuteSupteamBySql(sql);
	}
	
	/**
	 * ִ��Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSupteamBySql(String sql){
		return SupteamManager.countSupteamBySql(sql);
	}
}

