/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelpass;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotelpassManager extends  SqlMapClientDaoSupport  implements IHotelpassManager{ 
	
  
 	/**
	 * 创建 酒店常用入住人表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelpass createHotelpass(Hotelpass hotelpass) throws SQLException{
	
		if(hotelpass.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotelpass.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HOTELPASS"));
		getSqlMapClientTemplate().insert("createHotelpass",hotelpass);
		return hotelpass;
	}
	/**
	 * 删除 酒店常用入住人表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelpass(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotelpass", id);
	}
	
	
	/**
	 * 修改 酒店常用入住人表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelpass(Hotelpass hotelpass){
		return getSqlMapClientTemplate().update("updateHotelpass",hotelpass);
	
	}

		
	/**
	 * 修改 酒店常用入住人表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelpassIgnoreNull(Hotelpass hotelpass){
		Hotelpass tmp = findHotelpass(hotelpass.getId());
		int flag =0;
		
		
		if(hotelpass.getName()!=null){
			tmp.setName(hotelpass.getName());
			
			flag++;
		}
		
		if(hotelpass.getMobile()!=null){
			tmp.setMobile(hotelpass.getMobile());
			
			flag++;
		}
		
		if(hotelpass.getSex()!=null){
			tmp.setSex(hotelpass.getSex());
			
			flag++;
		}
		
		if(hotelpass.getCreateuserid()!=null){
			tmp.setCreateuserid(hotelpass.getCreateuserid());
			
			flag++;
		}
		
		if(hotelpass.getComment()!=null){
			tmp.setComment(hotelpass.getComment());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotelpass",tmp);
		}
	}
	
	/**
	 * 查找 酒店常用入住人表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelpass(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotelpass",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店常用入住人表
	 * @param id
	 * @return
	 */
	public Hotelpass findHotelpass(long id){
		return (Hotelpass)(getSqlMapClientTemplate().queryForObject("findHotelpass",id));
	}
	
	/** 
	 * 查找 酒店常用入住人表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelpass(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelpassBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotelpass",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店常用入住人表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelpass(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotelpassBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店常用入住人表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelpassBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotelpassBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelpassBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelpassBySql",map).toString()));
	}
}

