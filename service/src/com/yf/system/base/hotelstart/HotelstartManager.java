/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.hotelstart;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class HotelstartManager extends  SqlMapClientDaoSupport  implements IHotelstartManager{ 
	
  
 	/**
	 * 创建 酒店星级返利
	 * @param id
	 * @return deleted count 
	 */
	public Hotelstart createHotelstart(Hotelstart hotelstart) throws SQLException{
	
		if(hotelstart.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		hotelstart.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_HOTELSTART"));
		getSqlMapClientTemplate().insert("createHotelstart",hotelstart);
		return hotelstart;
	}
	/**
	 * 删除 酒店星级返利
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHotelstart(long id){
	
		return getSqlMapClientTemplate().delete("deleteHotelstart", id);
	}
	
	
	/**
	 * 修改 酒店星级返利
	 * @param id
	 * @return updated count 
	 */
	public int updateHotelstart(Hotelstart hotelstart){
		return getSqlMapClientTemplate().update("updateHotelstart",hotelstart);
	
	}

		
	/**
	 * 修改 酒店星级返利但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHotelstartIgnoreNull(Hotelstart hotelstart){
		Hotelstart tmp = findHotelstart(hotelstart.getId());
		int flag =0;
		
		
		if(hotelstart.getHotestart()!=null){
			tmp.setHotestart(hotelstart.getHotestart());
			
			flag++;
		}
		
		if(hotelstart.getStartcode()!=null){
			tmp.setStartcode(hotelstart.getStartcode());
			
			flag++;
		}
		
		if(hotelstart.getMargin()!=null){
			tmp.setMargin(hotelstart.getMargin());
			
			flag++;
		}
		
		if(hotelstart.getDataprovideid()!=null){
			tmp.setDataprovideid(hotelstart.getDataprovideid());
			
			flag++;
		}
		
		if(hotelstart.getCreatetime()!=null){
			tmp.setCreatetime(hotelstart.getCreatetime());
			
			flag++;
		}
		
		if(hotelstart.getCreatemanid()!=null){
			tmp.setCreatemanid(hotelstart.getCreatemanid());
			
			flag++;
		}
		
		if(hotelstart.getState()!=null){
			tmp.setState(hotelstart.getState());
			
			flag++;
		}
		
		if(hotelstart.getRemark()!=null){
			tmp.setRemark(hotelstart.getRemark());
			
			flag++;
		}
		
		if(hotelstart.getParam1()!=null){
			tmp.setParam1(hotelstart.getParam1());
			
			flag++;
		}
		
		if(hotelstart.getParam2()!=null){
			tmp.setParam2(hotelstart.getParam2());
			
			flag++;
		}
		
		if(hotelstart.getParam3()!=null){
			tmp.setParam3(hotelstart.getParam3());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateHotelstart",tmp);
		}
	}
	
	/**
	 * 查找 酒店星级返利
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstart(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllHotelstart",map, offset, limit);
	}
		
	
	/**
	 * 查找 酒店星级返利
	 * @param id
	 * @return
	 */
	public Hotelstart findHotelstart(long id){
		return (Hotelstart)(getSqlMapClientTemplate().queryForObject("findHotelstart",id));
	}
	
	/** 
	 * 查找 酒店星级返利
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHotelstart(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelstartBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllHotelstart",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找酒店星级返利
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHotelstart(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllHotelstartBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 酒店星级返利
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHotelstartBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteHotelstartBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHotelstartBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countHotelstartBySql",map).toString()));
	}
}

