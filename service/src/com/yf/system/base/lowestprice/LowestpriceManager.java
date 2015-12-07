/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.lowestprice;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class LowestpriceManager extends  SqlMapClientDaoSupport  implements ILowestpriceManager{ 
	
  
 	/**
	 * 创建 机票低价数据表
	 * @param id
	 * @return deleted count 
	 */
	public Lowestprice createLowestprice(Lowestprice lowestprice) throws SQLException{
	
		if(lowestprice.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		lowestprice.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_LOWESTPRICE"));
		getSqlMapClientTemplate().insert("createLowestprice",lowestprice);
		return lowestprice;
	}
	/**
	 * 删除 机票低价数据表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLowestprice(long id){
	
		return getSqlMapClientTemplate().delete("deleteLowestprice", id);
	}
	
	
	/**
	 * 修改 机票低价数据表
	 * @param id
	 * @return updated count 
	 */
	public int updateLowestprice(Lowestprice lowestprice){
		return getSqlMapClientTemplate().update("updateLowestprice",lowestprice);
	
	}

		
	/**
	 * 修改 机票低价数据表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLowestpriceIgnoreNull(Lowestprice lowestprice){
		Lowestprice tmp = findLowestprice(lowestprice.getId());
		int flag =0;
		
		
		if(lowestprice.getFromcity()!=null){
			tmp.setFromcity(lowestprice.getFromcity());
			
			flag++;
		}
		
		if(lowestprice.getTocity()!=null){
			tmp.setTocity(lowestprice.getTocity());
			
			flag++;
		}
		
		if(lowestprice.getAircompanyname()!=null){
			tmp.setAircompanyname(lowestprice.getAircompanyname());
			
			flag++;
		}
		
		if(lowestprice.getPrice()!=null){
			tmp.setPrice(lowestprice.getPrice());
			
			flag++;
		}
		
		if(lowestprice.getDiscount()!=null){
			tmp.setDiscount(lowestprice.getDiscount());
			
			flag++;
		}
		
		if(lowestprice.getFromdate()!=null){
			tmp.setFromdate(lowestprice.getFromdate());
			
			flag++;
		}
		
		if(lowestprice.getFromtime()!=null){
			tmp.setFromtime(lowestprice.getFromtime());
			
			flag++;
		}
		
		if(lowestprice.getUpdatetime()!=null){
			tmp.setUpdatetime(lowestprice.getUpdatetime());
			
			flag++;
		}
		
		if(lowestprice.getScitycode()!=null){
			tmp.setScitycode(lowestprice.getScitycode());
			
			flag++;
		}
		if(lowestprice.getEcitycode()!=null){
			tmp.setEcitycode(lowestprice.getEcitycode());
			
			flag++;
		}
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateLowestprice",tmp);
		}
	}
	
	/**
	 * 查找 机票低价数据表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLowestprice(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllLowestprice",map, offset, limit);
	}
		
	
	/**
	 * 查找 机票低价数据表
	 * @param id
	 * @return
	 */
	public Lowestprice findLowestprice(long id){
		return (Lowestprice)(getSqlMapClientTemplate().queryForObject("findLowestprice",id));
	}
	
	/** 
	 * 查找 机票低价数据表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLowestprice(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countLowestpriceBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllLowestprice",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找机票低价数据表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLowestprice(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllLowestpriceBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 机票低价数据表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLowestpriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteLowestpriceBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLowestpriceBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countLowestpriceBySql",map).toString()));
	}
}

