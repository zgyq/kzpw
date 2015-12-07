/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airbaseprice;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class AirbasepriceManager extends  SqlMapClientDaoSupport  implements IAirbasepriceManager{ 
	
  
 	/**
	 * 创建 机票基础价格表
	 * @param id
	 * @return deleted count 
	 */
	public Airbaseprice createAirbaseprice(Airbaseprice airbaseprice) throws SQLException{
	
		if(airbaseprice.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		airbaseprice.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_AIRBASEPRICE"));
		getSqlMapClientTemplate().insert("createAirbaseprice",airbaseprice);
		if(airbaseprice.getUcode()==null||airbaseprice.getUcode()<1)
		{
			airbaseprice.setUcode(airbaseprice.getId());
			updateAirbasepriceIgnoreNull(airbaseprice);
		}
		return airbaseprice;
	}
	/**
	 * 删除 机票基础价格表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirbaseprice(long id){
	
		return getSqlMapClientTemplate().delete("deleteAirbaseprice", id);
	}
	
	
	/**
	 * 修改 机票基础价格表
	 * @param id
	 * @return updated count 
	 */
	public int updateAirbaseprice(Airbaseprice airbaseprice){
		return getSqlMapClientTemplate().update("updateAirbaseprice",airbaseprice);
	
	}

		
	/**
	 * 修改 机票基础价格表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirbasepriceIgnoreNull(Airbaseprice airbaseprice){
		Airbaseprice tmp = findAirbaseprice(airbaseprice.getId());
		int flag =0;
		
		
		if(airbaseprice.getSairportcode()!=null){
			tmp.setSairportcode(airbaseprice.getSairportcode());
			
			flag++;
		}
		
		if(airbaseprice.getEairportcode()!=null){
			tmp.setEairportcode(airbaseprice.getEairportcode());
			
			flag++;
		}
		
		if(airbaseprice.getMiles()!=null){
			tmp.setMiles(airbaseprice.getMiles());
			
			flag++;
		}
		
		if(airbaseprice.getPrice()!=null){
			tmp.setPrice(airbaseprice.getPrice());
			
			flag++;
		}
		
		if(airbaseprice.getAircompanycode()!=null){
			tmp.setAircompanycode(airbaseprice.getAircompanycode());
			
			flag++;
		}
		
		if(airbaseprice.getIsenable()!=null){
			tmp.setIsenable(airbaseprice.getIsenable());
			
			flag++;
		}
		
		if(airbaseprice.getYqflag()!=null){
			tmp.setYqflag(airbaseprice.getYqflag());
			
			flag++;
		}
		
		if(airbaseprice.getStartdate()!=null){
			tmp.setStartdate(airbaseprice.getStartdate());
			
			flag++;
		}
		
		if(airbaseprice.getEnddate()!=null){
			tmp.setEnddate(airbaseprice.getEnddate());
			
			flag++;
		}
		
		if(airbaseprice.getCreateuser()!=null){
			tmp.setCreateuser(airbaseprice.getCreateuser());
			
			flag++;
		}
		
		if(airbaseprice.getCreatetime()!=null){
			tmp.setCreatetime(airbaseprice.getCreatetime());
			
			flag++;
		}
		
		if(airbaseprice.getModifyuser()!=null){
			tmp.setModifyuser(airbaseprice.getModifyuser());
			
			flag++;
		}
		
		if(airbaseprice.getModifytime()!=null){
			tmp.setModifytime(airbaseprice.getModifytime());
			
			flag++;
		}
		
		if(airbaseprice.getUcode()!=null){
			tmp.setUcode(airbaseprice.getUcode());
			
			flag++;
		}
		
		if(airbaseprice.getLanguage()!=null){
			tmp.setLanguage(airbaseprice.getLanguage());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateAirbaseprice",tmp);
		}
	}
	
	/**
	 * 查找 机票基础价格表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirbaseprice(String where, String orderby,int limit,int offset){
		if(where==null||where.trim().length()==0)
		{
			where=" where ("+Airbaseprice.COL_language+" = 0 OR "+Airbaseprice.COL_language+" is NULL)";
		}
		else if(where.indexOf(Airbaseprice.COL_language)<0)
		{
			where+=" and ("+Airbaseprice.COL_language+" = 0 OR "+Airbaseprice.COL_language+" is NULL)";
		}
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllAirbaseprice",map, offset, limit);
	}
		
	
	/**
	 * 查找 机票基础价格表
	 * @param id
	 * @return
	 */
	public Airbaseprice findAirbaseprice(long id){
		return (Airbaseprice)(getSqlMapClientTemplate().queryForObject("findAirbaseprice",id));
	}
	/**
	 * 查找 机票基础价格表 by language
	 * @param id
	 * @return
	 */
	public Airbaseprice findAirbasepricebylanguage(long id,Integer language){
		String where = " where 1=1 and "+Airbaseprice.COL_ucode+" = "+id+" and "+Airbaseprice.COL_language+" = "+language;	
		List list=findAllAirbaseprice(where,"",-1,0);
		if(list!=null&&list.size()>0)
		{
			return (Airbaseprice)list.get(0);
		}
		return null;
	}
	/** 
	 * 查找 机票基础价格表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirbaseprice(String where, String orderby,PageInfo pageinfo){
		if(where==null||where.trim().length()==0)
		{
			where=" where "+Airbaseprice.COL_language+" = 0";
		}
		else if(where.indexOf(Airbaseprice.COL_language)<0)
		{
			where+=" and "+Airbaseprice.COL_language+" = 0";
		}
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAirbasepriceBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllAirbaseprice",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找机票基础价格表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirbaseprice(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllAirbasepriceBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 机票基础价格表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirbasepriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteAirbasepriceBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirbasepriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countAirbasepriceBySql",map).toString()));
	}
}

