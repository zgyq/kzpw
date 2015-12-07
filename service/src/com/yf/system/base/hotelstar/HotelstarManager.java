/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelstar;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotelstarManager extends  SqlMapClientDaoSupport  implements IHotelstarManager{ 
	
  
 	/**
	 * 创建 酒店星级返点对应表
	 * @param id
	 * @return deleted count 
	 */
	public Hotelstar createHotelstar(Hotelstar hotelstar) throws SQLException{
	
		if(hotelstar.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotelstar.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HOTELSTAR"));
		getSqlMapClientTemplate().insert("createHotelstar",hotelstar);
		return hotelstar;
	}
	/**
	 * 删除 酒店星级返点对应表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelstar(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotelstar", id);
	}
	
	
	/**
	 * 修改 酒店星级返点对应表
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelstar(Hotelstar hotelstar){
		return getSqlMapClientTemplate().update("updateHotelstar",hotelstar);
	
	}

		
	/**
	 * 修改 酒店星级返点对应表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelstarIgnoreNull(Hotelstar hotelstar){
		Hotelstar tmp = findHotelstar(hotelstar.getId());
		int flag =0;
		
		
		if(hotelstar.getStarid()!=null){
			tmp.setStarid(hotelstar.getStarid());
			
			flag++;
		}
		
		if(hotelstar.getStarname()!=null){
			tmp.setStarname(hotelstar.getStarname());
			
			flag++;
		}
		
		if(hotelstar.getVal()!=null){
			tmp.setVal(hotelstar.getVal());
			
			flag++;
		}
		
		if(hotelstar.getCreateuserid()!=null){
			tmp.setCreateuserid(hotelstar.getCreateuserid());
			
			flag++;
		}
		
		if(hotelstar.getComment()!=null){
			tmp.setComment(hotelstar.getComment());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotelstar",tmp);
		}
	}
	
	/**
	 * 查找 酒店星级返点对应表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstar(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotelstar",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店星级返点对应表
	 * @param id
	 * @return
	 */
	public Hotelstar findHotelstar(long id){
		return (Hotelstar)(getSqlMapClientTemplate().queryForObject("findHotelstar",id));
	}
	
	/** 
	 * 查找 酒店星级返点对应表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelstar(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelstarBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotelstar",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店星级返点对应表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstar(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotelstarBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店星级返点对应表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelstarBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotelstarBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelstarBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelstarBySql",map).toString()));
	}
}

