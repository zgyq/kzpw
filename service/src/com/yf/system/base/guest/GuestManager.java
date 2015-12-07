/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.guest;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class GuestManager extends  SqlMapClientDaoSupport  implements IGuestManager{ 
	
  
 	/**
	 * 创建 客人信息表
	 * @param id
	 * @return deleted count 
	 */
	public Guest createGuest(Guest guest) throws SQLException{
	
		if(guest.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		guest.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_GUEST"));
		getSqlMapClientTemplate().insert("createGuest",guest);
		if(guest.getUcode()==null||guest.getUcode()<1)
		{
			guest.setUcode(guest.getId());
			updateGuestIgnoreNull(guest);
		}
		return guest;
	}
	/**
	 * 删除 客人信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGuest(long id){
	
		return getSqlMapClientTemplate().delete("deleteGuest", id);
	}
	
	
	/**
	 * 修改 客人信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateGuest(Guest guest){
		return getSqlMapClientTemplate().update("updateGuest",guest);
	
	}

		
	/**
	 * 修改 客人信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGuestIgnoreNull(Guest guest){
		Guest tmp = findGuest(guest.getId());
		int flag =0;
		
		
		if(guest.getName()!=null){
			tmp.setName(guest.getName());
			
			flag++;
		}
		
		if(guest.getCountry()!=null){
			tmp.setCountry(guest.getCountry());
			
			flag++;
		}
		
		if(guest.getSex()!=null){
			tmp.setSex(guest.getSex());
			
			flag++;
		}
		
		if(guest.getRoomno()!=null){
			tmp.setRoomno(guest.getRoomno());
			
			flag++;
		}
		if(guest.getUserfan()!=null){
			tmp.setUserfan(guest.getUserfan());
			
			flag++;
		}
		if(guest.getPlatfan()!=null){
			tmp.setPlatfan(guest.getPlatfan());
			
			flag++;
		}
		if(guest.getOnefan()!=null){
			tmp.setOnefan(guest.getOnefan());
			
			flag++;
		}
		if(guest.getTwofan()!=null){
			tmp.setTwofan(guest.getTwofan());
			
			flag++;
		}
		if(guest.getThreefan()!=null){
			tmp.setThreefan(guest.getThreefan());
			
			flag++;
		}
		if(guest.getRuzhutime()!=null){
			tmp.setRuzhutime(guest.getRuzhutime());
			
			flag++;
		}
		if(guest.getShijitime()!=null){
			tmp.setShijitime(guest.getShijitime());
			
			flag++;
		}
		if(guest.getLikaitime()!=null){
			tmp.setLikaitime(guest.getLikaitime());
			
			flag++;
		}
		if(guest.getPrice()!=null){
			tmp.setPrice(guest.getPrice());
			
			flag++;
		}
		if(guest.getState()!=null){
			tmp.setState(guest.getState());
			
			flag++;
		}
		
		if(guest.getOrderid()!=null){
			tmp.setOrderid(guest.getOrderid());
			
			flag++;
		}
		
		if(guest.getMemo()!=null){
			tmp.setMemo(guest.getMemo());
			
			flag++;
		}
		
		if(guest.getVersion()!=null){
			tmp.setVersion(guest.getVersion());
			
			flag++;
		}
		
		if(guest.getMobile()!=null){
			tmp.setMobile(guest.getMobile());
			
			flag++;
		}
		
		if(guest.getUcode()!=null){
			tmp.setUcode(guest.getUcode());
			
			flag++;
		}
		
		if(guest.getLanguage()!=null){
			tmp.setLanguage(guest.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateGuest",tmp);
		}
	}
	
	/**
	 * 查找 客人信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGuest(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Guest.COL_language+" = 0 OR "+Guest.COL_language+" is NULL)";
		}
		else if(where.indexOf(Guest.COL_language)<0)
		{
			where+=" and ("+Guest.COL_language+" = 0 OR "+Guest.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllGuest",map, offset, limit);
	}
		
	
	/**
	 * 查找 客人信息表
	 * @param id
	 * @return
	 */
	public Guest findGuest(long id){
		return (Guest)(getSqlMapClientTemplate().queryForObject("findGuest",id));
	}
	/**
	 * 查找 客人信息表 by language
	 * @param id
	 * @return
	 */
	public Guest findGuestbylanguage(long id,Integer language){
		String where = " where 1=1 and "+Guest.COL_ucode+" = "+id+" and "+Guest.COL_language+" = "+language;	
		List list=findAllGuest(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Guest)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 客人信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGuest(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Guest.COL_language+" = 0";
		}
		else if(where.indexOf(Guest.COL_language)<0)
		{
			where+=" and "+Guest.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countGuestBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllGuest",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找客人信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGuest(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllGuestBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 客人信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGuestBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteGuestBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGuestBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countGuestBySql",map).toString()));
	}
}

