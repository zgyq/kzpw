/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotcity;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpotcityManager extends  SqlMapClientDaoSupport  implements ISpotcityManager{ 
	
  
 	/**
	 * 创建 景区城市
	 * @param id
	 * @return deleted count 
	 */
	public Spotcity createSpotcity(Spotcity spotcity) throws SQLException{
	
		if(spotcity.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		spotcity.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPOTCITY"));
		getSqlMapClientTemplate().insert("createSpotcity",spotcity);
		return spotcity;
	}
	/**
	 * 删除 景区城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotcity(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpotcity", id);
	}
	
	
	/**
	 * 修改 景区城市
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotcity(Spotcity spotcity){
		return getSqlMapClientTemplate().update("updateSpotcity",spotcity);
	
	}

		
	/**
	 * 修改 景区城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotcityIgnoreNull(Spotcity spotcity){
		Spotcity tmp = findSpotcity(spotcity.getId());
		int flag =0;
		
		
		if(spotcity.getOutid()!=null){
			tmp.setOutid(spotcity.getOutid());
			
			flag++;
		}
		
		if(spotcity.getParentid()!=null){
			tmp.setParentid(spotcity.getParentid());
			
			flag++;
		}
		
		if(spotcity.getParentidstr()!=null){
			tmp.setParentidstr(spotcity.getParentidstr());
			
			flag++;
		}
		
		if(spotcity.getName()!=null){
			tmp.setName(spotcity.getName());
			
			flag++;
		}
		
		if(spotcity.getParam1()!=null){
			tmp.setParam1(spotcity.getParam1());
			
			flag++;
		}
		
		if(spotcity.getParam2()!=null){
			tmp.setParam2(spotcity.getParam2());
			
			flag++;
		}
		
		if(spotcity.getParam3()!=null){
			tmp.setParam3(spotcity.getParam3());
			
			flag++;
		}
		
		if(spotcity.getCreatetime()!=null){
			tmp.setCreatetime(spotcity.getCreatetime());
			
			flag++;
		}
		
		if(spotcity.getState()!=null){
			tmp.setState(spotcity.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpotcity",tmp);
		}
	}
	
	/**
	 * 查找 景区城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotcity(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpotcity",map, offset, limit);
	}
		
	
	/**
	 * 查找 景区城市
	 * @param id
	 * @return
	 */
	public Spotcity findSpotcity(long id){
		return (Spotcity)(getSqlMapClientTemplate().queryForObject("findSpotcity",id));
	}
	
	/** 
	 * 查找 景区城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotcity(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotcityBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpotcity",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找景区城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotcity(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpotcityBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 景区城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotcityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpotcityBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotcityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotcityBySql",map).toString()));
	}
}

