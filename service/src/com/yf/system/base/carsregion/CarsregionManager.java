/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carsregion;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class CarsregionManager extends  SqlMapClientDaoSupport  implements ICarsregionManager{ 
	
  
 	/**
	 * 创建 送车上门区域
	 * @param id
	 * @return deleted count 
	 */
	public Carsregion createCarsregion(Carsregion carsregion) throws SQLException{
	
		if(carsregion.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		carsregion.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_CARSREGION"));
		getSqlMapClientTemplate().insert("createCarsregion",carsregion);
		return carsregion;
	}
	/**
	 * 删除 送车上门区域
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarsregion(long id){
	
		return getSqlMapClientTemplate().delete("deleteCarsregion", id);
	}
	
	
	/**
	 * 修改 送车上门区域
	 * @param id
	 * @return updated count 
	 */
	public int updateCarsregion(Carsregion carsregion){
		return getSqlMapClientTemplate().update("updateCarsregion",carsregion);
	
	}

		
	/**
	 * 修改 送车上门区域但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarsregionIgnoreNull(Carsregion carsregion){
		Carsregion tmp = findCarsregion(carsregion.getId());
		int flag =0;
		
		
		if(carsregion.getName()!=null){
			tmp.setName(carsregion.getName());
			
			flag++;
		}
		
		if(carsregion.getCityid()!=null){
			tmp.setCityid(carsregion.getCityid());
			
			flag++;
		}
		
		if(carsregion.getProvincecode()!=null){
			tmp.setProvincecode(carsregion.getProvincecode());
			
			flag++;
		}
		
		if(carsregion.getCreateuserid()!=null){
			tmp.setCreateuserid(carsregion.getCreateuserid());
			
			flag++;
		}
		
		if(carsregion.getPrice()!=null){
			tmp.setPrice(carsregion.getPrice());
			
			flag++;
		}
		
		if(carsregion.getComment()!=null){
			tmp.setComment(carsregion.getComment());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateCarsregion",tmp);
		}
	}
	
	/**
	 * 查找 送车上门区域
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarsregion(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllCarsregion",map, offset, limit);
	}
		
	
	/**
	 * 查找 送车上门区域
	 * @param id
	 * @return
	 */
	public Carsregion findCarsregion(long id){
		return (Carsregion)(getSqlMapClientTemplate().queryForObject("findCarsregion",id));
	}
	
	/** 
	 * 查找 送车上门区域
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarsregion(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarsregionBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllCarsregion",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找送车上门区域
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarsregion(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllCarsregionBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 送车上门区域
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarsregionBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteCarsregionBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarsregionBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countCarsregionBySql",map).toString()));
	}
}

