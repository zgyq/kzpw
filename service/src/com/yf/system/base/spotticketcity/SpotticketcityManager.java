/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotticketcity;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class SpotticketcityManager extends  SqlMapClientDaoSupport  implements ISpotticketcityManager{ 
	
  
 	/**
	 * 创建 门票城市
	 * @param id
	 * @return deleted count 
	 */
	public Spotticketcity createSpotticketcity(Spotticketcity spotticketcity) throws SQLException{
	
		if(spotticketcity.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		spotticketcity.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_SPOTTICKETCITY"));
		getSqlMapClientTemplate().insert("createSpotticketcity",spotticketcity);
		return spotticketcity;
	}
	/**
	 * 删除 门票城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotticketcity(long id){
	
		return getSqlMapClientTemplate().delete("deleteSpotticketcity", id);
	}
	
	
	/**
	 * 修改 门票城市
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotticketcity(Spotticketcity spotticketcity){
		return getSqlMapClientTemplate().update("updateSpotticketcity",spotticketcity);
	
	}

		
	/**
	 * 修改 门票城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotticketcityIgnoreNull(Spotticketcity spotticketcity){
		Spotticketcity tmp = findSpotticketcity(spotticketcity.getId());
		int flag =0;
		
		
		if(spotticketcity.getOutid()!=null){
			tmp.setOutid(spotticketcity.getOutid());
			
			flag++;
		}
		
		if(spotticketcity.getParentid()!=null){
			tmp.setParentid(spotticketcity.getParentid());
			
			flag++;
		}
		
		if(spotticketcity.getType()!=null){
			tmp.setType(spotticketcity.getType());
			
			flag++;
		}
		
		if(spotticketcity.getParentidstr()!=null){
			tmp.setParentidstr(spotticketcity.getParentidstr());
			
			flag++;
		}
		
		if(spotticketcity.getName()!=null){
			tmp.setName(spotticketcity.getName());
			
			flag++;
		}
		
		if(spotticketcity.getPinyin()!=null){
			tmp.setPinyin(spotticketcity.getPinyin());
			
			flag++;
		}
		
		if(spotticketcity.getParam1()!=null){
			tmp.setParam1(spotticketcity.getParam1());
			
			flag++;
		}
		
		if(spotticketcity.getParam2()!=null){
			tmp.setParam2(spotticketcity.getParam2());
			
			flag++;
		}
		
		if(spotticketcity.getParam3()!=null){
			tmp.setParam3(spotticketcity.getParam3());
			
			flag++;
		}
		
		if(spotticketcity.getCreatetime()!=null){
			tmp.setCreatetime(spotticketcity.getCreatetime());
			
			flag++;
		}
		
		if(spotticketcity.getState()!=null){
			tmp.setState(spotticketcity.getState());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateSpotticketcity",tmp);
		}
	}
	
	/**
	 * 查找 门票城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticketcity(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllSpotticketcity",map, offset, limit);
	}
		
	
	/**
	 * 查找 门票城市
	 * @param id
	 * @return
	 */
	public Spotticketcity findSpotticketcity(long id){
		return (Spotticketcity)(getSqlMapClientTemplate().queryForObject("findSpotticketcity",id));
	}
	
	/** 
	 * 查找 门票城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotticketcity(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotticketcityBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllSpotticketcity",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找门票城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticketcity(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllSpotticketcityBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 门票城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotticketcityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteSpotticketcityBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotticketcityBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countSpotticketcityBySql",map).toString()));
	}
}

