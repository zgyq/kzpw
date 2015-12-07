/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.starreinfo;

import java.sql.SQLException;
import java.util.*;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.yf.system.base.util.DBTools;
import com.yf.system.base.util.PageInfo;

public class StarreinfoManager extends  SqlMapClientDaoSupport  implements IStarreinfoManager{ 
	
  
 	/**
	 * 创建 星级返点设置关联
	 * @param id
	 * @return deleted count 
	 */
	public Starreinfo createStarreinfo(Starreinfo starreinfo) throws SQLException{
	
		if(starreinfo.getId()>0){
			throw new SQLException("ID must <= 0.");
		}
		starreinfo.setId(DBTools.getID(getSqlMapClientTemplate().getDataSource().getConnection(), "T_STARREINFO"));
		getSqlMapClientTemplate().insert("createStarreinfo",starreinfo);
		return starreinfo;
	}
	/**
	 * 删除 星级返点设置关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteStarreinfo(long id){
	
		return getSqlMapClientTemplate().delete("deleteStarreinfo", id);
	}
	
	
	/**
	 * 修改 星级返点设置关联
	 * @param id
	 * @return updated count 
	 */
	public int updateStarreinfo(Starreinfo starreinfo){
		return getSqlMapClientTemplate().update("updateStarreinfo",starreinfo);
	
	}

		
	/**
	 * 修改 星级返点设置关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateStarreinfoIgnoreNull(Starreinfo starreinfo){
		Starreinfo tmp = findStarreinfo(starreinfo.getId());
		int flag =0;
		
		
		if(starreinfo.getSagentid()!=null){
			tmp.setSagentid(starreinfo.getSagentid());
			
			flag++;
		}
		
		if(starreinfo.getSliudianrecid()!=null){
			tmp.setSliudianrecid(starreinfo.getSliudianrecid());
			
			flag++;
		}
		
		if(starreinfo.getTypeid()!=null){
			tmp.setTypeid(starreinfo.getTypeid());
			
			flag++;
		}
		
		if(starreinfo.getParam1()!=null){
			tmp.setParam1(starreinfo.getParam1());
			
			flag++;
		}
		
		if(starreinfo.getParam2()!=null){
			tmp.setParam2(starreinfo.getParam2());
			
			flag++;
		}
		
		if(starreinfo.getParam3()!=null){
			tmp.setParam3(starreinfo.getParam3());
			
			flag++;
		}
		
		
		if(flag==0){
			return 0;
		}else{
			return getSqlMapClientTemplate().update("updateStarreinfo",tmp);
		}
	}
	
	/**
	 * 查找 星级返点设置关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarreinfo(String where, String orderby,int limit,int offset){
		Map map = new HashMap();
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		map.put("where", where);
		map.put("orderby", orderby);
		return getSqlMapClientTemplate().queryForList("findAllStarreinfo",map, offset, limit);
	}
		
	
	/**
	 * 查找 星级返点设置关联
	 * @param id
	 * @return
	 */
	public Starreinfo findStarreinfo(long id){
		return (Starreinfo)(getSqlMapClientTemplate().queryForObject("findStarreinfo",id));
	}
	
	/** 
	 * 查找 星级返点设置关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllStarreinfo(String where, String orderby,PageInfo pageinfo){
		Map map = new HashMap();
		map.put("where", where);
		map.put("orderby", orderby);
		pageinfo.setTotalrow(Integer.parseInt(getSqlMapClientTemplate().queryForObject("countStarreinfoBySql",map).toString()));
		int offset = pageinfo.getOffset();
		int limit  = pageinfo.getLimit();
		List list = getSqlMapClientTemplate().queryForList("findAllStarreinfo",map, offset, limit);
		if(list!=null){
			list.add(0, pageinfo);
		}
		return list;
	}
		
	/** 
	 * 根据Sql查找星级返点设置关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarreinfo(String sql,int limit,int offset){
		Map map = new HashMap();
		map.put("sql", sql);
		if(limit<0){
			limit = Integer.MAX_VALUE;
		}
		return getSqlMapClientTemplate().queryForList("findAllStarreinfoBySql",map, offset, limit);
	}
	
	
	/**
	 * 执行Sql 星级返点设置关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteStarreinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return getSqlMapClientTemplate().update("excuteStarreinfoBySql",map);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countStarreinfoBySql(String sql){
		Map map = new HashMap();
		map.put("sql", sql);
		return (Integer.parseInt(getSqlMapClientTemplate().queryForObject("countStarreinfoBySql",map).toString()));
	}
}

