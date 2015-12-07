/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airliencabin;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class AirliencabinManager extends  SqlMapClientDaoSupport  implements IAirliencabinManager{ 
	
  
 	/**
	 * 创建 航线仓位信息
	 * @param id
	 * @return deleted count 
	 */
	public Airliencabin createAirliencabin(Airliencabin airliencabin) throws SQLException{
	
		if(airliencabin.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		airliencabin.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_AIRLIENCABIN"));
		getSqlMapClientTemplate().insert("createAirliencabin",airliencabin);
		return airliencabin;
	}
	/**
	 * 删除 航线仓位信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirliencabin(long id){
	
		return getSqlMapClientTemplate().delete("deleteAirliencabin", id);
	}
	
	
	/**
	 * 修改 航线仓位信息
	 * @param id
	 * @return updated count 
	 */
	public int updateAirliencabin(Airliencabin airliencabin){
		return getSqlMapClientTemplate().update("updateAirliencabin",airliencabin);
	
	}

		
	/**
	 * 修改 航线仓位信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirliencabinIgnoreNull(Airliencabin airliencabin){
		Airliencabin tmp = findAirliencabin(airliencabin.getId());
		int flag =0;
		
		
		if(airliencabin.getAirlineid()!=null){
			tmp.setAirlineid(airliencabin.getAirlineid());
			
			flag++;
		}
		
		if(airliencabin.getScode()!=null){
			tmp.setScode(airliencabin.getScode());
			
			flag++;
		}
		
		if(airliencabin.getEcode()!=null){
			tmp.setEcode(airliencabin.getEcode());
			
			flag++;
		}
		
		if(airliencabin.getAirno()!=null){
			tmp.setAirno(airliencabin.getAirno());
			
			flag++;
		}
		
		if(airliencabin.getCode()!=null){
			tmp.setCode(airliencabin.getCode());
			
			flag++;
		}
		
		if(airliencabin.getPrice()!=null){
			tmp.setPrice(airliencabin.getPrice());
			
			flag++;
		}
		
		if(airliencabin.getParam1()!=null){
			tmp.setParam1(airliencabin.getParam1());
			
			flag++;
		}
		
		if(airliencabin.getParam2()!=null){
			tmp.setParam2(airliencabin.getParam2());
			
			flag++;
		}
		
		if(airliencabin.getParam3()!=null){
			tmp.setParam3(airliencabin.getParam3());
			
			flag++;
		}
		
		if(airliencabin.getState()!=null){
			tmp.setState(airliencabin.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateAirliencabin",tmp);
		}
	}
	
	/**
	 * 查找 航线仓位信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirliencabin(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllAirliencabin",map, offset, limit);
	}
		
	
	/**
	 * 查找 航线仓位信息
	 * @param id
	 * @return
	 */
	public Airliencabin findAirliencabin(long id){
		return (Airliencabin)(getSqlMapClientTemplate().queryForObject("findAirliencabin",id));
	}
	
	/** 
	 * 查找 航线仓位信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirliencabin(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAirliencabinBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllAirliencabin",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找航线仓位信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirliencabin(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllAirliencabinBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 航线仓位信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirliencabinBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteAirliencabinBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirliencabinBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAirliencabinBySql",map).toString()));
	}
}

